package com.fabpont.dev.sebo_virtual.DTO;

import jakarta.validation.constraints.NotEmpty;

public record UserRegisterDTO(@NotEmpty(message = "Insira um nome" )String name,
                              @NotEmpty(message = "Insira um nome" )String email,
                              @NotEmpty(message = "Insira um nome" )String password,
                              @NotEmpty(message = "Insira um nome" )String phoneNumber,
                              @NotEmpty(message = "Insira um nome" )String address) {
}
