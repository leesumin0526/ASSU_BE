package com.assu.server.domain.notification.dto;

import java.util.Map;

public record NotificationMessageDTO (
     String idempotencyKey,
     Long receiverId,
     String title,
     String body,
     Map<String, String> data
){}
