package securitywithjwt.presentation.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import securitywithjwt.business.facade.ProductFacade;
import securitywithjwt.domain.dto.product.ProductDto;
import securitywithjwt.domain.dto.product.request.ProductRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductFacade productFacade;

    @PreAuthorize("hasAuthority('READ_ALL_PRODUCTS')")
    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(productFacade.findAll());
    }

    @PreAuthorize("hasAuthority('SAVE_ONE_PRODUCT')")
    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(productFacade.create(productRequest));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception e,
                                                                      HttpServletRequest request) {
        Map<String, String> apiError = new HashMap<>();
        apiError.put("message",
                     e.getLocalizedMessage());
        apiError.put("timestamp",
                     new Date().toString());
        apiError.put("path",
                     request.getRequestURI());
        apiError.put("http-method",
                     request.getMethod());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (e instanceof AccessDeniedException) {
            status = HttpStatus.FORBIDDEN;
        }

        apiError.put("status",
                     status.toString());
        apiError.put("error",
                     e.getClass()
                      .getSimpleName());

        return ResponseEntity.status(status)
                             .body(apiError);

    }
}
