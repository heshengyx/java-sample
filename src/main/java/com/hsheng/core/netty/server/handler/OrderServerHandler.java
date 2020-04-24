package com.hsheng.core.netty.server.handler;

import com.hsheng.core.netty.message.Operation;
import com.hsheng.core.netty.message.OperationResult;
import com.hsheng.core.netty.message.RequestMessage;
import com.hsheng.core.netty.message.ResponseMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/4/23 15:59
 * @since TODO
 */
public class OrderServerHandler extends SimpleChannelInboundHandler<RequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {
        Operation operation = requestMessage.getMessageBody();
        OperationResult operationResult = operation.execute();

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageHeader(requestMessage.getMessageHeader());
        responseMessage.setMessageBody(operationResult);
        ctx.writeAndFlush(responseMessage);
    }
}
