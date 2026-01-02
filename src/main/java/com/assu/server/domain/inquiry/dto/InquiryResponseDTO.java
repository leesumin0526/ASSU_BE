package com.assu.server.domain.inquiry.dto;
import com.assu.server.domain.inquiry.entity.Inquiry;
import java.time.LocalDateTime;

public record InquiryResponseDTO(
        Long id,
        String title,
        String content,
        String email,
        String status,
        String answer,
        LocalDateTime createdAt
) {
    public static InquiryResponseDTO from(Inquiry inquiry) {
        return new InquiryResponseDTO(
                inquiry.getId(),
                inquiry.getTitle(),
                inquiry.getContent(),
                inquiry.getEmail(),
                inquiry.getStatus().name(),
                inquiry.getAnswer(),
                inquiry.getCreatedAt()
        );
    }
}