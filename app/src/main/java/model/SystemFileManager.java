package model;

import Util.FileManager;
import Util.FilePointer;

public class SystemFileManager {

    private static SystemFileManager systemFileManager;
    private BTree <Integer, FilePointer> tree;


    private SystemFileManager(){
        tree =  FileManager.readSerializableObject("src/main/resources/data.tree");
        if(tree == null)
            tree = new BTree<>();
    }

    public static SystemFileManager getInstance() {
        if(systemFileManager == null)
            systemFileManager = new SystemFileManager();
        return systemFileManager;
    }

    public void insertTree(){
        //
    }

    public void readTree(){
        //
    }
}
