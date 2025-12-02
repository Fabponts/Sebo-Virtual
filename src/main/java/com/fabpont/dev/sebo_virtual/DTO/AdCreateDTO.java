package com.fabpont.dev.sebo_virtual.DTO;

import com.fabpont.dev.sebo_virtual.Enum.AdStatus;
import com.fabpont.dev.sebo_virtual.Enum.BookConditionStatus;
import com.fabpont.dev.sebo_virtual.entities.Book;
import com.fabpont.dev.sebo_virtual.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AdDTO {
    private Book book;
    private User user;
    private BigDecimal price;
    private BookConditionStatus bookCondition;
    private LocalDate adDate;
    private AdStatus adStatus;
}
