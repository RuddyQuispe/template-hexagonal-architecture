package edu.bo.uyunicode.template.infrastructure.adapter.input.rest.mapper;

import edu.bo.uyunicode.template.domain.model.UserDto;
import edu.bo.uyunicode.template.infrastructure.adapter.input.rest.model.request.UserCreateRequestDto;
import edu.bo.uyunicode.template.infrastructure.adapter.input.rest.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserRestMapper {
    @Mapping(target = "id", ignore = true)
    UserDto toUserDto(UserCreateRequestDto userCreateRequest);

    UserResponse toUserResponse(UserDto userDto);

    List<UserResponse> toUserResponseList(List<UserDto> userDtoList);
}
