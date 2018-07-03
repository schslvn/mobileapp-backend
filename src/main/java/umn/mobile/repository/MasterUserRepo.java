package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umn.mobile.model.MasterItem;
import umn.mobile.model.MasterUser;

public interface MasterUserRepo extends JpaRepository<MasterUser, Long> {
}
