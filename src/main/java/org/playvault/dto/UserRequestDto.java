package org.playvault.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotBlank(message = "please enter your name")
    private String name;
    @NotBlank(message = "please enter your phone number")
    private String phone;
    @NotBlank(message = "please enter your email")
    private String email;
    @NotBlank(message = "please enter your password")
    private String password;
//    @NotNull(message = "please enter your role")
//    private Role role;
}
