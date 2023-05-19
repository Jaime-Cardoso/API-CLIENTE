package br.com.devFuture.Client.service;

import br.com.devFuture.Client.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientService {

    Client create(Client client);

    Page<Client> consult(Pageable pageable);

    Client consultByUuid(UUID uuid);

    Client consultByEmail(String email);

    Client consultByCpf(String cpf);

    void deleteByEmail(String cpf);
}
