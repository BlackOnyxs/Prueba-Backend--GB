package com.microservice.people.contoller;

import com.microservice.people.entities.Person;
import com.microservice.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persona")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping("/test")
    public ResponseEntity<Object> validatePerson(@RequestBody Person person ) {
        try {
            return ResponseEntity.ok( peopleService.getPersonAge( person ) );
        }catch ( IllegalArgumentException e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
