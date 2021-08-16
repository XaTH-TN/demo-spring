package com.demo.demoSpring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/uuid")
public class UuidController {

    @GetMapping("/{num}")
    public ResponseEntity<?> getUuId(@PathVariable("num") int num) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            List<String> data = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                data.add(UUID.randomUUID().toString());
            }

            res.put("status", true);
            res.put("error", null);
            res.put("data", data);

            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("status", true);
            res.put("error", e.getMessage());
            res.put("data", null);
            return ResponseEntity.ok(res);

        }


    }
}
