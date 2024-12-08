/*package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

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
    private SellerRepository seller;

    @RequestMapping("/sellers")
    public List<Seller> getSeller(){return seller.findAll();}

    @GetMapping("/seller/{sellerId}")
    public Optional<Seller> getSellerById(@PathVariable Long sellerId){return seller.findById(sellerId);}

    @PostMapping("/seller/post")
    public Seller createSeller(@RequestBody Seller sellers){return seller.save(sellers);}

    @DeleteMapping("/seller/delete/{sellerId}")
    public void deleteSeller(@PathVariable Long sellerId){seller.deleteById(sellerId);}

}*/
