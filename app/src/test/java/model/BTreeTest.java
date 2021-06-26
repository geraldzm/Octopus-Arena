package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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