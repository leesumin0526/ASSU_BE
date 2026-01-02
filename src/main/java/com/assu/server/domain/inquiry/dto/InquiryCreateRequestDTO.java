package com.assu.server.domain.inquiry.dto;

import jakarta.validation.constraints.NotBlank;

public record InquiryCreateRequestDTO (
        @NotBlank(message = "title은 비어 있을 수 없습니다.")
        String title,

        @NotBlank(message = "content는 비어 있을 수 없습니다.")
        String content,

        @NotBlank(message = "email은 비어 있을 수 없습니다.")
        String email
){ }
