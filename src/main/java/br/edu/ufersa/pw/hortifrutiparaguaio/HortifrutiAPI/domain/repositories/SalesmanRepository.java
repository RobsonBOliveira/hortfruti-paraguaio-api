package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
}
