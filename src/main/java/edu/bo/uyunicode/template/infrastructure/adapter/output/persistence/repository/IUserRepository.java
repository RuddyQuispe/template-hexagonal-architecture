package edu.bo.uyunicode.template.infrastructure.adapter.output.persistence.repository;

import edu.bo.uyunicode.template.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
