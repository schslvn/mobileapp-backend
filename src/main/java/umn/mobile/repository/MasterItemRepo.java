package umn.mobile.repository;

import javafx.scene.effect.SepiaTone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.MasterItem;

import java.util.Set;

public interface MasterItemRepo extends JpaRepository<MasterItem, Long> {
    @Query(value = "SELECT * FROM master_item WHERE item_name LIKE %:item_name%", nativeQuery = true)
    Set<MasterItem> searchMasterItem(@Param("item_name") String item_name);
}
