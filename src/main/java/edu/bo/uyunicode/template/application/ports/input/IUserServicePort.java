package edu.bo.uyunicode.template.application.ports.input;

import edu.bo.uyunicode.template.domain.model.UserDto;

import java.util.List;

public interface IUserServicePort {
    UserDto findById(Long id);

    UserDto save(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    List<UserDto> findAll();
}
