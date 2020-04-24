package com.hsheng.core.netty.message;

/**
 * @description 响应消息
 * @author hesheng
 * @date 2020/4/22 10:29
 * @since TODO
 */
public class ResponseMessage extends Message<OperationResult> {

    @Override
    protected Class getMessageBody(int code) {
        return OperationEnum.fromCode(code).getOperationResultClazz();
    }
}
