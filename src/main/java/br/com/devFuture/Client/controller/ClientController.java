package br.com.devFuture.Client.controller;

import br.com.devFuture.Client.dto.request.ClientPutRequestDto;
import br.com.devFuture.Client.dto.request.NewClientRequestDto;
import br.com.devFuture.Client.dto.response.ClientResponseDto;
import br.com.devFuture.Client.dto.response.PageDto;
import br.com.devFuture.Client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDto create(@RequestBody NewClientRequestDto newClientRequestDto) {
        return clientService.create(newClientRequestDto);
    }

    @GetMapping("/consult")
    public PageDto<ClientResponseDto> consult(Pageable pageable) {
        return clientService.consult(pageable);
    }

    @GetMapping("/uuid/{uuid}")
    public ClientResponseDto consultbyUuid(@PathVariable("uuid") UUID uuid) {
        return clientService.consultByUuid(uuid);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto consultbyCpf(@PathVariable("cpf") String cpf) {
        return clientService.consultByCpf(cpf);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto consultbyEmail(@PathVariable("email") String email) {
        return clientService.consultByEmail(email);
    }

    @DeleteMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByCpf(@PathVariable("cpf") String cpf) {
        clientService.deleteByCpf(cpf);
    }

    @DeleteMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByUuid(@PathVariable("uuid") UUID uuid) {
        clientService.deleteByUuid(uuid);
    }

    @DeleteMapping("/email/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByEmail(@PathVariable("email") String email) {
        clientService.deleteByEmail(email);
    }

    @PutMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto updateByUuid(@RequestBody ClientPutRequestDto clientPutRequestDto, @PathVariable("uuid") UUID uuid) {
        return clientService.updateByUuid(clientPutRequestDto, uuid);
    }

    @PutMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto updateByEmail(@RequestBody ClientPutRequestDto clientPutRequestDto, @PathVariable("email") String email) {
        return clientService.updateByEmail(clientPutRequestDto, email);
    }

    @PutMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto updateByCpf(@RequestBody ClientPutRequestDto clientPutRequestDto, @PathVariable("cpf") String cpf) {
        return clientService.updateByCpf(clientPutRequestDto, cpf);
    }
}
