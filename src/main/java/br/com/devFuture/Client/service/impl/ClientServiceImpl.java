package br.com.devFuture.Client.service.impl;

import br.com.devFuture.Client.converter.ClientConverter;
import br.com.devFuture.Client.dto.request.ClientPutRequestDto;
import br.com.devFuture.Client.dto.request.NewClientRequestDto;
import br.com.devFuture.Client.dto.response.ClientResponseDto;
import br.com.devFuture.Client.dto.response.PageDto;
import br.com.devFuture.Client.entities.Client;
import br.com.devFuture.Client.repository.ClientRepository;
import br.com.devFuture.Client.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public ClientResponseDto create(NewClientRequestDto newClientRequestDto) {
        Client client = ClientConverter.toClient(newClientRequestDto);
        clientRepository.save(client);
        return ClientConverter.toClientResponseDto(client);
    }

    @Override
    public PageDto<ClientResponseDto> consult(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("email"));

        final Page<Client> clientPage = clientRepository.findAll(pageRequest);

        return ClientConverter.toClientePageResponseDto(clientPage);
    }

    @Override
    public ClientResponseDto consultByUuid(UUID uuid) {
        Client cliente = clientRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Client not found by uuid: " + uuid));
        return ClientConverter.toClientResponseDto(cliente);
    }

    @Override
    public ClientResponseDto consultByEmail(String email) {
        Client cliente = clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found by email: " + email));
        return ClientConverter.toClientResponseDto(cliente);
    }

    @Override
    public ClientResponseDto consultByCpf(String cpf) {
        Client cliente = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Client not found by cpf: " + cpf));
        return ClientConverter.toClientResponseDto(cliente);    }

    public ClientResponseDto updateByUuid(ClientPutRequestDto clientPutRequestDto, UUID uuid) {
        Client saveClient = clientRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        checkUpdateData(clientPutRequestDto, saveClient);
        clientRepository.save(saveClient);
        return ClientConverter.toClientResponseDto(saveClient);
    }

    public ClientResponseDto updateByCpf(ClientPutRequestDto clientPutRequestDto, String cpf) {
        Client saveClient = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        checkUpdateData(clientPutRequestDto, saveClient);
        clientRepository.save(saveClient);
        return ClientConverter.toClientResponseDto(saveClient);
    }

    public ClientResponseDto updateByEmail(ClientPutRequestDto clientPutRequestDto, String email) {
        Client saveClient = clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        checkUpdateData(clientPutRequestDto, saveClient);
        clientRepository.save(saveClient);
        return ClientConverter.toClientResponseDto(saveClient);
    }

    private void checkUpdateData(ClientPutRequestDto clientePutRequestDto, Client saveClient) {
        saveClient.setName(clientePutRequestDto.getName() == null ? saveClient.getName() : clientePutRequestDto.getName());
        saveClient.setTelephone(clientePutRequestDto.getTelephone() == null ? saveClient.getTelephone() : clientePutRequestDto.getTelephone());
        saveClient.setAddress(clientePutRequestDto.getAddress() == null ? saveClient.getAddress() : clientePutRequestDto.getAddress());
        saveClient.setEmail(clientePutRequestDto.getEmail() == null ? saveClient.getEmail() : clientePutRequestDto.getEmail());
        clientRepository.save(saveClient);
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
        clientRepository.deleteByEmail(email);
    }

    @Override
    @Transactional
    public void deleteByCpf(String cpf) {
        clientRepository.deleteByCpf(cpf);
    }

    @Override
    @Transactional
    public void deleteByUuid(UUID uuid) {
        clientRepository.deleteByUuid(uuid);
    }
}
