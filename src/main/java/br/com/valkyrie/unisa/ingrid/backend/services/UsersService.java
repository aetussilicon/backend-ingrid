package br.com.valkyrie.unisa.ingrid.backend.services;

import br.com.valkyrie.unisa.ingrid.backend.model.dtos.NewUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.PatchUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.UsersResponseDto;

import java.util.List;

public interface UsersService {
    UsersResponseDto signupUser(NewUserDto dto);
    UsersResponseDto getUser(String username);
    List<UsersResponseDto> getAllUsers();
    UsersResponseDto patchUser(PatchUserDto dto);
    UsersResponseDto deleteUser(String username);

}
