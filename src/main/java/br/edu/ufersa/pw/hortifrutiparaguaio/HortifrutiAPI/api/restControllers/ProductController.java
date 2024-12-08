package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.Product;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/products")
    public List<Product> getAllProducts() {return productRepository.findAll();}

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {return productRepository.findById(id);}

    @DeleteMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {productRepository.deleteById(id);}

    @PostMapping("/products/post")
    public Product addProduct(@RequestBody Product product) {return productRepository.save(product);}

    @PutMapping("/products/put")
    public ResponseEntity<Product> updateProduct(@RequestBody Product updateProduct) {
        if (productRepository.existsById(updateProduct.getId())) {
            return ResponseEntity.ok(productRepository.save(updateProduct));
        }
        return ResponseEntity.notFound().build();
    }

}
