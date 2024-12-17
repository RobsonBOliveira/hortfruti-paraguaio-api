package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.DTO.SellerDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Seller;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.SellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private final SellerRepository repository;

    public SellerService(final SellerRepository repository) {
        this.repository = repository;
    }

    public List<SellerDTO> findAll() {
        return repository.findAll().stream()
                .map(SellerDTO::new)
                .collect(Collectors.toList());
    }

    public SellerDTO getSellerById(final Long id) {
        Optional<Seller> result = repository.findById(id);
        return result.map(SellerDTO::new).orElse(null);
    }

    public SellerDTO createSeller(final Seller seller) {
        Optional<Seller> result = repository.findByEmail(seller.getEmail());
        if (result.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Vendedor já cadastrado"
            );
        }
        seller.setStatus(true);
        repository.save(seller);
        return new SellerDTO(seller);
    }

    public SellerDTO deleteSellerById(final Long id) {
        Optional<Seller> result = repository.findById(id);
        if (result.isPresent()) {
            result.get().setStatus(false);
            repository.save(result.get());
            return new SellerDTO(result.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public SellerDTO updateSeller(final Seller seller) {
        Optional<Seller> result = repository.findById(seller.getId());
        if (result.isPresent()) {
            repository.save(seller);
            return new SellerDTO(seller);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
