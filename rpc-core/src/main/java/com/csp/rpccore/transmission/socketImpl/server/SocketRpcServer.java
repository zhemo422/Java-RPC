package com.csp.rpccore.transmission.socketImpl.server;

import com.csp.rpccore.dto.server.RpcServiceConfig;
import com.csp.rpccore.transmission.handler.RpcHandler;
import com.csp.rpccore.provider.ServerProvider;
import com.csp.rpccore.transmission.RpcServer;
import com.csp.rpccore.util.ThreadPoolUtils;
import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

@Slf4j
public class SocketRpcServer implements RpcServer {

    private static ExecutorService executor;
    private final RpcHandler rpcReqHandler;
    private final int port;
    private final ServerProvider serverProvider;

    public SocketRpcServer(ServerProvider serverProvider, int port) {
        this.port = port;
        this.serverProvider = serverProvider;
        this.rpcReqHandler = new RpcHandler(serverProvider);
        this.executor = ThreadPoolUtils.createIoIntensiveThreadPool("socket-rpc-server-");
    }

    @Override
    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("服务启动, 端口: {}", port);
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                executor.submit(new SocketHandler(socket, rpcReqHandler));
            }
        } catch (Exception e) {
            log.error("服务端异常", e);
        }
    }

    @Override
    public void publishService(RpcServiceConfig config) {
        serverProvider.publishService(config);
    }

}
