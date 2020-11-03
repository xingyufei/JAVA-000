package io.github.kimmking.gateway.outbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * OutboundHandler接口
 *
 * Xingyufei
 *
 * 2020-11-01
 */
public interface OutboundHandler {

    /**
     * 处理请求
     *
     * @param ctx
     * @param fullHttpRequest
     */
    void handle(final FullHttpRequest fullHttpRequest, final ChannelHandlerContext ctx);
}