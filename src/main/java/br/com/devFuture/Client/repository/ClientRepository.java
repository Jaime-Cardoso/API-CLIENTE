package br.com.devFuture.Client.repository;

import br.com.devFuture.Client.dto.response.ClientResponseDto;
import br.com.devFuture.Client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByEmail(String email);

    Optional<Client> findByCpf(String cpf);

    void deleteByCpf(String cpf);

    void deleteByEmail(String email);

    void deleteByUuid(UUID uuid);
}
