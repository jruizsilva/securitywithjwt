package securitywithjwt.business.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import securitywithjwt.business.service.ProductService;
import securitywithjwt.domain.entity.ProductEntity;
import securitywithjwt.persistence.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

}
