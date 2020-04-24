package com.hsheng.core.netty.message;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * 消息结构
 * |-------------------frame------------------|
 * |------------------message-----------------|
 * |--------header--------|----body(json)-----|
 * |length|version|code|reqid|operation/result|
 */
/**
 * @description 消息结构
 * @author hesheng
 * @date 2020/4/20 13:29
 * @since TODO
 */
public abstract class Message<T extends MessageBody> {

    /**
     * 消息头
     */
    private MessageHeader messageHeader;

    /**
     * 消息体
     */
    private T messageBody;

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public T getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(T messageBody) {
        this.messageBody = messageBody;
    }

    /**
     * 消息编码
     * @param byteBuf
     */
    public void encode(ByteBuf byteBuf) {
        byteBuf.writeInt(messageHeader.getVersion());
        byteBuf.writeInt(messageHeader.getCode());
        byteBuf.writeLong(messageHeader.getReqid());
        byteBuf.writeBytes(JSON.toJSONString(messageBody).getBytes());
    }

    /**
     * 消息解码
     * @param byteBuf
     */
    public void decode(ByteBuf byteBuf) {
        int version = byteBuf.readInt();
        int code = byteBuf.readInt();
        long reqid = byteBuf.readLong();

        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setVersion(version);
        messageHeader.setCode(code);
        messageHeader.setReqid(reqid);
        this.messageHeader = messageHeader;

        Class<T> clazz = getMessageBody(code);
        T messageBody = JSON.parseObject(byteBuf.toString(Charset.forName("utf-8")), clazz);
        this.messageBody = messageBody;
    }

    /**
     * 获取消息体
     * @param code
     * @return
     */
    protected abstract Class<T> getMessageBody(int code);
}
