package nhom20.th2.controller;

import nhom20.th2.model.Product;
import nhom20.th2.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view-product")
public class ViewProductController {

    private ProductRepository productRepository;

    public ViewProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public String showProductTable(Model model) {
        List<Product> list = productRepository.findAll();
        model.addAttribute("products", list);
        return "view-products";
    }
}
