package umn.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "master_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MasterItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false, updatable = false)
    private Long item_id;

    @Column(name = "item_code", columnDefinition = "VARCHAR(50)", nullable = false)
    private String item_code;

    @Column(name = "item_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String item_name;
}
