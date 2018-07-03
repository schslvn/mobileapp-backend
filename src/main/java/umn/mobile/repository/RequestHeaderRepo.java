package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.RequestHeader;

import java.util.Set;

public interface RequestHeaderRepo extends JpaRepository<RequestHeader, Long> {
    @Query(value = "SELECT counter FROM request_header WHERE request_date=current_date ORDER BY number DESC LIMIT 1", nativeQuery = true)
    Integer getCounter();

    @Query(value = "SELECT * FROM request_header WHERE app_status1 = 'PENDING' OR app_status2 ='PENDING' OR app_status3 = 'PENDING' OR app_status4 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfAllRequestHeaderByPendingStatus();

    @Query(value = "SELECT * FROM request_header WHERE app_status1 = 'ACCEPTED' AND app_status2 ='ACCEPTED' AND app_status3 = 'ACCEPTED' AND app_status4 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForGeneralManager();

    @Query(value = "SELECT * FROM request_header WHERE app_status1 = 'ACCEPTED' AND app_status2 ='ACCEPTED' AND app_status3 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForFinancialController();

    @Query(value = "SELECT * FROM request_header WHERE app_status1 = 'ACCEPTED' AND app_status2 ='PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForPurchasingManager();

    @Query(value = "SELECT * FROM request_header WHERE app_status1 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForDepartmentHead();
}
