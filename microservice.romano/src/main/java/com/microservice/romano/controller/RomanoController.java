package com.microservice.romano.controller;

import com.microservice.romano.service.RomanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/romano")
public class RomanoController {

    @Autowired
    private RomanoService romanoService;
    @GetMapping("/{numero}")
    public ResponseEntity<String> generateRomano(@PathVariable int number){
        try {
            System.out.println(number);
            String roman = romanoService.convertToRoman(number);
            return ResponseEntity.ok(roman);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
