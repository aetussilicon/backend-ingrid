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

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;
    private final UsersMapper mapper;

    @Override
    public UsersResponseDto signupUser(NewUserDto dto) {
        Optional<Users> checkUserInDatabase = repository.findUserByEmail(dto.getEmail());
        if (checkUserInDatabase.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Users newUser = mapper.newUserDtoToModel(dto);
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());

        repository.save(newUser);

        return mapper.modelToResponseDto(newUser);
    }

    @Override
    public UsersResponseDto getUser(String username) {
        return mapper.modelToResponseDto(
                repository.findUserByUsername(username)
                .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<UsersResponseDto> getAllUsers() {
        return mapper.getALlUsers(repository.findAll());
    }

    @Override
    public UsersResponseDto patchUser(PatchUserDto dto) {
        return null;
    }

    @Override
    public UsersResponseDto deleteUser(String username) {
        return null;
    }
}
