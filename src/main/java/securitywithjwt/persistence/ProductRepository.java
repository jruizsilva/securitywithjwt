package securitywithjwt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import securitywithjwt.domain.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}