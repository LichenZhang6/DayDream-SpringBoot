package com.daydream.platform.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("user table")
@Data
public class User implements Serializable {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("age")
    private int age;
}
