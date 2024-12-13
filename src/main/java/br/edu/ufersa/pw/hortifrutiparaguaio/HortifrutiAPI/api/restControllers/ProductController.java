package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.ProductDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.Product;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {


    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<> (productService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addProducts(@RequestBody List<Product> products) {
        List<ProductDTO> productDTOList = productService.createProducts(products);
        return new ResponseEntity<>(productDTOList, HttpStatus.CREATED);
    }

    @PutMapping("/products/put")
    public ResponseEntity<?> updateProduct(@RequestBody Product updateProduct) {
        return new ResponseEntity<>(productService.update(updateProduct), HttpStatus.OK);
    }

}
