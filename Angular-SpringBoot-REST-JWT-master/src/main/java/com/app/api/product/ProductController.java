package com.app.api.product;

import com.app.exception.BadRequestException;
import com.app.model.product.Product;
import com.app.model.product.ProductResponse;
import com.app.model.response.OperationResponse;
import com.app.repo.ProductRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

import static com.app.model.response.OperationResponse.ResponseStatusEnum;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Products"})
public class ProductController {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private ProductRepo productRepo;

  @ApiOperation(value = "List of products", response = ProductResponse.class)
  @RequestMapping(value = "/products", method = RequestMethod.GET)
  public ProductResponse getProductsByPage(
    @ApiParam(value = "") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
    @ApiParam(value = "between 1 to 1000") @RequestParam(value = "size", defaultValue = "20", required = false) Integer size,
    @RequestParam(value = "productid", required = false) Integer productId,
    @RequestParam(value = "category", required = false) String category,
    Pageable pageable
  ) {
    ProductResponse resp = new ProductResponse();
    Product qry = new Product();
    if (productId != null) {
      qry.setId(productId);
    }
    if (category != null) {
      qry.setCategory(category);
    }
    boolean isDefault = false;
    if (pageable.getSort() == null) {
      isDefault = true;
      pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "id");
    }
    Page<Product> productPage = productRepo.findAll(org.springframework.data.domain.Example.of(qry), pageable);
    resp.setPageStats(productPage, true, isDefault);
    resp.setItems(productPage.getContent());
    return resp;
  }

  @ApiOperation(value = "Add new product", response = OperationResponse.class)
  @RequestMapping(value = "/products", method = RequestMethod.POST, produces = {"application/json"})
  public OperationResponse addNewProduct(@RequestBody Product product, HttpServletRequest req) {

    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(product) || Objects.isNull(product.getId())) {
      throw new BadRequestException();
    }
    if (this.productRepo.exists(product.getId())) {
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage("Unable to add Product - Product allready exist ");
    } else {
      //Product addedProduct = this.productRepo.save(product);
      this.productRepo.save(product);
      resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
      resp.setOperationMessage("Product Added");
    }
    return resp;
  }

  @ApiOperation(value = "Delete a product", response = OperationResponse.class)
  @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE, produces = {"application/json"})
  public OperationResponse deleteProduct(@PathVariable("productId") Integer productId, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (this.productRepo.exists(productId)) {
      this.productRepo.delete(productId);
      resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
      resp.setOperationMessage("Product Deleted");
    } else {
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage("No Product Exist");
    }
    return resp;
  }


  @ApiOperation(value = "Update Product", response = OperationResponse.class)
  @RequestMapping(value = "expected/Products/{Id}", method = RequestMethod.PUT, produces = {"application/json"})
  public OperationResponse updateResource(@PathVariable("Id") Integer Id, @RequestBody Product product, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(product)) {
      throw new BadRequestException();
    }
    try {
      if (!this.productRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to update Resource - Resource is not existed");
      } else {
        var updateCus = this.productRepo.findOne(Id);
        BeanUtils.copyProperties(product, updateCus, "id");
        this.productRepo.save(updateCus);
        resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        resp.setOperationMessage("Resource Updated");
      }
    } catch (Exception e) {
      System.out.println("========= MRIN GENERIC EXCEPTION ============");
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage(e.getMessage());
    }
    return resp;
  }

  @ApiOperation(value = "Update Partially Products", response = OperationResponse.class)
  @RequestMapping(value = "expected/Products/{Id}", method = RequestMethod.PATCH, produces = {"application/json"})
  public OperationResponse updatePartiallyCustomer(@PathVariable("Id") Integer Id, @RequestBody Map<Object, Object> requestBody, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(requestBody)) {
      throw new BadRequestException();
    }
    try {
      if (!this.productRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to update Resource - Resource is not existed");
      } else {
        var updateCus = this.productRepo.findOne(Id);
        requestBody.forEach((k, v) -> {
          Field field = ReflectionUtils.findField(Product.class, k.toString());
          field.setAccessible(true);
          ReflectionUtils.setField(field, updateCus, v);
        });
        this.productRepo.save(updateCus);
        resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        resp.setOperationMessage("Resource Updated");
      }
    } catch (Exception e) {
      System.out.println("========= MRIN GENERIC EXCEPTION ============");
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage(e.getMessage());
    }
    return resp;
  }
}
