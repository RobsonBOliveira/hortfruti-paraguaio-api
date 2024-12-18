package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.controllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Client;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.ClientService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @RequestMapping("/clients")
    public ResponseEntity<?> getClients() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<?> getClientById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(service.getClientById(id), HttpStatus.OK);
    }

    @DeleteMapping("/clients/delete/{id}")
    public ResponseEntity<?> deleteClient(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteClientById(id), HttpStatus.OK);
    }

    @PostMapping("clients/post")
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(service.createClient(client), HttpStatus.OK);
    }

    @PutMapping("/clients/put")
    public ResponseEntity<?> updateClient(@Valid @RequestBody Client updateClient) {
        return new ResponseEntity<>(service.updateClient(updateClient), HttpStatus.OK);
    }
}