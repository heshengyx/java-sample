package com.hsheng.core.netty.message.order;

import com.hsheng.core.netty.message.OperationResult;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/4/23 15:31
 * @since TODO
 */
public class OrderOperationResult extends OperationResult {

    private final int id;
    private final String name;
    private final boolean flag;

    public OrderOperationResult(int id, String name, boolean flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }
}
