package org.playvault.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.playvault.entity.Role;

@Setter
@Getter
public class UserResponseDto {
    private String name;
    private String phone;
    private String email;
    private Role role;
}