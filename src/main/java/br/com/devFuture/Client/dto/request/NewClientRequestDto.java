package br.com.devFuture.Client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewClientRequestDto {

    private String name;
    private String email;
    private String cpf;
    private Integer age;
    private AddressRequestDto address;
    private String telephone;
}
