package com.app.api.employee;

import com.app.Common;
import com.app.exception.BadRequestException;
import com.app.model.employee.Employee;
import com.app.model.employee.EmployeeResponse;
import com.app.model.response.OperationResponse;
import com.app.repo.EmployeeRepo;
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
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

import static com.app.model.response.OperationResponse.ResponseStatusEnum;

@RestController
@Transactional
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Employee"})
public class EmployeeController {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private EmployeeRepo employeeRepo;

  @ApiOperation(value = "List of employees", response = EmployeeResponse.class)
  @RequestMapping(value = "/employees", method = RequestMethod.GET)
  public EmployeeResponse getEmployeesByPage(
    @ApiParam(value = "") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
    @ApiParam(value = "between 1 to 1000") @RequestParam(value = "size", defaultValue = "20", required = false) Integer size,
    @RequestParam(value = "employeeid", required = false) Integer employeeId,
    Pageable pageable
  ) {
    EmployeeResponse resp = new EmployeeResponse();
    Employee qry = new Employee();
    if (employeeId != null) {
      qry.setId(employeeId);
    }
    boolean isDefault = false;
    if (pageable.getSort() == null) {
      isDefault = true;
      pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "id");
    }
    Page<Employee> pg = employeeRepo.findAll(org.springframework.data.domain.Example.of(qry), pageable);
    resp.setPageStats(pg, true, isDefault);
    resp.setItems(pg.getContent());
    return resp;
  }

  @ApiOperation(value = "Add new employee", response = OperationResponse.class)
  @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = {"application/json"})
  public OperationResponse addNewEmployee(@RequestBody Employee employee, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(employee) || Objects.isNull(employee.getId())) {
      throw new BadRequestException();
    }
    if (this.employeeRepo.exists(employee.getId())) {
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage("Unable to add Employee - Employee allready exist ");
    } else {
      Employee addedEmployee = this.employeeRepo.save(employee);
      resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
      resp.setOperationMessage("Employee Added");
    }
    return resp;
  }


  @ApiOperation(value = "Delete a Employee", response = OperationResponse.class)
  @RequestMapping(value = "/Employees/{employeeId}", method = RequestMethod.DELETE, produces = {"application/json"})
  public OperationResponse deleteEmployee(@PathVariable("employeeId") Integer employeeId, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    try {
      if (this.employeeRepo.exists(employeeId)) {
        this.employeeRepo.delete(employeeId);
        resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        resp.setOperationMessage("Employee Deleted");
      } else {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("No Employee Exist");
      }
    } catch (Exception ge) {
      System.out.println("========= MRIN GENERIC EXCEPTION ============");
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage(ge.getMessage());
    }

    return resp;
  }

  @ApiOperation(value = "Update Employee", response = OperationResponse.class)
  @RequestMapping(value = "/Employees/{Id}", method = RequestMethod.PUT, produces = {"application/json"})
  public OperationResponse updateEmployee(@PathVariable("Id") Integer Id, @RequestBody Employee employee, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(employee) || Common.isEmptyObject(employee)) {
      throw new BadRequestException();
    }
    try {
      if (!this.employeeRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to update Resource - Resource is not existed");
      } else {
        var updateCus = this.employeeRepo.findOne(Id);
        BeanUtils.copyProperties(employee, updateCus, "id");
        this.employeeRepo.save(updateCus);
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

  @ApiOperation(value = "Update Partially Employee", response = OperationResponse.class)
  @RequestMapping(value = "/Employee/{Id}", method = RequestMethod.PATCH, produces = {"application/json"})
  public OperationResponse updatePartiallyCustomer(@PathVariable("Id") Integer Id, @RequestBody Map<Object, Object> requestBody, HttpServletRequest req) {
    OperationResponse resp = new OperationResponse();
    if (Objects.isNull(requestBody) || requestBody.isEmpty()) {
      throw new BadRequestException();
    }
    try {
      if (!this.employeeRepo.exists(Id)) {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to update Resource - Resource is not existed");
      } else {
        var updateCus = this.employeeRepo.findOne(Id);
        requestBody.forEach((k, v) -> {
          Field field = ReflectionUtils.findField(Employee.class, k.toString());
          field.setAccessible(true);
          ReflectionUtils.setField(field, updateCus, v);
        });
        this.employeeRepo.save(updateCus);
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
