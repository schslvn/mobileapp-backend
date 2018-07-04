package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.MasterUser;

import java.util.Set;

public interface MasterUserRepo extends JpaRepository<MasterUser, Long> {
    @Query(value = "SELECT * FROM master_user WHERE username = :username AND password = :password", nativeQuery = true)
    Set<MasterUser> listOfMasterUsers(@Param("username") String username, @Param("password") String password);
}
