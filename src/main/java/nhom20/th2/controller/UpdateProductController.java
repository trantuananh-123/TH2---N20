package nhom20.th2.controller;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom20.th2.model.Product;
import nhom20.th2.repository.ProductRepository;

@Controller
@RequestMapping("/update-product")
public class UpdateProductController {

    private ProductRepository productRepository;

    public UpdateProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{productCode}")
    public String showProductTable(@PathVariable("productCode") String productCode, Model model) {
        Product product = productRepository.findById(productCode).orElse(null);
        if (product != null) {
            product.setCode(productCode);
        }
        model.addAttribute("product", product);
        return "update-products";
    }

    @PostMapping("/{productCode}")
    public String updateProduct(@PathVariable("productCode") String productCode, @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            return "update-products";
        }
        Product newProduct = productRepository.findById(productCode).orElse(null);
        if (newProduct != null) {
            newProduct.setDescription(product.getDescription());
            newProduct.setPrice(product.getPrice());
            productRepository.save(newProduct);
        }
        return "redirect:/view-product";
    }
}
