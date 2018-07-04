package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.MasterItem;

import java.util.List;

public interface MasterItemRepo extends JpaRepository<MasterItem, Long> {
    @Query(value = "SELECT mi FROM MasterItem mi WHERE mi.item_name LIKE %:item_name%")
    List<MasterItem> searchMasterItem(@Param("item_name") String item_name);
}
