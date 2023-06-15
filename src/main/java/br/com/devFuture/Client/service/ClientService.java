package br.com.devFuture.Client.service;

import br.com.devFuture.Client.dto.request.ClientPutRequestDto;
import br.com.devFuture.Client.dto.request.NewClientRequestDto;
import br.com.devFuture.Client.dto.response.ClientResponseDto;
import br.com.devFuture.Client.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientService {

    ClientResponseDto create(NewClientRequestDto newClientRequestDto);

    Page<ClientResponseDto> consult(Pageable pageable);

    Client consultByUuid(UUID uuid);

    Client consultByEmail(String email);

    Client consultByCpf(String cpf);

    void deleteByEmail(String email);

    void deleteByCpf(String cpf);

    void deleteByUuid(UUID uuid);

    ClientResponseDto updateByCpf(ClientPutRequestDto clientPutRequestDto, String cpf);

    ClientResponseDto updateByEmail(ClientPutRequestDto clientPutRequestDto, String email);

    ClientResponseDto updateByUuid(ClientPutRequestDto clientPutRequestDto, UUID uuid);
}
