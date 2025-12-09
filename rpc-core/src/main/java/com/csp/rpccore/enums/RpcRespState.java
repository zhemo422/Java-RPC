package com.csp.rpccore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public enum RpcRespState {
    SUCCESS(0, "success"),
    FAIL(1, "fail");
    private final int code;
    private final String msg;
}
