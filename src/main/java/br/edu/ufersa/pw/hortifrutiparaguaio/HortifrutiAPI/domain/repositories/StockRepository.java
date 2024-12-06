package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
