package securitywithjwt.business.facade;

import securitywithjwt.domain.dto.product.ProductDto;
import securitywithjwt.domain.dto.product.request.ProductRequest;

import java.util.List;

public interface ProductFacade {
    List<ProductDto> findAll();
    ProductDto create(ProductRequest productRequest);
}
