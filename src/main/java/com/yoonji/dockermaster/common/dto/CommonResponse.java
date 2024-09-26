package com.yoonji.dockermaster.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponse<T> {

    private final HttpStatus status;
    private final T body;

    public CommonResponse(HttpStatus status) {
        this.status = status;
        this.body = null;
    }

    @Builder
    public CommonResponse(HttpStatus status, T body) {
        this.status = status;
        this.body = body;
    }
}
