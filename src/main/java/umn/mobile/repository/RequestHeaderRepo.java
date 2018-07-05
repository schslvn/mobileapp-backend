package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umn.mobile.model.Request;
import umn.mobile.model.RequestHeader;

import javax.transaction.Transactional;
import java.util.Set;

public interface RequestHeaderRepo extends JpaRepository<RequestHeader, Long> {
    @Query(value = "SELECT * FROM request_header WHERE app_by1 = 'PENDING' OR app_by2 ='PENDING' OR app_by3 = 'PENDING' OR app_by4 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfAllRequestHeaderByPendingStatus();

    @Query(value = "SELECT * FROM request_header WHERE app_by1 = 'ACCEPTED' AND app_by2 ='ACCEPTED' AND app_by3 = 'ACCEPTED' AND app_by4 = 'ACCEPTED'", nativeQuery = true)
    Set<RequestHeader> listOfAllRequestHeaderByAcceptedStatus();

    @Query(value = "SELECT * FROM request_header WHERE app_by1 = 'ACCEPTED' AND app_by2 ='ACCEPTED' AND app_by3 = 'ACCEPTED' AND app_by4 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForGeneralManager();

    @Query(value = "SELECT * FROM request_header WHERE app_by1 = 'ACCEPTED' AND app_by2 ='ACCEPTED' AND app_by3 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForFinancialController();

    @Query(value = "SELECT * FROM request_header WHERE app_by1 = 'ACCEPTED' AND app_by2 ='PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForPurchasingManager();

    @Query(value = "SELECT * FROM request_header WHERE app_by1 = 'PENDING'", nativeQuery = true)
    Set<RequestHeader> listOfRequestHeaderForDepartmentHead();

    @Transactional
    @Modifying
    @Query(value = "UPDATE RequestHeader rh SET rh.app_status1 = :app_status1 WHERE rh.request_header_id = :request_header_id")
    public void updateDepartmentHead(@Param("app_status1") String app_status1, @Param("request_header_id") Long request_header_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE RequestHeader rh SET rh.app_status2 = :app_status2 WHERE rh.request_header_id = :request_header_id")
    public void updatePurchasingManager(@Param("app_status2") String app_status2, @Param("request_header_id") Long request_header_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE RequestHeader rh SET rh.app_status3 = :app_status3 WHERE rh.request_header_id = :request_header_id")
    public void updateFinancialController(@Param("app_status3") String app_status3, @Param("request_header_id") Long request_header_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE RequestHeader rh SET rh.app_status4 = :app_status4 WHERE rh.request_header_id = :request_header_id")
    public void updateGeneralManager(@Param("app_status4") String app_status4, @Param("request_header_id") Long request_header_id);

    @Query(value = "SELECT ROW_TO_JSON(rh), ARRAY_TO_JSON(ARRAY(SELECT rd FROM request_detail rd, request_header rh WHERE rh.request_header_id=rd.request_header_id)) FROM request_header rh", nativeQuery = true)
    Set<RequestHeader> listOfHeaderDetail();

    @Query(value = "SELECT rh FROM RequestHeader rh")
    Set<RequestHeader> listOfRequestHeader();
}
