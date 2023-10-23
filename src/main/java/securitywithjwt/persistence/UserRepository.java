package securitywithjwt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import securitywithjwt.domain.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from UserEntity u where upper(u.username) = upper(:username)")
    Optional<UserEntity> findByUsernameIgnoreCase(@Param("username") String username);
}