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

    @GetMapping("/products/{idProduct}")
    public Optional<Product> getProductById(@PathVariable long idProduct) {return productRepository.findById(idProduct);}

    @PostMapping("/products/post")
    public Product addProduct(@RequestBody Product product) {return productRepository.save(product);}


    @PutMapping("/products/put/{idProduct}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long idProduct, @RequestBody Product updateProduct) {
        updateProduct.setIdProduct(idProduct);
        Product updatedProduct = productRepository.save(updateProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/delete/{idProduct}")
    public void deleteProduct(@PathVariable long idProduct) {productRepository.deleteById(idProduct);}
}
