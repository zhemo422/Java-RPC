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
public class RpcResponse<T> implements Serializable {
    private String requestID;
    private String msg;
    private int code;
    private T Data;

    public static <T> RpcResponse<T> success(String requestID, T data, RpcRespState state) {
        RpcResponse<T> RPCResponse = new RpcResponse<>();
        RPCResponse.setData(data);
        RPCResponse.setCode(state.getCode());
        RPCResponse.setMsg(state.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RpcResponse<T> success(String requestID, T data) {
        RpcResponse<T> RPCResponse = new RpcResponse<>();
        RPCResponse.setData(data);
        RPCResponse.setCode(RpcRespState.SUCCESS.getCode());
        RPCResponse.setMsg(RpcRespState.SUCCESS.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RpcResponse<T> success(String requestID, T data, String msg) {
        RpcResponse<T> RPCResponse = new RpcResponse<>();
        RPCResponse.setData(data);
        RPCResponse.setCode(RpcRespState.SUCCESS.getCode());
        RPCResponse.setMsg(msg);
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RpcResponse<T> fail(String requestID, RpcRespState state) {
        RpcResponse<T> RPCResponse = new RpcResponse<>();
        RPCResponse.setCode(state.getCode());
        RPCResponse.setMsg(state.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RpcResponse<T> fail(String requestID, String msg) {
        RpcResponse<T> RPCResponse = new RpcResponse<>();
        RPCResponse.setCode(RpcRespState.FAIL.getCode());
        RPCResponse.setMsg(msg);
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }

    public static <T> RpcResponse<T> fail(String requestID) {
        RpcResponse<T> RPCResponse = new RpcResponse<>();
        RPCResponse.setCode(RpcRespState.FAIL.getCode());
        RPCResponse.setMsg(RpcRespState.FAIL.getMsg());
        RPCResponse.setRequestID(requestID);
        return RPCResponse;
    }
}
