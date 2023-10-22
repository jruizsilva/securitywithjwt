package securitywithjwt.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import securitywithjwt.domain.dto.product.ProductDto;
import securitywithjwt.domain.dto.product.request.ProductRequest;
import securitywithjwt.domain.entity.ProductEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    @Mapping(target = "id",
             ignore = true)
    ProductEntity requestToEntity(ProductRequest productRequest);
    ProductDto entityToDto(ProductEntity productEntity);

    List<ProductDto> entityListToDtoList(List<ProductEntity> productEntityList);
}
