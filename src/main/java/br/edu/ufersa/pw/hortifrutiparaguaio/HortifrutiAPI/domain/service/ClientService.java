package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.ClientDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Client;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Service
public class ClientService{

    private final ClientRepository repository;

    public ClientService(final ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientDTO> findAll() {
        return repository.findAll().stream()
                .filter(Client::isStatus)
                .map(ClientDTO::new)
                .toList();
    }

    public ClientDTO getClientById(final Long id) {
        Optional<Client> result = repository.findById(id);
        return result.map(ClientDTO::new).orElse(null);
    }

    public ClientDTO createClient(final Client client) {
        Optional<Client> result = repository.findByEmail(client.getEmail());
        if (result.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Cliente já cadastrado"
            );
        }
        client.setStatus(true);
        repository.save(client);
        return new ClientDTO(client);
    }

    public ClientDTO deleteClientById(final Long id) {
        Optional<Client> result = repository.findById(id);
        if (result.isPresent()) {
            result.get().setStatus(false);
            repository.save(result.get());
            return new ClientDTO(result.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public ClientDTO updateClient(final Client client) {
        Optional<Client> result = repository.findById(client.getId());
        if (result.isPresent()) {
            result.get().setName(client.getName());
            result.get().setEmail(client.getEmail());
            result.get().setPhone(client.getPhone());
            result.get().setStatus(true);
            repository.save(result.get());
            return new ClientDTO(result.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
