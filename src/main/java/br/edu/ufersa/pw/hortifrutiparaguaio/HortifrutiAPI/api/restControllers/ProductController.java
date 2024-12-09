package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.ProductDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.Product;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
        ResponseEntity<?> response = new ResponseEntity<ProductDTO>(productService.findById(id), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        ResponseEntity response = new ResponseEntity<ProductDTO> (productService.delete(id), HttpStatus.OK);
        return response;
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addProducts(@RequestBody List<Product> products) {
        List<ProductDTO> productDTOList = productService.createProducts(products);
        return new ResponseEntity<>(productDTOList, HttpStatus.CREATED);
    }

    @PutMapping("/products/put")
    public ResponseEntity<?> updateProduct(@RequestBody Product updateProduct) {
        ResponseEntity<?> response = new ResponseEntity<ProductDTO>(productService.update(updateProduct), HttpStatus.OK);
        return response;
    }

}
