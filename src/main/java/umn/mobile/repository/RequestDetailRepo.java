package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.RequestDetail;

import java.util.Set;

public interface RequestDetailRepo extends JpaRepository<RequestDetail, Long> {
    @Query("SELECT rd FROM RequestDetail rd, RequestHeader rh WHERE rd.request_header_id = :request_header_id")
    Set<RequestDetail> listOfRequestDetail(@Param("request_header_id") Long request_header_id);
}
