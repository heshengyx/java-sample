package com.hsheng.core.netty.message;

/**
 * @description 操作
 * @author hesheng
 * @date 2020/4/22 10:23
 * @since TODO
 */
public abstract class Operation extends MessageBody {

    /**
     * 获取操作结果
     * @return
     */
    public abstract OperationResult execute();
}
