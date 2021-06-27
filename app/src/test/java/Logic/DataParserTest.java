package Logic;

import Util.FileManager;
import Util.FilePointer;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    void getValueFrom() {

//        FilePointer fp = new FilePointer();
//        fp.setStartOffset(68);
//        fp.setEndOffset(129);
//        //System.out.println(FileManager.getInstance().readFile(fp));
//        User user = new DataParser<>().getValueFrom(FileManager.getInstance().readFile(fp), User.class);
//        System.out.println(user);

        User user = new User("unselfish-ArcticWolf669", 5, 1200.0);
        User user1 = new User("cuddly-Sheep804", 10, 2100.0);
        User user2 = new User("gentle-Blackbird609", 4, 500.0);
        User user3 = new User("rapid-Raccoon461", 15, 1200.0);
        User user4 = new User("excellent-Raven317", 1, 1200.0);
        User user5 = new User("polished-Snake548", , 1200.0);
        User user6 = new User("excellent-Raven317", 5, 1200.0);
        SystemFileManager.getInstance().insertTree(user);
        SystemFileManager.getInstance().insertTree(user1);
        SystemFileManager.getInstance().insertTree(user2);
        SystemFileManager.getInstance().insertTree(user3);
        SystemFileManager.getInstance().insertTree(user4);
        SystemFileManager.getInstance().insertTree(user5);
        SystemFileManager.getInstance().insertTree(user6);
//        User user = SystemFileManager.getInstance().getUser("gentle-Blackbird609");
//        System.out.println(user);
    }
}