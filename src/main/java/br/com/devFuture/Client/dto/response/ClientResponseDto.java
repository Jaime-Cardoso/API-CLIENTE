package br.com.devFuture.Client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    private String name;
    private String email;
    private String cpf;
    private Integer age;
    private String address;
    private String telephone;
}
