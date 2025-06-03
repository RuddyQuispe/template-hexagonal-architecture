package edu.bo.uyunicode.template.infrastructure.output;

import edu.bo.uyunicode.template.application.ports.output.IUserPersistencePort;
import edu.bo.uyunicode.template.domain.model.UserDto;
import edu.bo.uyunicode.template.infrastructure.output.persistence.entity.UserEntity;
import edu.bo.uyunicode.template.infrastructure.output.persistence.mapper.IUserPersistenceMapper;
import edu.bo.uyunicode.template.infrastructure.output.persistence.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {

    private final IUserPersistenceMapper userMapper;
    private final IUserRepository userRepository;

    @Override
    public Optional<UserDto> findById(Long id) {
        return this.userRepository.findById(id)
                .map(this.userMapper::toUserDto);
    }

    @Override
    public List<UserDto> findAll() {
        return this.userMapper.toUserDtos(this.userRepository.findAll());
    }

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity entity = this.userMapper.toUserEntity(userDto);
        return this.userMapper.toUserDto(this.userRepository.save(entity));
    }

}
