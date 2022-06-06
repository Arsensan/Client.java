package Server;
// Библиотеки netty не подружаются!

public class ServerHandler  extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override

        public void exceptionCaught (ChannelHandlerContext ctx, Throwable cause){
            cause.printStackTrace();
            ctx.close();
        }
    }


