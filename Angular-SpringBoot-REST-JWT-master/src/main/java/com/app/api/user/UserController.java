package com.app.api.user;

import com.app.exception.BadRequestException;
import com.app.model.response.OperationResponse;
import com.app.model.user.UserResponse;
import com.app.model.user.Users;
import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static com.app.model.response.OperationResponse.ResponseStatusEnum;

@RestController
@Api(tags = {"Authentication"})
public class UserController {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "Gets current user information", response = UserResponse.class)
  @RequestMapping(value = "/user", method = RequestMethod.GET, produces = {"application/json"})
  public UserResponse getUserInformation(@RequestParam(value = "name", required = false) String userIdParam, HttpServletRequest req) {

    String loggedInUserId = userService.getLoggedInUserId();

    Users user;
    boolean provideUserDetails = false;

    if (Strings.isNullOrEmpty(userIdParam)) {
      provideUserDetails = true;
      user = userService.getLoggedInUser();
    } else if (loggedInUserId.equals(userIdParam)) {
      provideUserDetails = true;
      user = userService.getLoggedInUser();
    } else {
      //Check if the current user is superuser then provide the details of requested user
      provideUserDetails = true;
      user = userService.getUserInfoByUserId(userIdParam);
    }

    UserResponse resp = new UserResponse();
    if (provideUserDetails) {
      resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
    } else {
      resp.setOperationStatus(ResponseStatusEnum.NO_ACCESS);
      resp.setOperationMessage("No Access");
    }
    resp.setData(user);
    return resp;
  }


  @ApiOperation(value = "Add new user", response = OperationResponse.class)
  @RequestMapping(value = "/user", method = RequestMethod.POST, produces = {"application/json"})
  public OperationResponse addNewUser(@RequestBody Users user, HttpServletRequest req) {
    if (Objects.isNull(user) || Objects.isNull(user.getUserId())) {
      throw new BadRequestException();
    }
    boolean userAddSuccess = userService.addNewUser(user);
    OperationResponse resp = new OperationResponse();
    if (userAddSuccess == true) {
      resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
      resp.setOperationMessage("User Added");
    } else {
      resp.setOperationStatus(ResponseStatusEnum.ERROR);
      resp.setOperationMessage("Unable to add user");
    }
    return resp;
  }


}
