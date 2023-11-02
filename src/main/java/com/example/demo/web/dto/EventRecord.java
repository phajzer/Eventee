package com.example.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record EventRecord(Long id, String name, LocalDateTime startTime, LocalDateTime endTime, String description) {
}
