package com.daydream.platform.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;

public class Response {

    public static <T> ResponseEntity<ModelMap> ok() {
        return ok(null);
    }

    public static <T> ResponseEntity<ModelMap> ok(T data) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", data);
        modelMap.put("statue", HttpStatus.OK);
        modelMap.put("time", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(modelMap);
    }

    public static <T> ResponseEntity<ModelMap> cs(HttpStatus status, Object data, Object message) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", data);
        modelMap.put("statue", status);
        modelMap.put("time", LocalDateTime.now());
        modelMap.put("message", message);
        return ResponseEntity.status(status).body(modelMap);
    }
}
