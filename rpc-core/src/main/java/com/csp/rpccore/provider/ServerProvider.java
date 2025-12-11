package com.csp.rpccore.provider;

import com.csp.rpccore.dto.server.RpcServiceConfig;

public interface ServerProvider {
    void publishService(RpcServiceConfig config);

    Object getService(String rpcServiceName);
}
