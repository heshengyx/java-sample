package com.hsheng.core.netty.server.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @description 长度解码器
 * @author hesheng
 * @date 2020/4/23 15:38
 * @since TODO
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {
    public OrderFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
