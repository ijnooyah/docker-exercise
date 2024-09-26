package com.yoonji.dockermaster.security.service;

import com.yoonji.dockermaster.user.entity.User;
import com.yoonji.dockermaster.common.exception.CustomException;
import com.yoonji.dockermaster.common.exception.ErrorCode;
import com.yoonji.dockermaster.user.repository.UserRepository;
import com.yoonji.dockermaster.security.principal.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found", new CustomException(ErrorCode.USER_NOT_FOUND)));
        return new UserPrincipal(user, null);
    }
}
