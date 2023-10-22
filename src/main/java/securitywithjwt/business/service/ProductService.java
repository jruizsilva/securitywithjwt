package securitywithjwt.business.service;

import securitywithjwt.domain.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> findAll();
    ProductEntity create(ProductEntity productEntity);
}
