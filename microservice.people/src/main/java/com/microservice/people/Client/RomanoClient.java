package com.microservice.people.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "msvc-romano", url = "localhost:8082/api/romano")
public interface RomanoClient {
    @GetMapping("/{numero}")
    String getRomanNumber(@PathVariable int number);
}
