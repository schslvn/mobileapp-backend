package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umn.mobile.model.MasterItem;

public interface MasterItemRepo extends JpaRepository<MasterItem, Long> {
}
