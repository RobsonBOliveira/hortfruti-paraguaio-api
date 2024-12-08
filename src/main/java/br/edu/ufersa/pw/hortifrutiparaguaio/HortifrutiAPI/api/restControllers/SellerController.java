package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Seller;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/seller/{sellerId}")
    public Optional<Seller> getSellerById(@PathVariable Long sellerId) {return sellerRepository.findById(sellerId);}

    @PostMapping("/seller/post")
    public Seller createSeller(@RequestBody Seller seller) {return sellerRepository.save(seller);}

    @DeleteMapping("/seller/delete/{sellerId}")
    public void deleteSeller(@PathVariable Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

}
