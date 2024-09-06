package br.com.valkyrie.unisa.ingrid.backend.model.mapper;

import br.com.valkyrie.unisa.ingrid.backend.model.Users;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.NewUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.UsersResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

// Indica que esta interface é um mapper do MapStruct, que será usado para mapear entre objetos
@Mapper(componentModel = "spring", imports = UUID.class)
public interface UsersMapper {

    // Instância do mapper gerada pelo MapStruct
    UsersMapper INSTANCE  = Mappers.getMapper(UsersMapper.class);

    // Mapeia um objeto NewUserDto para um objeto Users
    // Gera um UUID aleatório para o campo userId
    @Mapping(target = "userId", expression = "java(UUID.randomUUID())")
    Users newUserDtoToModel(NewUserDto dto);

    // Mapeia um objeto Users para um objeto UsersResponseDto
    UsersResponseDto modelToResponseDto(Users users);

    // Mapeia uma lista de objetos Users para uma lista de objetos UsersResponseDto
    List<UsersResponseDto> getALlUsers(List<Users> users);
}
