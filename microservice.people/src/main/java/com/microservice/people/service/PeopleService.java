package com.microservice.people.service;

import com.microservice.people.Client.RomanoClient;
import com.microservice.people.entities.Person;
import com.microservice.people.http.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Service
public class PeopleService implements IPeopleService{

    @Autowired
    private RomanoClient romanoClient;
    @Override
    public PersonResponse getPersonAge(Person person ) {
        validateName(person.getFirstName(), person.getLastname());
        int age = validateAge(person.getBornDate());
        validateCip(person.getCip());

        String romanAge = romanoClient.getRomanNumber(age);

        return PersonResponse.builder()
                .completeName( person.getFirstName() + person.getLastname() )
                .ageInteger( age )
                .ageRoman( romanAge )
                .status(200)
                .build();
    }


    private void validateName(String name, String lastname) {
        if (!name.matches("[\\u00F1A-Za-z _]*[\\u00F1A-Za-z][\\u00F1A-Za-z _]*") ||
                !lastname.matches("[\\u00F1A-Za-z _]*[\\u00F1A-Za-z][\\u00F1A-Za-z _]*")) {
            throw new IllegalArgumentException("El nombre o Apellido contiene caracteres inválidos.");
        }
    }


    private int validateAge(LocalDate bornDate) {
        LocalDate today = LocalDate.now();

        if ( (today.getYear() - bornDate.getYear()) >= 1 || (today.getYear() - bornDate.getYear()) <= 50 ) {
            throw new IllegalArgumentException("El rango de edad es 18 - 50 años");
        }else {
            return today.getYear() - bornDate.getYear();
        }
    }

    private void validateCip(String cip) {
        if (!Pattern.matches("\\d{2}-\\d{4}-\\d{4}", cip)) {
            throw new IllegalArgumentException("Formato de cédula inválido");
        }
    }
}
