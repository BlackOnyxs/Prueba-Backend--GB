package com.microservice.people.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonResponse {

    private String completeName;
    private int ageInteger;
    private String ageRoman;
    private int status;

}
