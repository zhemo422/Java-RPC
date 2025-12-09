package com.csp.rpccore.transmission.socketImpl;

import com.csp.rpccore.dto.request.RPCRequest;
import com.csp.rpccore.dto.response.RPCResponse;
import com.csp.rpccore.transmission.RpcClient;
import lombok.extern.slf4j.Slf4j;

import java.net.Socket;

@Slf4j
public class socketRpcClient implements RpcClient {
    @Override
    public RPCResponse<?> sentReq(RPCRequest rpcRequest) {
        try (Socket socket = new Socket("127.0.0.1", 8088)) {
            

        } catch (Exception e) {
            log.error("套接字失败");
        }
        return null;
    }
}
