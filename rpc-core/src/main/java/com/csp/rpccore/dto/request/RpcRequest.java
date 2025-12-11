package com.csp.rpccore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RpcRequest implements Serializable {
    private static final long serialVersion = 1L;
    private String reqID;
    private String methodName;
    private String group;
    private String version;
    private String serverName;
    private Class<?>[] paramType;
    private Object[] params;
    private String interfaceName;

}
