package edu.bo.uyunicode.template.infrastructure.adapter.output.persistence.mapper;

import edu.bo.uyunicode.template.domain.model.UserDto;
import edu.bo.uyunicode.template.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserPersistenceMapper {
    // @Mapping(target = "age", source = "edad")
    UserEntity toUserEntity(UserDto user);

    UserDto toUserDto(UserEntity user);

    List<UserDto> toUserDtos(List<UserEntity> users);
}
