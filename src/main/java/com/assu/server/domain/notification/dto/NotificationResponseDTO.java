package com.assu.server.domain.notification.dto;

import java.time.LocalDateTime;


public record NotificationResponseDTO (
     Long id,
     String type,
     Long refId,
     String title,
     String messagePreview,
     String deeplink,
     boolean isRead,
     LocalDateTime createdAt,
     LocalDateTime readAt,
     String timeAgo
){}

