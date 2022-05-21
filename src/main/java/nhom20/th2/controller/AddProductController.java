package nhom20.th2.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom20.th2.model.Product;
import nhom20.th2.repository.ProductRepository;



@Controller
@RequestMapping("/add-product")
public class AddProductController {

    private ProductRepository productRepository;

    public AddProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public String showProductTable(Model model) {
        model.addAttribute("product", new Product());
        return "add-products";
    }

    @PostMapping
    public String addProduct(@Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            return "add-products";
        }
        productRepository.save(product);
        return "redirect:/view-product";
    }
}
