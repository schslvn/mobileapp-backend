package umn.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MasterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long user_id;

    @Column(name = "username", columnDefinition = "VARCHAR(100)", nullable = false)
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(50)", nullable = false)
    private String password;

    @Column(name = "fullname", columnDefinition = "VARCHAR(10)", nullable = false)
    private String fullname;

    @Column(name = "position", columnDefinition = "VARCHAR(10)", nullable = false)
    private String position;
}
