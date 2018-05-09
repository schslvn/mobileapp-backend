package umn.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "request_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDetail {
    @Id
    @GeneratedValue
    @Column(name = "request_detail_id", nullable = false, updatable = false)
    private Long request_detail_id;

    @Column(name = "request_header_id")
    private Long request_header_id;

    @Column(name = "item_id")
    private Long item_id;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "rd_desc")
    private String rd_desc;
}
