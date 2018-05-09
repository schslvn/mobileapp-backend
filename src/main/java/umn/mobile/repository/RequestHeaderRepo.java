package umn.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umn.mobile.model.RequestHeader;

public interface RequestHeaderRepo extends JpaRepository<RequestHeader, Long> {
}
