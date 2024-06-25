package com.datefilm.datefilm_server.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException{
    private BaseResponseCode baseResponseCode;
}
