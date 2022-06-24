package Storage;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;


public class Client {
    static Path clientPath;
// 1) метод принимающий древо файлов и возвращает его в виде списка текста в окно клиента в GUI
    public static String clientFileList(Path path) throws IOException {
        List<Path> result;
        try (
                Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .collect(Collectors.toList());
        }
        return String.valueOf(result);
    }


    public static void main(String[] args) throws Exception {


        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {
                @Override
                public void initChannel(io.netty.channel.socket.SocketChannel ch) {
                    ch.pipeline().addLast(
                            new ObjectEncoder(),
                            // 2) по идее ОbjectDecoder при отправке сообщения с сервера приводит ByteBuf к объекту Java, который
                            // в свою очередь попадает в  ClientHandler , где я обрабатываю его как мне надо
                        new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
                            new ClientHandler());
                }
            });
            ChannelFuture f = b.connect("localhost", 8189).sync();
            // 3) Создаю папку клиента
            clientPath = Paths.get("src\\ClientDirectory");
            // 4) Запускаю графический интерфейс
            SwingUtilities.invokeLater(() -> {
                try {
                    new GUI();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

}

