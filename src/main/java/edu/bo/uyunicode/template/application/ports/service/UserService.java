package edu.bo.uyunicode.template.application.ports.service;

import edu.bo.uyunicode.template.application.ports.input.IUserServicePort;
import edu.bo.uyunicode.template.application.ports.output.IUserPersistencePort;
import edu.bo.uyunicode.template.domain.exception.UserNotFoundException;
import edu.bo.uyunicode.template.domain.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    @Override
    public UserDto findById(Long id) {
        return this.userPersistencePort.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User %s not exists".formatted(id)));
    }

    @Override
    public UserDto save(UserDto userDto) {
        return this.userPersistencePort.save(userDto);
    }

    @Override
    public UserDto update(Long id, UserDto userDto) throws UnknownServiceException {
        return this.userPersistencePort.findById(id)
                .map(u -> this.userPersistencePort.save(new UserDto(u.id(), u.username(), u.nickname(), u.isEnabled())))
                .orElseThrow(UnknownServiceException::new);
    }

    @Override
    public List<UserDto> findAll() {
        return this.userPersistencePort.findAll();
    }
}
