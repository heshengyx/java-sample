package com.hsheng.core.netty.message;

/**
 * @description 消息头
 * @author hesheng
 * @date 2020/4/20 14:29
 * @since TODO
 */
public class MessageHeader {

    /**
     * 消息版本
     */
    private int version = 1;

    /**
     * 消息码
     */
    private int code;

    /**
     * 消息标识
     */
    private long reqid;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getReqid() {
        return reqid;
    }

    public void setReqid(long reqid) {
        this.reqid = reqid;
    }
}
