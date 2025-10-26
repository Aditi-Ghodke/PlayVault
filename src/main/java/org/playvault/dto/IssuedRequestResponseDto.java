package org.playvault.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssuedRequestResponseDto {
    private Long requestId;
    private String userName;
    private String equipmentName;
    private int quantity;
    private String requestDate;
    private String status;
}
