package com.yoonji.dockermaster.user.controller;



import com.yoonji.dockermaster.user.dto.request.UserUpdateRequest;
import com.yoonji.dockermaster.swagger.docs.controller.UserControllerDocs;
import com.yoonji.dockermaster.common.dto.CommonResponse;
import com.yoonji.dockermaster.user.dto.response.UserResponse;
import com.yoonji.dockermaster.security.principal.UserPrincipal;
import com.yoonji.dockermaster.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserControllerDocs {

    private final UserService userService;

    @GetMapping("/me")
    public CommonResponse<UserResponse> getUser(@AuthenticationPrincipal UserPrincipal principal) {
        return new CommonResponse<>(HttpStatus.OK, userService.getUser(principal));
    }

    @GetMapping("/{id}/profile")
    public CommonResponse<UserResponse> getUserProfile(@PathVariable Long id) {
        return new CommonResponse<>(HttpStatus.OK, userService.getUserProfile(id));
    }

    @PatchMapping("/me")
    public CommonResponse<UserResponse> updateUserProfile(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody UserUpdateRequest request) {
        return new CommonResponse<>(HttpStatus.OK, userService.updateUserProfile(userPrincipal, request));
    }


}
