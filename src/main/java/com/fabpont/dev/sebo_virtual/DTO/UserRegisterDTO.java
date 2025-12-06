package com.fabpont.dev.sebo_virtual.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}
