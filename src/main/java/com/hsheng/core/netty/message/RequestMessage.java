package com.hsheng.core.netty.message;

/**
 * @description 请求消息
 * @author hesheng
 * @date 2020/4/22 10:26
 * @since TODO
 */
public class RequestMessage extends Message<Operation> {

    public RequestMessage() {}

    public RequestMessage(Long reqid, Operation operation) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setReqid(reqid);
        messageHeader.setCode(OperationEnum.fromOperation(operation).getCode());
        this.setMessageHeader(messageHeader);
        this.setMessageBody(operation);
    }

    @Override
    protected Class getMessageBody(int code) {
        return OperationEnum.fromCode(code).getOperationClazz();
    }
}
