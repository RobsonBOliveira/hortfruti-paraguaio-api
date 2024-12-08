package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.ClientDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService{
    private final ClientRepository repository;
    public ClientService(final ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientDTO> findAll() {
        List<ClientDTO> result = repository.findAll().stream().map(client -> new ClientDTO(client))
                .collect(Collectors.toList());
        return result;
    }

}
