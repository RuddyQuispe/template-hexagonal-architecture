package edu.bo.uyunicode.template.application.ports.output;

import edu.bo.uyunicode.template.domain.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserPersistencePort {
    Optional<UserDto> findById(Long id);

    List<UserDto> findAll();

    UserDto save(UserDto userDto);
}
