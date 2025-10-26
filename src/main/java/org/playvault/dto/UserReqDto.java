package org.playvault.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.playvault.entity.Role;

@Getter
@Setter
public class UserReqDto {
    @NotBlank(message = "please enter your name")
    private String name;
    @NotBlank(message = "please enter your phone number")
    private String phone;
    @NotBlank(message = "please enter your email")
    private String email;
    @NotBlank(message = "please enter your role")
    private Role role;
}
