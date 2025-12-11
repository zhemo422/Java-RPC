package com.csp.rpccore.transmission;

import com.csp.rpccore.dto.request.RpcRequest;
import com.csp.rpccore.dto.response.RpcResponse;

public interface RpcClient {
    RpcResponse<?> sentReq(RpcRequest rpcRequest);
}
