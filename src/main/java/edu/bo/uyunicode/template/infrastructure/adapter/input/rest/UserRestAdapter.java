package edu.bo.uyunicode.template.infrastructure.adapter.input.rest;

import edu.bo.uyunicode.template.application.ports.input.IUserServicePort;
import edu.bo.uyunicode.template.infrastructure.adapter.input.rest.mapper.IUserRestMapper;
import edu.bo.uyunicode.template.infrastructure.adapter.input.rest.model.request.UserCreateRequestDto;
import edu.bo.uyunicode.template.infrastructure.adapter.input.rest.model.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownServiceException;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestAdapter {
    private final IUserServicePort userServicePort;
    private final IUserRestMapper userRestMapper;

    @GetMapping()
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(
                this.userServicePort.findAll().stream().map(this.userRestMapper::toUserResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                this.userRestMapper.toUserResponse(this.userServicePort.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserCreateRequestDto request) {
        return new ResponseEntity<>(this.userRestMapper.toUserResponse(
                this.userServicePort.save(
                        this.userRestMapper.toUserDto(request))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long id, @Valid @RequestBody UserCreateRequestDto request) throws UnknownServiceException {
        return new ResponseEntity<>(
                this.userRestMapper.toUserResponse(
                        this.userServicePort.update(id,
                                this.userRestMapper.toUserDto(request))), HttpStatus.OK);
    }

}
