package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Seller;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    @RequestMapping("/sellers")
    public List<Seller> getSellerRepository() {return sellerRepository.findAll();}

    @GetMapping("/sellers/{id}")
    public Optional<Seller> getSellerById(@PathVariable Long id) {return sellerRepository.findById(id);}

    @DeleteMapping("/sellers/delete/{id}")
    public void deleteSeller(@PathVariable Long id) {sellerRepository.deleteById(id);}

    @PostMapping("/sellers/post")
    public Seller createSeller(@RequestBody Seller seller) {return sellerRepository.save(seller);}

    @PutMapping("/sellers/put/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller updateSeller) {
        updateSeller.setId(id);
        Seller updatedSeller = sellerRepository.save(updateSeller);
        return ResponseEntity.ok(updatedSeller);
    }
}
