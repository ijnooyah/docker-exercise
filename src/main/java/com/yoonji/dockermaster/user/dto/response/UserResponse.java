package com.yoonji.dockermaster.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private String email;
    private String nickname;
    private String picture;
    private String role;

    @Builder
    public UserResponse(String email, String nickname, String role, String picture) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.picture = picture;
    }
}
