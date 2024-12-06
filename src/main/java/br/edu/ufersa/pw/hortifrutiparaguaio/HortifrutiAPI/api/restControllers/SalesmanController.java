package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Salesman;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SalesmanController {
    @Autowired
    private SalesmanRepository salesman;

    @RequestMapping("/salesmans")
    public List<Salesman> getSalesmans(){return salesman.findAll();}

    @GetMapping("/salesmans/{salesmanId}")
    public Optional<Salesman> getSalesmansById(@PathVariable Long salesmanId){return salesman.findById(salesmanId);}
}
