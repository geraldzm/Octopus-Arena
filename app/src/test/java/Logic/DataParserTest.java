package Logic;

import Util.FileManager;
import Util.FilePointer;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    void getValueFrom() {

        FilePointer fp = new FilePointer();
        fp.setStartOffset(68);
        fp.setEndOffset(129);
        //System.out.println(FileManager.getInstance().readFile(fp));
        User user = new DataParser().getValueFrom(FileManager.getInstance().readFile(fp), User.class);
        System.out.println(user);

    }
}