package com.fabpont.dev.sebo_virtual.DTO;

import com.fabpont.dev.sebo_virtual.Enum.AdStatus;
import com.fabpont.dev.sebo_virtual.Enum.BookConditionStatus;
import com.fabpont.dev.sebo_virtual.entities.Ad;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AdResponseDTO(
            Long id,
            Long userId,
            String userName,
            Long bookId,
            String bookTitle,
            BigDecimal price,
            BookConditionStatus bookCondition,
            AdStatus status,
            LocalDateTime createdAt
    ) {
        // Esse é o "fromEntity" que estava faltando
        public static AdResponseDTO fromEntity(Ad ad) {
            return new AdResponseDTO(
                    ad.getId(),
                    ad.getUser().getId(),
                    ad.getUser().getName(),
                    ad.getBook().getId(),
                    ad.getBook().getTitle(),
                    ad.getPrice(),
                    ad.getBookCondition(),
                    ad.getAdStatus(),
                    ad.getAdDate()
            );
        }
    }
}
