package org.playvault.dao;

import org.playvault.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface EquipmentDao extends JpaRepository<Equipment, Long>
{
//    List<Equipment> findByCategory(String category);


}
