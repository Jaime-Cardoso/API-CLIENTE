package br.com.devFuture.Client.converter;

import br.com.devFuture.Client.dto.request.NewClientRequestDto;
import br.com.devFuture.Client.dto.response.ClientResponseDto;
import br.com.devFuture.Client.dto.response.CustomPage;
import br.com.devFuture.Client.dto.response.PageDto;
import br.com.devFuture.Client.entities.Client;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ClientConverter {

    public static Client toClient(NewClientRequestDto newClientRequestDto){
        return Client.builder()
                .name(newClientRequestDto.getName())
                .email(newClientRequestDto.getEmail())
                .cpf(newClientRequestDto.getCpf())
                .telephone(newClientRequestDto.getTelephone())
                .age(newClientRequestDto.getAge())
                .address(newClientRequestDto.getAddress())
                .build();
    }

    public static ClientResponseDto toClientResponseDto(Client client) {
        return ClientResponseDto.builder()
                .name(client.getName())
                .email(client.getEmail())
                .cpf(client.getCpf())
                .telephone(client.getTelephone())
                .age(client.getAge())
                .address(client.getAddress())
                .build();
    }
    public static PageDto<ClientResponseDto> toClientePageResponseDto(Page<Client> clientePage) {
        PageDto<ClientResponseDto> clientResponseDtos = new PageDto<>();

        List<ClientResponseDto> responseDtos = clientePage.getContent()
                .stream()
                .map(client -> ClientResponseDto.builder()
                        .name(client.getName())
                        .cpf(client.getCpf())
                        .address(client.getAddress())
                        .email(client.getEmail())
                        .telephone(client.getTelephone())
                        .build()).collect(Collectors.toList());

        clientResponseDtos.setContent(responseDtos);

        CustomPage customPage = CustomPage.builder()
                .totalPages(clientePage.getTotalPages())
                .totalElements(clientePage.getTotalElements())
                .number(clientePage.getNumber())
                .size(clientePage.getSize())
                .build();

        clientResponseDtos.setCustomPage(customPage);
        return clientResponseDtos;
    }
}
