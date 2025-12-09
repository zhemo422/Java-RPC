package com.csp.rpccore.dto.response;

import com.csp.rpccore.enums.RpcRespState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RPCResponse<T> implements Serializable {
    private String requestID;
    private String msg;
    private int code;
    private T Data;

    public static <T> RPCResponse<T> success(String requestID, T data, RpcRespState state) {
        RPCResponse<T> RPCResponse = new RPCResponse<>();
        RPCResponse.setData(data);
        RPCResponse.setCode(state.getCode());
        RPCResponse.setMsg(state.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RPCResponse<T> success(String requestID, T data) {
        RPCResponse<T> RPCResponse = new RPCResponse<>();
        RPCResponse.setData(data);
        RPCResponse.setCode(RpcRespState.SUCCESS.getCode());
        RPCResponse.setMsg(RpcRespState.SUCCESS.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RPCResponse<T> success(String requestID, T data, String msg) {
        RPCResponse<T> RPCResponse = new RPCResponse<>();
        RPCResponse.setData(data);
        RPCResponse.setCode(RpcRespState.SUCCESS.getCode());
        RPCResponse.setMsg(msg);
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RPCResponse<T> fail(String requestID, RpcRespState state) {
        RPCResponse<T> RPCResponse = new RPCResponse<>();
        RPCResponse.setCode(state.getCode());
        RPCResponse.setMsg(state.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RPCResponse<T> fail(String requestID, String msg) {
        RPCResponse<T> RPCResponse = new RPCResponse<>();
        RPCResponse.setCode(RpcRespState.FAIL.getCode());
        RPCResponse.setMsg(msg);
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RPCResponse<T> fail(String requestID) {
        RPCResponse<T> RPCResponse = new RPCResponse<>();
        RPCResponse.setCode(RpcRespState.FAIL.getCode());
        RPCResponse.setMsg(RpcRespState.FAIL.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }
}
