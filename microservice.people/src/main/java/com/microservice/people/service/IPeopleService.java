package com.microservice.people.service;

import com.microservice.people.entities.Person;
import com.microservice.people.http.response.PersonResponse;

import java.time.LocalDate;

public interface IPeopleService {

    PersonResponse getPersonAge(Person person );
}
