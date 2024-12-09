package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.ClientService;

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
        ResponseEntity<?> response = new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<>(service.getClientById(id), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/clients/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<>(service.deleteClientById(id), HttpStatus.OK);
        return response;
    }

    @PostMapping("clients/post")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        ResponseEntity<?> response = new ResponseEntity<>(service.createClient(client), HttpStatus.OK);
        return response;
    }

    @PutMapping("/clients/put")
    public ResponseEntity<?> updateClient(@RequestBody Client updateClient) {
        ResponseEntity<?> response = new ResponseEntity<>(service.updateClient(updateClient), HttpStatus.OK);
        return response;
    }
}