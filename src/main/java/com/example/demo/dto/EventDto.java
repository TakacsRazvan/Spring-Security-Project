package com.example.demo.dto;

import com.example.demo.model.EventType;
import lombok.Builder;

@Builder
public record EventDto(
        EventType type,
        String name,
        String description,
        String contactEmail
        ) {}
