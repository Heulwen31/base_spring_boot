package com.heulwen.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api")
public class CommonController {
    @GetMapping("value")
    public ResponseEntity<?> getValue() {
        return ResponseEntity.ok("heulwen");
    }

    @GetMapping("message-resource")
    public ResponseEntity<?> getMessageResource() {
        double rs = 1 / 0;
        return ResponseEntity.ok(rs);
    }
}
