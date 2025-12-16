package com.fabpont.dev.sebo_virtual.DTO;

import jakarta.validation.constraints.NotEmpty;

public record UserLoginDTO(@NotEmpty(message = "email é obrigatorio") String email,
                           @NotEmpty(message = "senha é obrigatoria") String password) {

}
