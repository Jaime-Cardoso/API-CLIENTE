package br.com.devFuture.Client.converter;

import br.com.devFuture.Client.dto.request.NewClientRequestDto;
import br.com.devFuture.Client.dto.response.ClientResponseDto;
import br.com.devFuture.Client.entities.Client;

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
}
