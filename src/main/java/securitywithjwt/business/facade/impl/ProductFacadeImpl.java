package securitywithjwt.business.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import securitywithjwt.business.facade.ProductFacade;
import securitywithjwt.business.mapper.ProductMapper;
import securitywithjwt.business.service.ProductService;
import securitywithjwt.domain.dto.product.ProductDto;
import securitywithjwt.domain.dto.product.request.ProductRequest;
import securitywithjwt.domain.entity.ProductEntity;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductFacadeImpl implements ProductFacade {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> productEntityList = productService.findAll();
        return productMapper.entityListToDtoList(productEntityList);
    }

    @Override
    public ProductDto create(ProductRequest productRequest) {
        ProductEntity productEntityToSave = productMapper.requestToEntity(productRequest);
        ProductEntity productEntitySaved = productService.create(productEntityToSave);
        return productMapper.entityToDto(productEntitySaved);
    }
}
