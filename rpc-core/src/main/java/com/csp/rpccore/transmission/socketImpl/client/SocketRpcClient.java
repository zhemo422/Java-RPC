package com.csp.rpccore.transmission.socketImpl.client;

import com.csp.rpccore.dto.request.RpcRequest;
import com.csp.rpccore.dto.response.RpcResponse;
import com.csp.rpccore.transmission.RpcClient;
import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

@Slf4j
public class SocketRpcClient implements RpcClient {

    private String address = "127.0.0.1";
    private int port = 8088;

    public SocketRpcClient(String address, int port) {
        this.address = address;
        this.port = port;
    }

    @Override
    public RpcResponse<?> sentReq(RpcRequest rpcRequest) {
        try (Socket socket = new Socket(address, port)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rpcRequest);
            outputStream.flush();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object o = objectInputStream.readObject();
            return (RpcResponse<?>) o;
        } catch (Exception e) {
            log.error("套接字失败");
        }
        return null;
    }

}
