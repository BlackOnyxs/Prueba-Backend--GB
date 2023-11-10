package com.microservice.romano.service;

import org.springframework.stereotype.Service;

@Service
public class RomanoService {


    public String convertToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("El número debe estar en el rango de 1 a 3999");
        }

        StringBuilder result = new StringBuilder();

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                result.append(romanNumerals[i]);
                number -= values[i];
            }
        }

        return result.toString();
    }
}
