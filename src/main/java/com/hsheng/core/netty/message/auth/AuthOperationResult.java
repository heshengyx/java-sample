package com.hsheng.core.netty.message.auth;

import com.hsheng.core.netty.message.OperationResult;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/4/23 15:10
 * @since TODO
 */
public class AuthOperationResult extends OperationResult {

    private final boolean flag;

    public AuthOperationResult(boolean flag) {
        this.flag = flag;
    }
}
