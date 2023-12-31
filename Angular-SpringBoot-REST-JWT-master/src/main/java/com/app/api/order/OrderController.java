package com.app.api.order;

import com.app.Common;
import com.app.exception.BadRequestException;
import com.app.model.order.*;
import com.app.model.response.OperationResponse;
import com.app.repo.OrderInfoRepo;
import com.app.repo.OrderRepo;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.app.model.response.OperationResponse.ResponseStatusEnum;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Order"})
public class OrderController {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private OrderInfoRepo orderInfoRepo;
  @Autowired
  private OrderRepo orderRepo;


  @ApiOperation(value = "Update Order By Id", response = OrderResponse.class)
  @RequestMapping(value = "/orders/{Id}", method = RequestMethod.PUT)
  public OrderInfoResponse updateOrder(
    @PathVariable("Id") Integer Id,
    @RequestBody Order Order
  ) {
    if (Common.isEmptyObject(Order)) {
      throw new BadRequestException("");
    }
    OrderInfoResponse resp = new OrderInfoResponse();
    if (!this.orderRepo.exists(Id)) {
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage("Unable to update Resource - Resource is not existed");
    } else {
      var updateCus = this.orderRepo.findOne(Id);
      BeanUtils.copyProperties(Order, updateCus, "id");
      this.orderRepo.save(updateCus);
      resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
      resp.setOperationMessage("Resource Updated");
    }
    return resp;
  }

  @ApiOperation(value = "Update Partially Order", response = OperationResponse.class)
  @RequestMapping(value = "/orders/{Id}", method = RequestMethod.PATCH, produces = {"application/json"})
  public OperationResponse updatePartiallyCustomer(@PathVariable("Id") Integer Id, @RequestBody Map<Object, Object> requestBody, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    try {
      if (!this.orderRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to update Resource - Resource is not existed");
      } else {
        var updateCus = this.orderRepo.findOne(Id);
        requestBody.forEach((k, v) -> {
          Field field = ReflectionUtils.findField(Order.class, k.toString());
          field.setAccessible(true);
          ReflectionUtils.setField(field, updateCus, v);
        });
        this.orderRepo.save(updateCus);
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

  @ApiOperation(value = "List of orders", response = OrderResponse.class)
  @RequestMapping(value = "/orders", method = RequestMethod.GET)
  public OrderInfoResponse getOrdersByPage(
    @ApiParam(value = "") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
    @ApiParam(value = "between 1 to 1000") @RequestParam(value = "size", defaultValue = "20", required = false) Integer size,
    @RequestParam(value = "orderid", required = false) Integer orderId,
    @RequestParam(value = "customerid", required = false) Integer customerId,
    @RequestParam(value = "employeeid", required = false) Integer employeeId,
    @RequestParam(value = "status", required = false) String orderStatus,
    Pageable pageable
  ) {
    OrderInfoResponse resp = new OrderInfoResponse();
    OrderInfo qry = new OrderInfo();
    if (orderId != null) {
      qry.setOrderId(orderId);
    }
    if (customerId != null) {
      qry.setCustomerId(customerId);
    }
    if (employeeId != null) {
      qry.setEmployeeId(employeeId);
    }
    if (orderStatus != null) {
      qry.setOrderStatus(orderStatus);
    }
    boolean isDefault = false;
    if (pageable.getSort() == null) {
      isDefault = true;
      pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "orderId");
    }
    Page<OrderInfo> pg = orderInfoRepo.findAll(org.springframework.data.domain.Example.of(qry), pageable);
    resp.setPageStats(pg, true,isDefault );
    resp.setItems(pg.getContent());
    return resp;
  }


  @ApiOperation(value = "Order Details", response = OrderDetailResponse.class)
  @RequestMapping(value = "/order-details", method = RequestMethod.GET)
  public OrderDetailResponse getOrderDetail(@RequestParam(value = "orderid", required = false) Integer orderId) {
    long prevOrderId = -1, newOrderId;
    OrderDetail orderDetail = new OrderDetail();
    int itemCount = 0;

    OrderDetailResponse resp = new OrderDetailResponse();
    resp.setItems(new ArrayList<OrderDetail>());
    String sql = " select order_id, product_id   , customer_id   , order_date, order_status  , shipped_date    , employee_id , payment_type, paid_date, "
      + " ship_name      , ship_address1, ship_address2 , ship_city , ship_state    , ship_postal_code, ship_country, "
      + " product_code   , product_name , category      , quantity  , unit_price    , discount        , date_allocated, order_item_status, "
      + " shipping_fee   , customer_name, customer_email, customer_company from order_details ";
    String where = " where 1 = 1 ";
    String order = " order by order_id, product_id ";
    if (orderId != null) {
      where = where + " and order_id = " + orderId;
    }

    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql + where + order);
    for (Map<String, Object> row : list) {
      newOrderId = (int) row.get("order_id");
      if (prevOrderId != newOrderId) {
        itemCount++;

        orderDetail = new OrderDetail(
          (int) row.get("order_id"),
          (Date) row.get("order_date"),
          (String) row.get("order_status"),
          (Date) row.get("shipped_date"),
          (String) row.get("ship_name"),
          (String) row.get("ship_address1"),
          (String) row.get("ship_address2"),
          (String) row.get("ship_city"),
          (String) row.get("ship_state"),
          (String) row.get("ship_postal_code"),
          (String) row.get("ship_country"),
          (BigDecimal) row.get("shipping_fee"),
          (Integer) row.get("customer_id"),
          (String) row.get("customer_name"),
          (String) row.get("customer_email"),
          (String) row.get("company"),
          (String) row.get("payment_type"),
          (Date) row.get("paid_date"),
          (int) row.get("employee_id")
        );
        orderDetail.addOrderLine(
          (int) row.get("product_id"),
          (String) row.get("product_code"),
          (String) row.get("product_name"),
          (String) row.get("category"),
          (BigDecimal) row.get("quantity"),
          (BigDecimal) row.get("unit_price"),
          (BigDecimal) row.get("discount"),
          (Date) row.get("date_allocated"),
          (String) row.get("order_item_status")
        );
        resp.getItems().add(orderDetail);
        prevOrderId = newOrderId;
      } else {
        orderDetail.addOrderLine(
          (int) row.get("product_id"),
          (String) row.get("product_code"),
          (String) row.get("product_name"),
          (String) row.get("category"),
          (BigDecimal) row.get("quantity"),
          (BigDecimal) row.get("unit_price"),
          (BigDecimal) row.get("discount"),
          (Date) row.get("date_allocated"),
          (String) row.get("order_item_status")
        );
      }
    }
    resp.setPageTotal(itemCount, true);
    return resp;
  }

}
