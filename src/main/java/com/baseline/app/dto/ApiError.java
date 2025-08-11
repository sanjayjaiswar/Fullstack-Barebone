package com.baseline.app.dto;

public record ApiError(int status, String message, long timestamp) {}
