package com.delivery.food_monolith.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationErrorResponse {
    private int status;
    private Map<String, String> errors;
}
