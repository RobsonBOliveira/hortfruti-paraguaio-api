package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.SellerDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Seller;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SellerController {

    private final SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }

    @RequestMapping("/sellers")
    public ResponseEntity<?> getSeller() {
        ResponseEntity<?> response = new ResponseEntity<List<SellerDTO>>(service.findAll(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/sellers/{id}")
    public ResponseEntity<?> getSellerById(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<SellerDTO>(service.getSellerById(id), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/sellers/delete/{id}")
    public ResponseEntity<?> deleteSeller(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<SellerDTO>(service.deleteSellerById(id), HttpStatus.OK);
        return response;
    }

    @PostMapping("/sellers/post")
    public ResponseEntity<?> createSeller(@RequestBody Seller seller) {
        ResponseEntity<?> response = new ResponseEntity<SellerDTO>(service.createSeller(seller), HttpStatus.OK);
        return response;
    }

    @PutMapping("/sellers/put")
    public ResponseEntity<?> updateSeller(@RequestBody Seller updateSeller) {
        ResponseEntity<?> response = new ResponseEntity<SellerDTO>(service.updateSeller(updateSeller), HttpStatus.OK);
        return response;
    }
}
