package edu.bo.uyunicode.template.application.ports.input;

import edu.bo.uyunicode.template.domain.model.UserDto;

import java.net.UnknownServiceException;
import java.util.List;

public interface IUserServicePort {
    UserDto findById(Long id);

    UserDto save(UserDto userDto);

    UserDto update(Long id, UserDto userDto) throws UnknownServiceException;

    List<UserDto> findAll();
}
