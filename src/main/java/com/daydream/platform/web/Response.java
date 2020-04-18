package com.daydream.platform.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;

public class Response {

    public static <T>ResponseEntity<ModelMap> ok(T data) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", data);
        modelMap.put("statue", HttpStatus.OK);
        modelMap.put("time", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(modelMap);
    }
}
