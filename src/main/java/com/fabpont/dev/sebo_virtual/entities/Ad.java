package com.fabpont.dev.sebo_virtual.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
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

    @NotBlank
    @Size(max = 20)
    private String bookCondition;

    @NotNull
    private LocalDate adDate;

    @NotNull
    private String adStatus;

    public Ad() {
    }
    public Ad(Book book, User user, BigDecimal price, String bookCondition, LocalDate adDate,  String adStatus) {
        this.bookCondition = bookCondition;
        this.adDate = adDate;
        this.price = price;
        this.book = book;
        this.user = user;
        this.adStatus = adStatus;
    }
}
