package org.playvault.service;

import org.playvault.entity.Equipment;
import org.playvault.entity.User;

import java.util.List;

public interface EquipmentService {
    Equipment addEquipment(Equipment equipment);
    Equipment updateEquipment(Equipment equipment);
    void deleteEquipment(Equipment equipment);
    List<Equipment> getEquipment(Equipment equipment);
    List<Equipment> getEuipmentByCategory(Equipment equipment);
}
