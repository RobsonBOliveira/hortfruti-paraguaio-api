package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.ClientDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ClientRepository;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ClientController {


    //@Autowired
    private ClientRepository clientRepository;

    private final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }


    @RequestMapping("/clients")
    public ResponseEntity<?> getClients() {
        ResponseEntity<?> response = new ResponseEntity<List<ClientDTO>>(service.findAll(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<ClientDTO>(service.getClientById(id), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/clients/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<ClientDTO>(service.deleteClientById(id), HttpStatus.OK);
        return response;
    }

    @PostMapping("clients/post")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        ResponseEntity<?> response = new ResponseEntity<ClientDTO>(service.createClient(client), HttpStatus.OK);
        return response;
    }

    @PutMapping("/clients/put")
    public ResponseEntity<?> updateClient(@RequestBody Client updateClient) {
        ResponseEntity<?> response = new ResponseEntity<ClientDTO>(service.updateClient(updateClient), HttpStatus.OK);
        return response;
    }
}