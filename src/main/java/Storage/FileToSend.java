package Storage;

import java.io.Serializable;

public class FileToSend implements Serializable {
    String fileName;
    byte[] file;
    int fileSize;

    public FileToSend(String fileName, byte[] file, int fileSize) {
        this.fileName = fileName;
        this.file = file;
        this.fileSize = fileSize;
    }

    public FileToSend(byte[] file, int fileSize) {
        this.file = file;
        this.fileSize = fileSize;
    }

    public FileToSend(byte[] file) {
        this.file = file;

    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public int getFileSize() {
        return fileSize;
    }
}
