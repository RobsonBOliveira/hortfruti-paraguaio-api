package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Sale;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/sale/post")
    public ResponseEntity<?> createSale(@RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.saveSale(sale), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Optional<Sale> sale = saleService.getSaleById(id);
        return sale.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }
}