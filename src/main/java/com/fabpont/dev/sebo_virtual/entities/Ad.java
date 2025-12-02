package com.fabpont.dev.sebo_virtual.entities;

import com.fabpont.dev.sebo_virtual.Enum.AdStatus;
import com.fabpont.dev.sebo_virtual.Enum.BookConditionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ad")
@Getter
@Setter
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BookConditionStatus bookCondition;

    @NotNull
    private LocalDate adDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AdStatus adStatus;

    public Ad() {
    }
    public Ad(Book book, User user, BigDecimal price, BookConditionStatus bookCondition, LocalDate adDate,  AdStatus adStatus) {
        this.bookCondition = bookCondition;
        this.adDate = adDate;
        this.price = price;
        this.book = book;
        this.user = user;
        this.adStatus = adStatus;
    }
}
