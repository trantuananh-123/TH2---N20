package nhom20.th2.controller;

import nhom20.th2.model.Product;
import nhom20.th2.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete-product")
public class DeleteProductController {

    private ProductRepository productRepository;

    public DeleteProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{productCode}")
    public String showProductTable(@PathVariable("productCode") String productCode, Model model) {
        Product product = productRepository.findById(productCode).orElse(null);
        if (product != null) {
            product.setCode(productCode);
        }
        model.addAttribute("product", product);
        return "delete-products";
    }

    @PostMapping("/{productCode}")
    public String delete1Product(@PathVariable("productCode") String productCode) {
        Product newProduct = productRepository.findById(productCode).orElse(null);
        if (newProduct != null) {
            productRepository.delete(newProduct);
        }
        return "redirect:/view-product";
    }
}
