package com.assu.server.domain.inquiry.dto;

import jakarta.validation.constraints.NotBlank;

public record InquiryAnswerRequestDTO (
        @NotBlank(message = "answer는 비어 있을 수 없습니다.")
        String answer
) {}