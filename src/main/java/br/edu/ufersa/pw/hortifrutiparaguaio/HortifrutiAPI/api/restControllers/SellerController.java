package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Salesman;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SellerController {
    @Autowired
    private SalesmanRepository salesman;

    @RequestMapping("/salesmans")
    public List<Salesman> getSalesmans(){return salesman.findAll();}

    @GetMapping("/salesmans/{salesmanId}")
    public Optional<Salesman> getSalesmansById(@PathVariable Long salesmanId){return salesman.findById(salesmanId);}

    @PostMapping("/salesmans/post")
    public Salesman createSalesman(@RequestBody Salesman sales){return salesman.save(sales); }

    @DeleteMapping("/salesmans/delete/{salesmanId}")
    public void deleteSalemans(@PathVariable Long salesmanId){salesman.deleteById(salesmanId);}
}
