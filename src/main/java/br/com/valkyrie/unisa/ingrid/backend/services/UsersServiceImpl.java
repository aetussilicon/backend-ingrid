package br.com.valkyrie.unisa.ingrid.backend.services;

import br.com.valkyrie.unisa.ingrid.backend.model.Users;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.NewUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.PatchUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.UsersResponseDto;
import br.com.valkyrie.unisa.ingrid.backend.model.mapper.UsersMapper;
import br.com.valkyrie.unisa.ingrid.backend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service // Indica que esta classe é um serviço do Spring
@RequiredArgsConstructor // Gera um construtor com todos os campos finais (final) como parâmetros
public class UsersServiceImpl implements UsersService {

    // Declaração do repositório que será usado para acessar os dados dos usuários
    private final UsersRepository repository;

    // Declaração do mapper que será usado para converter entre objetos DTO e entidades
    private final UsersMapper mapper;

    // Implementação do método para registrar um novo usuário
    @Override
    public UsersResponseDto signupUser(NewUserDto dto) {
        // Verifica se o email já existe no banco de dados
        Optional<Users> checkUserInDatabase = repository.findUserByEmail(dto.getEmail());
        if (checkUserInDatabase.isPresent()) {
            // Lança uma exceção se o email já estiver registrado
            throw new RuntimeException("Email already exists");
        }

        // Converte o DTO para a entidade Users
        Users newUser = mapper.newUserDtoToModel(dto);

        // Define a data de criação e atualização do usuário
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());

        // Salva o novo usuário no banco de dados
        repository.save(newUser);

        // Converte a entidade Users para o DTO de resposta e retorna
        return mapper.modelToResponseDto(newUser);
    }

    // Implementação do método para obter os dados de um usuário específico pelo nome de usuário
    @Override
    public UsersResponseDto getUser(String username) {
        // Busca o usuário pelo nome de usuário e lança uma exceção se não for encontrado
        return mapper.modelToResponseDto(
                repository.findUserByUsername(username)
                .orElseThrow(RuntimeException::new));
    }

    // Implementação do método para obter os dados de todos os usuários
    @Override
    public List<UsersResponseDto> getAllUsers() {
        // Busca todos os usuários no banco de dados e converte para uma lista de DTOs de resposta
        return mapper.getALlUsers(repository.findAll());
    }

    @Override
    public UsersResponseDto patchUser(PatchUserDto dto) {
        return null; // Método não implementado
    }

    @Override
    public UsersResponseDto deleteUser(String username) {
        return null; // Método não implementado
    }
}
