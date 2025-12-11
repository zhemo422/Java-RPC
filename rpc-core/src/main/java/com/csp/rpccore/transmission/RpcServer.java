package com.csp.rpccore.transmission;

import com.csp.rpccore.dto.server.RpcServiceConfig;

public interface RpcServer {
    void start();


    public void publishService(RpcServiceConfig config);
}
