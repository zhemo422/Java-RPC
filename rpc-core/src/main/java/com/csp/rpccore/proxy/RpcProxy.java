package com.csp.rpccore.proxy;

import cn.hutool.core.util.IdUtil;
import com.csp.rpccore.dto.request.RpcRequest;
import com.csp.rpccore.dto.response.RpcResponse;
import com.csp.rpccore.dto.server.RpcServiceConfig;
import com.csp.rpccore.enums.RpcRespStatus;
import com.csp.rpccore.exception.RpcException;
import com.csp.rpccore.transmission.RpcClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

@AllArgsConstructor
public class RpcProxy implements InvocationHandler {
    private final RpcClient rpcClient;
    String group;
    String version;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String interfaceName = method.getDeclaringClass().getCanonicalName();
        String methodName = method.getName();
//        String version = serviceConfig.getVersion();
//        String group = serviceConfig.getGroup();
        String serviceName = interfaceName + version + group;
        RpcRequest rpcRequest = RpcRequest.builder()
                .requestID(IdUtil.fastSimpleUUID())
                .group(group)
                .version(version)
                .interfaceName(interfaceName)
                .params(args)
                .paramType(method.getParameterTypes())
                .serverName(serviceName)
                .methodName(methodName)
                .build();
        RpcResponse<?> rpcResponse = rpcClient.sentReq(rpcRequest);
        check(rpcRequest, rpcResponse);
        return rpcResponse.getData();
    }

    private void check(RpcRequest rpcReq, RpcResponse<?> rpcResp) {
        if (Objects.isNull(rpcResp)) throw new RpcException("rpcResponse为空");
        if (!Objects.equals(rpcReq.getRequestID(), rpcResp.getRequestID()))
            throw new RpcException("请求和响应的id不一致");
        if (RpcRespStatus.isFailed(rpcResp.getCode())) throw new RpcException("响应值为失败: " + rpcResp.getMsg());
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }
}
