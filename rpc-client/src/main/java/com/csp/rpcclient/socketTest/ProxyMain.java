package com.csp.rpcclient.socketTest;

import com.csp.rpcapi.UserService;
import com.csp.rpccore.proxy.RpcProxy;
import com.csp.rpccore.transmission.socketImpl.client.SocketRpcClient;

public class ProxyMain {
    public static void main(String[] args) {
        SocketRpcClient socketRpcClient = new SocketRpcClient();
        RpcProxy rpcProxy = new RpcProxy(socketRpcClient,"vip","1.0" );
        UserService proxy = rpcProxy.getProxy(UserService.class);
        System.out.println(proxy.getUser("小明", 1L));
    }
}
