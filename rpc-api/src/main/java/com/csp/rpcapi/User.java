package com.csp.rpcapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User implements Serializable {
    String name;
    long id;
}
