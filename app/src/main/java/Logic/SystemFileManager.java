package Logic;

import Util.FileManager;
import Util.FilePointer;
import lombok.Getter;
import model.Arena;
import model.BTree;
import model.User;

import java.util.ArrayList;

public class SystemFileManager {

    private static SystemFileManager systemFileManager;
    @Getter
    private BTree<Integer, FilePointer> tree;


    private SystemFileManager() {
        tree =  FileManager.getInstance().readSerializableTree("app/src/main/resources/data.tree");
        if(tree == null)
            tree = new BTree<>();
    }

    public static SystemFileManager getInstance() {
        if(systemFileManager != null)
            return systemFileManager;

        systemFileManager = new SystemFileManager();
        return systemFileManager;
    }

    public synchronized void insertTree(User user) {

        String json = new DataParser<>().getJsonFrom(user);
        FilePointer writtenFilePointer = FileManager.getInstance().writeFile(json);

        FilePointer checkFP = tree.get(user.getNickname().hashCode());

        if(checkFP != null) {
            checkFP.copy(writtenFilePointer);
        }else {
            tree.put(user.getNickname().hashCode(), writtenFilePointer);
        }

        FileManager.getInstance().storeSerializableObject(tree, "app/src/main/resources/data.tree");

    }

    public boolean nickNameExist(String nickname) {
        return tree.get(nickname.hashCode()) != null;
    }

    public User getUser(String nickname) {

        FilePointer filePointer = tree.get(nickname.hashCode());

        if(filePointer != null) {
            String json = FileManager.getInstance().readFile(filePointer);
            if(json != null) {
                User user = (new DataParser<>().getValueFrom(json, User.class));
                user.setArenas(new ArrayList<Arena>());
                return user;
            }
        }
        return null;
//        int i = random(0,1000);
      //  return new User("gerald" + i, 1, 1000d); // temp
    }

}
