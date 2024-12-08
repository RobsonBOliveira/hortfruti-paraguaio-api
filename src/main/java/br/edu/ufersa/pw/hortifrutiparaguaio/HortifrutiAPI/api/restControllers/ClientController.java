package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping("/clients")
    public List<Client> getClients() {return clientRepository.findAll();}

    @GetMapping("/clients/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {return clientRepository.findById(id);}

    @DeleteMapping("/clients/delete/{id}")
    public void deleteClient(@PathVariable Long id) {clientRepository.deleteById(id);}

    @PostMapping("clients/post")
    public Client createClient(@RequestBody Client client) {return clientRepository.save(client);}

    @PutMapping("/clients/put/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updateClient) {
        updateClient.setId(id);
        Client updatedClient = clientRepository.save(updateClient);
        return ResponseEntity.ok(updatedClient);
    }

}