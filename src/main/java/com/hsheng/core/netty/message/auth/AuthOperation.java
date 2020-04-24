package com.hsheng.core.netty.message.auth;

import com.hsheng.core.netty.message.Operation;
import com.hsheng.core.netty.message.OperationResult;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/4/23 15:07
 * @since TODO
 */
public class AuthOperation extends Operation {

    private final String username;
    private final String password;

    public AuthOperation() {
        this.username = "zhangsan";
        this.password = "123456";
    }

    @Override
    public OperationResult execute() {
        if ("zhangsan".equals(this.username)) {
            return new AuthOperationResult(true);
        }
        return new AuthOperationResult(false);
    }
}
