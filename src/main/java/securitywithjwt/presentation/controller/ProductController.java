package securitywithjwt.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import securitywithjwt.business.facade.ProductFacade;
import securitywithjwt.domain.dto.product.ProductDto;
import securitywithjwt.domain.dto.product.request.ProductRequest;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductFacade productFacade;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(productFacade.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(productFacade.create(productRequest));
    }
}
