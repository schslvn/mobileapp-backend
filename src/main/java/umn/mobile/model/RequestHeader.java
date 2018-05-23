package umn.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "request_header")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestHeader {
    @Id
    @Column(name = "request_header_id", nullable = false, updatable = false)
    private Long request_header_id;

    @Column(name = "request_header_number", columnDefinition = "VARCHAR(50)")
    private String request_header_number;

    @Column(name = "requested_by", columnDefinition = "VARCHAR(50)")
    private String requested_by;

    @Column(name = "status", columnDefinition = "VARCHAR(50)")
    private String status;

    @Column(name = "trans_date")
    private Date trans_date;

    @Column(name = "rh_desc")
    private String rh_desc;
}
