package br.com.devFuture.Cliente.service.impl;

import br.com.devFuture.Cliente.entities.Client;
import br.com.devFuture.Cliente.repository.ClientRepository;
import br.com.devFuture.Cliente.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }
}
