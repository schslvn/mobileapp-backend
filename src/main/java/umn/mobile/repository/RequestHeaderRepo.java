package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.RequestHeader;

public interface RequestHeaderRepo extends JpaRepository<RequestHeader, Long> {
    @Query(value = "SELECT counter FROM request_header WHERE request_date=current_date ORDER BY number DESC LIMIT 1", nativeQuery = true)
    Integer getCounter();
}
