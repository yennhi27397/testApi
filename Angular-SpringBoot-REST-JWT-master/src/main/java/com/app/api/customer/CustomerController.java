package com.app.api.customer;

import com.app.Common;
import com.app.exception.BadRequestException;
import com.app.exception.BankBadRequestException;
import com.app.model.bank.Transaction;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerResponse;
import com.app.model.customer.WithdrawRequest;
import com.app.model.response.OperationResponse;
import com.app.repo.BankRepo;
import com.app.repo.CustomerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.app.model.response.OperationResponse.ResponseStatusEnum;

@RestController
@Transactional
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Customers"})
public class CustomerController {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private CustomerRepo customerRepo;
  @Autowired
  private BankRepo bankRepo;

  @ApiOperation(value = "List of customers", response = CustomerResponse.class)
  @RequestMapping(value = "/customers", method = RequestMethod.GET)
  public CustomerResponse getCustomersByPage(
    @ApiParam(value = "") @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
    @ApiParam(value = "between 1 to 1000") @RequestParam(value = "size", defaultValue = "20", required = false) Integer size,
    @RequestParam(value = "customerid", required = false) Integer customerId,
    @RequestParam(value = "company", required = false) String company,
    @RequestParam(value = "country", required = false) String country,
    Pageable pageable
  ) {
    CustomerResponse resp = new CustomerResponse();
    Customer qry = new Customer();
    if (customerId != null) {
      qry.setId(customerId);
    }
    if (company != null) {
      qry.setCompany(company);
    }
    if (country != null) {
      qry.setCountry(country);
    }
    boolean isDefault = false;
    if (pageable.getSort() == null) {
      pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "id");
      isDefault = true;
    }
    Page<Customer> pg = customerRepo.findAll(org.springframework.data.domain.Example.of(qry), pageable);
    resp.setPageStats(pg, true, isDefault);
    resp.setItems(pg.getContent());
    return resp;
  }

  @ApiOperation(value = "Add new customer", response = OperationResponse.class)
  @RequestMapping(value = "/customers", method = RequestMethod.POST, produces = {"application/json"})
  public OperationResponse addNewCustomer(@RequestBody Customer customer, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(customer) || Objects.isNull(customer.getId())) {
      throw new BadRequestException();
    }
    if (this.customerRepo.exists(customer.getId())) {
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage("Unable to add Customer - Customer allready exist ");
    } else {
      Customer addedCustomer = this.customerRepo.save(customer);
      resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
      resp.setOperationMessage("Customer Added");
    }
    return resp;
  }


  @ApiOperation(value = "Delete a customer", response = OperationResponse.class)
  @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE, produces = {"application/json"})
  public OperationResponse deleteCustomer(@PathVariable("customerId") Integer customerId, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    try {
      if (this.customerRepo.exists(customerId)) {
        this.customerRepo.delete(customerId);
        resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        resp.setOperationMessage("Customer Deleted");
      } else {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("No Customer Exist");
      }
    } catch (Exception ge) {
      System.out.println("========= MRIN GENERIC EXCEPTION ============");
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage(ge.getMessage());
    }

    return resp;
  }

  @ApiOperation(value = "Update customer", response = OperationResponse.class)
  @RequestMapping(value = "/customers/{Id}", method = RequestMethod.PUT, produces = {"application/json"})
  public OperationResponse updateCustomer(@PathVariable("Id") Integer Id, @RequestBody Customer customer, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(customer) || Common.isEmptyObject(customer)) {
      throw new BadRequestException();
    }
    try {
      if (!this.customerRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to update Resource - Resource is not existed");
      } else {
        Customer updateCus = this.customerRepo.findOne(Id);
        BeanUtils.copyProperties(customer, updateCus, "id");
        this.customerRepo.save(updateCus);
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

  @ApiOperation(value = "Get customer and Balance", response = CustomerResponse.class)
  @RequestMapping(value = "/customers/{Id}", method = RequestMethod.GET, produces = {"application/json"})
  public CustomerResponse getCustomerInfo(@PathVariable("Id") Integer Id, HttpServletRequest req) {
    CustomerResponse resp = new CustomerResponse();
    if (Objects.isNull(Id)) {
      throw new BadRequestException();
    }
    try {
      if (!this.customerRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to Get Resource - Resource is not existed");
      } else {
        Customer customer = this.customerRepo.findOne(Id);

        customer.setBalance(bankRepo.getBalance(Id.toString()).getBalance());
        resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        resp.setItems(List.of(customer));
      }
    } catch (Exception e) {
      System.out.println("========= MRIN GENERIC EXCEPTION ============");
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage(e.getMessage());
    }
    return resp;
  }

  @ApiOperation(value = "Withdraw money of Customer", response = CustomerResponse.class)
  @RequestMapping(value = "/customers/withdraw", method = RequestMethod.POST, produces = {"application/json"})
  public Object withdrawCustomerMoney(@RequestBody WithdrawRequest withdrawRequest, HttpServletRequest req) throws IOException {
    CustomerResponse resp = new CustomerResponse();
    if (Objects.isNull(withdrawRequest.getAccountId())) {
      throw new BadRequestException();
    }
    if (!this.customerRepo.exists(withdrawRequest.getAccountId())) {
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage("Unable to Get Resource - Resource is not existed");
    } else {
      return bankRepo.withdraw(withdrawRequest.getAccountId().toString(), withdrawRequest.getAmount());
    }
    return resp;
  }

  @ApiOperation(value = "Update Partially Customer", response = OperationResponse.class)
  @RequestMapping(value = "/customers/{Id}", method = RequestMethod.PATCH, produces = {"application/json"})
  public OperationResponse updatePartiallyCustomer(@PathVariable("Id") Integer Id, @RequestBody Map<Object, Object> requestBody, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(requestBody) || requestBody.isEmpty()) {
      throw new BadRequestException();
    }
    try {
      if (!this.customerRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to update Resource - Resource is not existed");
      } else {
        Customer updateCus = this.customerRepo.findOne(Id);
        requestBody.forEach((k, v) -> {
          Field field = ReflectionUtils.findField(Customer.class, k.toString());
          field.setAccessible(true);
          ReflectionUtils.setField(field, updateCus, v);
        });
        this.customerRepo.save(updateCus);
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
