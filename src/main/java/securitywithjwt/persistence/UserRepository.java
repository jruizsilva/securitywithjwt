package securitywithjwt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import securitywithjwt.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}