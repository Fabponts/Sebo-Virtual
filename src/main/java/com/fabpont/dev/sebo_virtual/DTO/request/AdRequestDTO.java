package com.fabpont.dev.sebo_virtual.DTO.request;

import com.fabpont.dev.sebo_virtual.Enum.BookConditionStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AdRequestDTO {
    private Long bookId;
    private Long useId;
    private BigDecimal price;
    private BookConditionStatus bookCondition;
}
