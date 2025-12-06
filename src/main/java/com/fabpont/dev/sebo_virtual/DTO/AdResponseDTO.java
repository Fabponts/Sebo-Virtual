package com.fabpont.dev.sebo_virtual.DTO;

import com.fabpont.dev.sebo_virtual.Enum.AdStatus;
import com.fabpont.dev.sebo_virtual.Enum.BookConditionStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AdResponseDTO {
    private Long id;
    private BookDTO book;
    private UserRegisterDTO user;
    private BigDecimal price;
    private BookConditionStatus bookCondition;
    private LocalDate adDate;
    private AdStatus adStatus;
}
