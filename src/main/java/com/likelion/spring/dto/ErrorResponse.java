package com.likelion.spring.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private String timestamp;

    private String status;

    private String error;

    private String message;

    private String path;
}
