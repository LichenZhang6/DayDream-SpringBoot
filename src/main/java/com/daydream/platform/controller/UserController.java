package com.daydream.platform.controller;

import com.daydream.platform.web.Response;
import com.daydream.platform.crud.UserCreate;
import com.daydream.platform.crud.UserModify;
import com.daydream.platform.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("user management")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("create users")
    @PostMapping("/create")
    public ResponseEntity<ModelMap> create(@RequestBody UserCreate create) {
        return Response.ok(userService.create(create));
    }

    @ApiOperation("delete users")
    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> deleteById(@PathVariable String id) {
        return Response.ok(userService.deleteById(id));
    }

    @ApiOperation("modify users")
    @PutMapping("/modify")
    public ResponseEntity<ModelMap> modify(@RequestBody UserModify userModify) {
        return Response.ok(userService.modify(userModify));
    }

    @ApiOperation("get users by id")
    @GetMapping("/{id}")
    public ResponseEntity<ModelMap> getById(@PathVariable String id) {
        return Response.ok(userService.getById(id));
    }

    @ApiOperation("page")
    @GetMapping("/page")
    public ResponseEntity<ModelMap> page(@RequestParam(value = "start", defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size) {
        return Response.ok(userService.page(start, size));
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
