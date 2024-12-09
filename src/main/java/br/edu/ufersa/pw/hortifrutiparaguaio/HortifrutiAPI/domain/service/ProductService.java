package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.ProductDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.Product;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll() {
        List<ProductDTO> result = productRepository.findAll().stream().map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
        return result;
    }

    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return new ProductDTO(product);
    }

    public List<ProductDTO> createProducts(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : products) {
            Optional<Product> productOptional = productRepository.findById(product.getId());
            if (productOptional.isPresent()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Produto com ID " + product.getId() + " já cadastrado"
                );
            }
            productRepository.save(product);
            productDTOList.add(new ProductDTO(product));
        }
        return productDTOList;
    }

    public ProductDTO delete(final Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
            return new ProductDTO(productOptional.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public ProductDTO update(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if (productOptional.isPresent()) {
            productRepository.save(product);
            return new ProductDTO(product);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}