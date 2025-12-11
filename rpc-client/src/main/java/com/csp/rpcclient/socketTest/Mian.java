package com.csp.rpcclient.socketTest;

import com.csp.rpcapi.User;
import com.csp.rpccore.dto.request.RpcRequest;
import com.csp.rpccore.dto.response.RpcResponse;
import com.csp.rpccore.transmission.RpcClient;
import com.csp.rpccore.transmission.socketImpl.client.SocketRpcClient;

import java.util.UUID;

public class Mian {
    public static void main(String[] args) {
        RpcClient rpcClient = new SocketRpcClient("127.0.0.1", 8080);
        String group = "vip";
        String version = "1.0";
        String interfaceName = "com.csp.rpcapi.UserService";
        String serviceName = interfaceName + version + group;
        RpcRequest rpcRequest = RpcRequest.builder()
                .requestID(UUID.randomUUID().toString())
                .group(group)
                .version(version)
                .interfaceName("com.csp.rpcapi.UserService")
                .params(new Object[]{"name", 1L})
                .paramType(new Class[]{String.class, long.class})
                .serverName(serviceName)
                .methodName("getUser")
                .build();
        RpcResponse<?> rpcResponse = rpcClient.sentReq(rpcRequest);
        System.out.println((User) rpcResponse.getData());
    }
}
