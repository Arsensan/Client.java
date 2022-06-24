package Storage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.fireChannelActive();
        System.out.println("Client connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
        // 5) Здесь насколько я понял, на входе msg должен быть объект Java, который я привожу к Path
        Path path = (Path) msg;
        // 6) Дальше я прохожу по пути , собираю в список текста
        List<Path> result;
        try (
                Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .collect(Collectors.toList());
        }
        // 7) Пытаюсь этот список вывести в консоль , не работает(
        System.out.println(result);
        // 8) Пытаюсь добавить список в графический интерфейс, не работает
        GUI.serverWindow.setText(String.valueOf(result));
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

