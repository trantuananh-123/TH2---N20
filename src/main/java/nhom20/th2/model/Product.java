package nhom20.th2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @NotBlank(message = "Product code is required")
    private String code;
    @NotBlank(message = "Product description is required")
    private String description;
    @NotBlank(message = "Product price is required")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$", message = "Must have format xx.xx...")
    private String price;
}