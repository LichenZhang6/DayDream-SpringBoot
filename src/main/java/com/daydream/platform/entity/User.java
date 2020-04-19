package com.daydream.platform.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("user table")
public class User implements Serializable {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("name")
    private String username;

    @ApiModelProperty("password")
    private String password;
}
