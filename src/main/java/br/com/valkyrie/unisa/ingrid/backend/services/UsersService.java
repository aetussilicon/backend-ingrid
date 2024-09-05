package br.com.valkyrie.unisa.ingrid.backend.services;

import br.com.valkyrie.unisa.ingrid.backend.model.Users;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.NewUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.PatchUserDto;

public interface UsersService {
    Users signupUser(NewUserDto dto);
    Users getUser(String username);
    Users patchUser(PatchUserDto dto);
    Users deleteUser(String username);

}
