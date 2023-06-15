package br.com.devFuture.Client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientPutRequestDto {

    private String name;
    private String email;
    private String address;
    private String telephone;
}
