package pl.edu.wszib.pracadyplomowabackend.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.pracadyplomowabackend.models.Product;
import pl.edu.wszib.pracadyplomowabackend.repositories.ProductRepository;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> readAllProducts(Pageable page) {
        return ResponseEntity.ok(productRepository.findAll(page).getContent());
    }

    @PostMapping("/products")
    ResponseEntity<?> createProduct(@RequestBody Product toCreate) {
        Product result = productRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
}
