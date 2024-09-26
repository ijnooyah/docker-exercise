package com.yoonji.dockermaster.user.service;

import com.yoonji.dockermaster.user.dto.request.SignupRequest;
import com.yoonji.dockermaster.user.dto.response.UserResponse;
import com.yoonji.dockermaster.user.entity.ProviderType;
import com.yoonji.dockermaster.user.entity.RoleType;
import com.yoonji.dockermaster.user.entity.User;
import com.yoonji.dockermaster.common.exception.CustomException;
import com.yoonji.dockermaster.common.exception.ErrorCode;
import com.yoonji.dockermaster.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse signup(SignupRequest request) {
        checkDuplicateEmail(request.getEmail());

        User user = User.builder()
                .nickname(request.getNickname())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(RoleType.ROLE_USER)
                .provider(ProviderType.LOCAL)
                .deleted(false)
                .passwordEncoder(passwordEncoder)
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .nickname(savedUser.getNickname())
                .email(savedUser.getEmail())
                .role(savedUser.getRole().name())
                .build();
    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new CustomException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
    }

}
