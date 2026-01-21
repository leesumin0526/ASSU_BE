package com.assu.server.domain.review.converter;

import com.assu.server.domain.partner.entity.Partner;
import com.assu.server.domain.review.dto.ReviewRequestDTO;
import com.assu.server.domain.review.dto.ReviewResponseDTO;
import com.assu.server.domain.review.entity.Review;
import com.assu.server.domain.review.entity.ReviewPhoto;
import com.assu.server.domain.store.entity.Store;
import com.assu.server.domain.user.entity.Student;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public class ReviewConverter {
    public static ReviewResponseDTO.WriteReviewResponseDTO writeReviewResultDTO(Review review){
        return ReviewResponseDTO.WriteReviewResponseDTO.builder()
                .reviewId(review.getId())
                .rate(review.getRate())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .reviewImageUrls(review.getImageList().stream()
                        .map(ReviewPhoto::getPhotoUrl)
                        .collect(Collectors.toList()))
                .build();
    }
    public static Review toReviewEntity(ReviewRequestDTO.WriteReviewRequestDTO  request, Store store, Partner partner, Student student, String affiliation) {
        return Review.builder()
                .rate(request.getRate())
                .content(request.getContent())
                .store(store)
            .affiliation(affiliation)
                .partner(partner)
                .student(student)
                .build();
    }
    public static ReviewResponseDTO.CheckReviewResponseDTO checkReviewResultDTO(Review review){
        return ReviewResponseDTO.CheckReviewResponseDTO.builder()
                .reviewId(review.getId())
                .rate(review.getRate())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .storeName(review.getStore().getName())
                .affiliation(review.getAffiliation())
                .storeId(review.getStore().getId())
                .reviewImageUrls(review.getImageList().stream()
                        .map(ReviewPhoto::getPhotoUrl)
                        .collect(Collectors.toList()))
                .build();
    }


    public static Page<ReviewResponseDTO.CheckReviewResponseDTO> checkReviewResultDTO(Page<Review> reviews){
        return reviews.map(ReviewConverter::checkReviewResultDTO);
    }
}