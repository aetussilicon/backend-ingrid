package br.com.valkyrie.unisa.ingrid.backend.model.dtos;

import br.com.valkyrie.unisa.ingrid.backend.model.UsersRoles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserDto {
    private String email;
    private String password;
    private String fullName;
    private String username;
    private UsersRoles role;
}
