package org.playvault.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssuedRequestDto {
    private Long equipmentId;
    private int quantity;
}