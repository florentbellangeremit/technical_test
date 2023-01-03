package com.bellanger.technical_test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Timestamp time;
}
