package com.daydream.platform.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("item table")
public class Item implements Serializable {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("user_id")
    private String userId;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("price")
    private float price;
}
