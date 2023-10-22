package securitywithjwt.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import securitywithjwt.common.util.Role;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long id;
    private String username;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}