package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
