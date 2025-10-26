package org.playvault.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.playvault.entity.Category;

@Setter
@Getter
public class EquipmentReqDto {
    @NotBlank(message = "please enter equipment name")
    private String equipmentName;
    @NotBlank(message = "please enter the category")
    private Category category;
    @NotBlank(message = "please enter equipment price")
    private double price;
    @NotBlank(message = "please enter equipment quantity")
    private int totalQty;
}
