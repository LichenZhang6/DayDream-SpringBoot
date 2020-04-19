package com.daydream.platform.crud;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("user create")
public class UserCreate {

    @ApiModelProperty("username")
    private String username;

    @ApiModelProperty("password")
    private String password;
}
