package io.github.kimmking.gateway.outbound.netty4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HttpClientInboundHandler extends ChannelInboundHandlerAdapter {

	private ChannelHandlerContext channelHandlerContext;

	public HttpClientInboundHandler(ChannelHandlerContext channelHandlerContext){
		this.channelHandlerContext = channelHandlerContext;
	}

	int length = 0;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpResponse)
		{
			HttpResponse response = (HttpResponse) msg;
			length = Integer.parseInt(response.headers().get(HttpHeaders.Names.CONTENT_LENGTH));
			System.out.println("Content-Length:" + length);
		}
		if(msg instanceof HttpContent)
		{
			HttpContent content = (HttpContent)msg;
			ByteBuf buf = content.content();

			FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, buf);
			response.headers().set("Content-Type", "application/json");
			response.headers().setInt("Content-Length", length);

			channelHandlerContext.write(response);
			channelHandlerContext.flush();
			System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
			buf.release();
		}
	}
}