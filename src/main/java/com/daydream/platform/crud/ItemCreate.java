package com.daydream.platform.crud;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("item create")
public class ItemCreate implements Serializable {

    @ApiModelProperty("user_id")
    private String userId;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("price")
    private float price;
}
