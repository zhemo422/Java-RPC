package com.csp.rpccore.transmission.handler;

import com.csp.rpccore.dto.request.RpcRequest;
import com.csp.rpccore.provider.ServerProvider;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class RpcHandler {
    //    private static final Map<String, RateLimiter> RATE_LIMITER_MAP = new ConcurrentHashMap<>();
    private final ServerProvider simpleServiceProvider;

    public RpcHandler(ServerProvider serviceProvider) {
        this.simpleServiceProvider = serviceProvider;
    }

    @SneakyThrows
    public Object invoke(RpcRequest request) {
        String rpcServiceName = request.getServerName();
        Object service = simpleServiceProvider.getService(rpcServiceName);
        log.debug("获取到对应服务: {}", service.getClass().getCanonicalName());
        Method method = service.getClass().getMethod(request.getMethodName(), request.getParamType());
        return method.invoke(service, request.getParams());
    }

}
