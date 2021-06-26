package Util;

import model.BTree;

import java.io.*;
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

    public synchronized String readFile(FilePointer p) {

        try(RandomAccessFile file = new RandomAccessFile(path, "r")) {

            byte[] dest = new byte[p.getBufferSize()];
            file.seek(p.getStartOffset());
            file.read(dest, 0, p.getBufferSize());

            return new String(dest, StandardCharsets.UTF_8);
        }catch (Exception e) {
            e.printStackTrace();
            System.err.println("Count not read file pointer: " + p);
        }

        return null;
    }

    public synchronized FilePointer writeFile(String value) {
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


    public boolean storeSerializableObject(BTree<Integer, FilePointer> obj, String path) {

        try(OutputStream outputStream = new FileOutputStream(path)) {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(obj);
            return true;
        }catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public BTree<Integer, FilePointer> readSerializableTree(String path) {

        BTree<Integer, FilePointer> rs = null;
        try(InputStream inputStream = new FileInputStream(path)) {

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            rs = (BTree<Integer, FilePointer>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return rs;
    }


}
