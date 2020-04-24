package com.hsheng.core.netty.message.order;

import com.hsheng.core.netty.message.Operation;
import com.hsheng.core.netty.message.OperationResult;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/4/23 15:29
 * @since TODO
 */
public class OrderOperation extends Operation {

    private final int id;
    private final String name;

    public OrderOperation(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public OperationResult execute() {
        return new OrderOperationResult(id, name, true);
    }
}
