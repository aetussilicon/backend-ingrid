package br.com.valkyrie.unisa.ingrid.backend.services;

import br.com.valkyrie.unisa.ingrid.backend.model.dtos.NewUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.PatchUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.UsersResponseDto;

import java.util.List;

// Interface que define os métodos de serviço para manipulação dos dados dos usuários
public interface UsersService {
    // Método para registrar um novo usuário
    // Recebe um objeto NewUserDto com os dados do novo usuário
    // Retorna um objeto UsersResponseDto com os dados do usuário registrado
    UsersResponseDto signupUser(NewUserDto dto);

    // Método para obter os dados de um usuário específico pelo nome de usuário
    // Recebe o nome de usuário como parâmetro
    // Retorna um objeto UsersResponseDto com os dados do usuário
    UsersResponseDto getUser(String username);

    // Método para obter os dados de todos os usuários
    // Retorna uma lista de objetos UsersResponseDto com os dados de todos os usuários
    List<UsersResponseDto> getAllUsers();

    // Método para atualizar os dados de um usuário
    // Recebe um objeto PatchUserDto com os dados a serem atualizados
    // Retorna um objeto UsersResponseDto com os dados do usuário atualizado
    UsersResponseDto patchUser(PatchUserDto dto);

    // Método para deletar um usuário pelo nome de usuário
    // Recebe o nome de usuário como parâmetro
    // Retorna um objeto UsersResponseDto com os dados do usuário deletado
    UsersResponseDto deleteUser(String username);

}
