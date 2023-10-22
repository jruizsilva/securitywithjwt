package securitywithjwt.domain.dto.product.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequest {
    @NotBlank
    private String name;
    @DecimalMin(value = "0.01")
    private BigDecimal price;
}
