package br.com.devFuture.Client.service;

import br.com.devFuture.Client.dto.request.ClientPutRequestDto;
import br.com.devFuture.Client.dto.request.NewClientRequestDto;
import br.com.devFuture.Client.dto.response.ClientResponseDto;
import br.com.devFuture.Client.dto.response.PageDto;
import br.com.devFuture.Client.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientService {

    ClientResponseDto create(NewClientRequestDto newClientRequestDto);

    PageDto<ClientResponseDto> consult(Pageable pageable);

    ClientResponseDto consultByUuid(UUID uuid);

    ClientResponseDto consultByEmail(String email);

    ClientResponseDto consultByCpf(String cpf);

    void deleteByEmail(String email);

    void deleteByCpf(String cpf);

    void deleteByUuid(UUID uuid);

    ClientResponseDto updateByCpf(ClientPutRequestDto clientPutRequestDto, String cpf);

    ClientResponseDto updateByEmail(ClientPutRequestDto clientPutRequestDto, String email);

    ClientResponseDto updateByUuid(ClientPutRequestDto clientPutRequestDto, UUID uuid);
}
