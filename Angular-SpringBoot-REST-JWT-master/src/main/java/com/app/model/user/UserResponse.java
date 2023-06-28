package com.app.model.user;

import lombok.*;
import com.app.model.response.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserResponse extends OperationResponse {
    private Users data = new Users();
}
