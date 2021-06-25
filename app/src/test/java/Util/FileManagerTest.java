package Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {



    @Test
    void readFile() {
        FileManager fm = FileManager.getInstance();
        FilePointer fp = new FilePointer();
        fp.setStartOffset(160);
        fp.setEndOffset(166);
        String res = fm.readFile(fp);
        System.out.println(res);
    }

    @Test
    void writeFile() {

        FileManager fm = FileManager.getInstance();
        FilePointer fp = fm.writeFile("GERALDINHORONALDINHO");

        System.out.println("Buffersize:  " + fp.getBufferSize() + "   StartOffset: " + fp.getStartOffset() + "  EndOffset: " + fp.getEndOffset());

    }
}