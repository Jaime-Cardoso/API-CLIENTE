package br.com.devFuture.Client.service.impl;

import br.com.devFuture.Client.entities.Client;
import br.com.devFuture.Client.repository.ClientRepository;
import br.com.devFuture.Client.service.ClientService;
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
