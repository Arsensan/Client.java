package Storage;

import java.io.Serializable;
import java.nio.file.Path;
// 10) Создаю сериализуемый объект ServerFileList в котором собираюсь передавать список файлов сервера на клиент
public class ServerFileList implements Serializable {
    Path path;

    public ServerFileList(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "serverFileList{" +
                "path=" + path +
                '}';
    }
}
