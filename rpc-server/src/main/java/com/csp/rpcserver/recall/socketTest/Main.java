package com.csp.rpcserver.recall.socketTest;

import com.csp.rpccore.dto.server.RpcServiceConfig;
import com.csp.rpccore.provider.Impl.SimpleServiceProvider;
import com.csp.rpccore.transmission.socketImpl.server.SocketRpcServer;
import com.csp.rpcserver.impl.UserServerImpl;

public class Main {
    public static void main(String[] args) {
        SocketRpcServer socketRpcServer = new SocketRpcServer(new SimpleServiceProvider(), 8080);
        UserServerImpl userServer = new UserServerImpl();
        socketRpcServer.publishService(new RpcServiceConfig("1.0","vip",userServer));
        socketRpcServer.start();
    }
}
