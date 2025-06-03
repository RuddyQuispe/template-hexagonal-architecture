package edu.bo.uyunicode.template.infrastructure.output.persistence.repository;

import edu.bo.uyunicode.template.infrastructure.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
