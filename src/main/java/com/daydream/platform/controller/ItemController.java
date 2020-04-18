package com.daydream.platform.controller;

import com.daydream.platform.crud.ItemCreate;
import com.daydream.platform.crud.ItemModify;
import com.daydream.platform.service.ItemService;
import com.daydream.platform.web.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("item management")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @ApiOperation("create items")
    @PostMapping("/create")
    public ResponseEntity<ModelMap> create(@RequestBody ItemCreate itemCreate) {
        return Response.ok(itemService.create(itemCreate));
    }

    @ApiModelProperty("delete items")
    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> deleteById(@PathVariable String id) {
        return Response.ok(itemService.deleteById(id));
    }

    @ApiModelProperty("modify items")
    @PutMapping("/modify")
    public ResponseEntity<ModelMap> modify(@RequestBody ItemModify itemModify) {
        return Response.ok(itemService.modify(itemModify));
    }

    @ApiModelProperty("get items")
    @GetMapping("/{id}")
    public ResponseEntity<ModelMap> getById(@PathVariable String id) {
        return Response.ok(itemService.getById(id));
    }

    @ApiModelProperty("page")
    @GetMapping("/page")
    public ResponseEntity<ModelMap> page(@RequestParam(value = "start", defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size) {
        return Response.ok(itemService.page(start, size));
    }
}
