package br.com.devFuture.Client.service.impl;

import br.com.devFuture.Client.entities.Client;
import br.com.devFuture.Client.repository.ClientRepository;
import br.com.devFuture.Client.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Page<Client> consult(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client consultByUuid(UUID uuid) {
        return clientRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Client not found id" + uuid));
    }

    @Override
    public Client consultByEmail(String email) {
        return clientRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Client not found by email" + email));
    }

    @Override
    public Client consultByCpf(String cpf) {
        return clientRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Client not found by cpf" + cpf));
    }

    @Override
    @Transactional
    public void deleteByEmail(String cpf) {
        clientRepository.deleteByCpf(cpf);
    }

}
