package com.heulwen.base.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExceptionInfo {
    private String errorCode;
    private String message;
    private List<String> listMessage;
}
