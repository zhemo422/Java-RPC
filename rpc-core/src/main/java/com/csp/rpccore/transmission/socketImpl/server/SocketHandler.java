package com.csp.rpccore.transmission.socketImpl.server;

import com.csp.rpccore.dto.request.RpcRequest;
import com.csp.rpccore.dto.response.RpcResponse;
import com.csp.rpccore.transmission.handler.RpcHandler;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

@AllArgsConstructor
public class SocketHandler implements Runnable {
    private final Socket socket;
    private final RpcHandler rpcHandler;

    @Override
    @SneakyThrows
    public void run() {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcReq = (RpcRequest) inputStream.readObject();
            Object data = rpcHandler.invoke(rpcReq);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            RpcResponse<?> rpcResp = RpcResponse.success(rpcReq.getReqID(), data);
            outputStream.writeObject(rpcResp);
            outputStream.flush();
    }
}
