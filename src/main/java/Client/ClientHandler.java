package Client;

// Библиотеки netty не подружаются!
    public class ClientHandler extends ChannelInboundHandlerAdapter {


        @Override
        public void channelActive(ChannelHandlerContext ctx) {

            ChannelFuture future = ctx.writeAndFlush(firstMessage);
            future.addListener(FIRE_EXCEPTION_ON_FAILURE);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {

            ctx.write(msg);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
