package org.playvault.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    @NotBlank(message = "Please Enter the Phone Number")
    private String phone;
    @Column(unique = true)
    private String email;
}
