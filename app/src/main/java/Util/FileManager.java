package Util;

import lombok.Synchronized;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class FileManager {

    private String path;
    private static FileManager instance = new FileManager("./data.game");

    private FileManager(String pPath){
        this.path = pPath;
    }

    public static FileManager getInstance(){
        return instance;
    }

    public synchronized String readFile(FilePointer p){
        try(RandomAccessFile file = new RandomAccessFile(path, "r")) {
            byte[] dest = new byte[p.getBufferSize()];
            file.seek(p.getStartOffset());
            file.read(dest, 0, p.getBufferSize());
            return new String(dest, StandardCharsets.UTF_8);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public synchronized FilePointer writeFile(String value){
        try(RandomAccessFile file = new RandomAccessFile(path, "rw")) {
            FilePointer p = new FilePointer();
            file.seek(file.length());
            p.setStartOffset(file.getFilePointer());
            byte[] dest = value.getBytes(StandardCharsets.UTF_8);
            file.write(dest);
            p.setEndOffset(file.getFilePointer());
            return p;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
