package com.csp.rpccore.transmission;

import com.csp.rpccore.dto.request.RPCRequest;
import com.csp.rpccore.dto.response.RPCResponse;

public interface RpcClient {
    RPCResponse<?> sentReq(RPCRequest rpcRequest);
}
