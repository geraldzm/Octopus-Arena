package Logic;

import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    void getValueFrom() {

        String j = "{'nickname' : 'Daniel', 'experience' : 20, 'money' : 100.0}";
        User user = new DataParser().getValueFrom(j, User.class);
        System.out.println(user);

    }
}