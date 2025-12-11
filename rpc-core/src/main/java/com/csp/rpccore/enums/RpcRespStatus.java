package com.csp.rpccore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public enum RpcRespStatus {
    SUCCESS(0, "success"),
    FAIL(1, "fail");
    private final int code;
    private final String msg;

    public static boolean isSuccessful(Integer code) {
        return SUCCESS.getCode() == code;
    }


    public static boolean isFailed(Integer code) {
        return !isSuccessful(code);
    }
}
