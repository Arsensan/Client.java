package Storage;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerHandler  extends ChannelInboundHandlerAdapter {
Path serverPath;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

    }
// 11) При соединении с клиентом передаю список файлов сервера
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        // 12) создаю путь к файлам сервера
        serverPath = Paths.get("src\\ServerDirectory");
        // 13) Оборачиваю путь к файлу в сериализуемый объект Java  serverFileList
        ServerFileList serverFileList = new ServerFileList(serverPath);
        // 14) Отправялю клиенту
        ctx.writeAndFlush(serverFileList);
        System.out.println("Client connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
      ctx.write(msg);
       ctx.flush();


    }
    @Override
    public void exceptionCaught (ChannelHandlerContext ctx, Throwable cause){
        System.out.println("Client disconnected");
            ctx.close();
        }


    }


