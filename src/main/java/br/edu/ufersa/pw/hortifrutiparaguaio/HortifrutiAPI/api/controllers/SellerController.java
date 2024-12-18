package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.controllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Seller;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.SellerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class SellerController {

    private final SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }

    @GetMapping("/sellers")
    public ResponseEntity<?> getSeller() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/sellers/{id}")
    public ResponseEntity<?> getSellerById(@Valid@PathVariable Long id) {
        return new ResponseEntity<>(service.getSellerById(id), HttpStatus.OK);
    }

    @DeleteMapping("/sellers/delete/{id}")
    public ResponseEntity<?> deleteSeller(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteSellerById(id), HttpStatus.OK);
    }

    @PostMapping("/sellers/post")
    public ResponseEntity<?> createSeller(@Valid @RequestBody Seller seller) {
        return new ResponseEntity<>(service.createSeller(seller), HttpStatus.OK);
    }

    @PutMapping("/sellers/put")
    public ResponseEntity<?> updateSeller(@Valid @RequestBody Seller updateSeller) {
        return new ResponseEntity<>(service.updateSeller(updateSeller), HttpStatus.OK);
    }
}
