package br.com.valkyrie.unisa.ingrid.backend.model.mapper;

import br.com.valkyrie.unisa.ingrid.backend.model.Users;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.NewUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.UsersResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface UsersMapper {
    UsersMapper INSTANCE  = Mappers.getMapper(UsersMapper.class);

    @Mapping(target = "userId", expression = "java(UUID.randomUUID())")
    Users newUserDtoToModel(NewUserDto dto);

    UsersResponseDto modelToResponseDto(Users users);

    List<UsersResponseDto> getALlUsers(List<Users> users);
}
