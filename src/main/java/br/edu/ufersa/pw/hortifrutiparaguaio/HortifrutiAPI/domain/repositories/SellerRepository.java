package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
