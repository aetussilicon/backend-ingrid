package br.com.valkyrie.unisa.ingrid.backend.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchUserDto {
    private String email;
    private String password;
    private String fullName;
    private String username;
}
