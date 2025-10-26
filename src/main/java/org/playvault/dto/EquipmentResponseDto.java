package org.playvault.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EquipmentResponseDto {
    private Long equipmentId;
    private String equipmentName;
    private String categoryName;
    private double price;
    private int totalQty;
    private int availableQty;
}
