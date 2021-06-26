package Logic;

import Util.FileManager;
import Util.FilePointer;
import model.BTree;
import model.User;

public class SystemFileManager {

    private static SystemFileManager systemFileManager;
    private BTree<Integer, FilePointer> tree;


    private SystemFileManager() {
        tree =  FileManager.getInstance().readSerializableTree("src/main/resources/data.tree");
        if(tree == null)
            tree = new BTree<>();
    }

    public static SystemFileManager getInstance() {
        if(systemFileManager != null)
            return systemFileManager;

        systemFileManager = new SystemFileManager();
        return systemFileManager;
    }

    public void insertTree(){
        //
    }

    /**
     * @return null it doesn't exist
     * */
    public User getUser(String nickname) {

        FilePointer filePointer = tree.get(nickname.hashCode());

        if(filePointer != null) {
            String s = FileManager.getInstance().readFile(filePointer);
            if(s != null) {
                // ----
                /*
                * {
                *   'name': 'gerald'
                *   'exp' : 2
                *
                * }
                * */
            }
        }

        return null;
    }

}
