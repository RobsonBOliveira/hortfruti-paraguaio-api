package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Product;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}

