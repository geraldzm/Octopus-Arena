package model;

import Logic.NicknameGenerator;
import org.junit.jupiter.api.Test;

class BTreeTest {

    @Test
    void run() {

        BTree tree = new BTree();


        for (int i = 0; i < 100000; i++) {
            String s = NicknameGenerator.getInstance().generateNickname();
            if(tree.get(s.hashCode()) == null)
                tree.put(s.hashCode(), s);
            else
                System.out.println("Name already exists!! " + s);

        }
    }
}