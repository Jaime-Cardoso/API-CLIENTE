package br.com.devFuture.Client.controller;

import br.com.devFuture.Client.entities.Client;
import br.com.devFuture.Client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Client criar(@RequestBody Client client) {
        return clientService.create(client);
    }
    @GetMapping("/consult")
    public Page<Client> consult(Pageable pageable) {
        return clientService.consult(pageable);
    }
    @GetMapping("/uuid/{uuid}")
    public Client consultbyUuid(@PathVariable("uuid") UUID uuid) {
        return clientService.consultByUuid(uuid);
    }
    @GetMapping("/cpf/{cpf}")
    public Client consultbyCpf(@PathVariable("cpf") String cpf) {
        return clientService.consultByCpf(cpf);
    }
    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Client consultbyEmail(@PathVariable("email") String email) {
        return clientService.consultByEmail(email);
    }
    @DeleteMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByCpf(@PathVariable("cpf") String cpf) {
        clientService.deleteByEmail(cpf);
    }
}
