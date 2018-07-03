package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.MasterItem;
import umn.mobile.model.MasterUser;

import java.util.Set;

public interface MasterUserRepo extends JpaRepository<MasterUser, Long> {
    @Query(value = "SELECT COUNT(*) FROM master_user WHERE username = :username AND password = :password", nativeQuery = true)
    Integer numberOfMasterUsers(@Param("username") String username, @Param("password") String password);
}
