package com.yoonji.dockermaster.swagger.docs.controller;


import com.yoonji.dockermaster.user.dto.request.UserUpdateRequest;
import com.yoonji.dockermaster.common.dto.CommonResponse;
import com.yoonji.dockermaster.user.dto.response.UserResponse;
import com.yoonji.dockermaster.common.exception.ErrorResponse;
import com.yoonji.dockermaster.security.principal.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "User API")
public interface UserControllerDocs {

    @Operation(summary = "회원 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 정보 조회 성공"),
            @ApiResponse(responseCode = "401", description = "회원 정보 조회 실패(권한 없음)",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    CommonResponse<UserResponse> getUser(@AuthenticationPrincipal UserPrincipal userPrincipal);

    @Operation(summary = "회원 프로필 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 프로필 조회 성공"),
            @ApiResponse(responseCode = "401", description = "회원 프로필 조회 실패(권한 없음)",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    CommonResponse<UserResponse> getUserProfile(@PathVariable Long id);

    @Operation(summary = "회원 정보 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 정보 수정 성공"),
            @ApiResponse(responseCode = "401", description = "회원 정보 수정 실패(권한 없음)",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    CommonResponse<UserResponse> updateUserProfile(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody UserUpdateRequest request);


    }
