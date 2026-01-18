package com.assu.server.domain.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


public record NotificationSettingsResponseDTO (
        Map<String, Boolean> settings
){}
