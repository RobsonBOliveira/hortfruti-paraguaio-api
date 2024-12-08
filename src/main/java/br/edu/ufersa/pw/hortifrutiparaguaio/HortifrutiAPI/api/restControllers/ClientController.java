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


    @Autowired
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
    public Optional<Client> getClientById(@PathVariable Long id) {return clientRepository.findById(id);}

    @DeleteMapping("/clients/delete/{id}")
    public void deleteClient(@PathVariable Long id) {clientRepository.deleteById(id);}

    @PostMapping("clients/post")
    public Client createClient(@RequestBody Client client) {return clientRepository.save(client);}

    @PutMapping("/clients/put")
    public ResponseEntity<Client> updateClient(@RequestBody Client updateClient) {
        if (clientRepository.existsById(updateClient.getId())) {
            return ResponseEntity.ok(clientRepository.save(updateClient));
        }
        return ResponseEntity.notFound().build();
    }
}