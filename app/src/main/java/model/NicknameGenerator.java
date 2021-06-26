package model;

import GA.model.CrossoverFactory;
import Util.Utility;
import lombok.Synchronized;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class NicknameGenerator {

    private static NicknameGenerator nicknameGenerator;

    public static NicknameGenerator getInstance() {
        if(nicknameGenerator == null)
            init();
        return nicknameGenerator;
    }

    private static void init() {
        nicknameGenerator = new NicknameGenerator();
    }

    public String generateNickname(){

        String adjective = chooseRandomValue("src/main/resources/data.adjectives");
        String animal = chooseRandomValue("src/main/resources/data.animals");
        int number = Utility.random(0, 1000);
        String nickname = adjective + "-"+animal + number;

        // validar si existe o no

        return nickname;
    }

    public synchronized String chooseRandomValue(String pPath){
        try(RandomAccessFile file = new RandomAccessFile(pPath, "r")) {
            StringBuilder value = new StringBuilder();
            file.seek(Utility.random(0, (int) (file.length() - 1)));
            if (!readChar(file).equals(","))
                backtrackUntilComma(file);
            return getStringValue(file, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void backtrackUntilComma(RandomAccessFile file) throws IOException {
        while((int)file.getFilePointer()!= 0 && !readChar(file).equals(","))
            file.seek(file.getFilePointer() - 2);
    }


    private String getStringValue(RandomAccessFile file, StringBuilder value) throws IOException {
        while((int)file.getFilePointer() != (int) file.length() && !readChar(file).equals(",")){
            file.seek(file.getFilePointer()-1);
            value.append(readChar(file));
        }
        return value.toString();
    }

    private String readChar(RandomAccessFile file) throws IOException {
        byte tmpByte = file.readByte();
        byte[] tmpByteArray = {tmpByte};
        return new String(tmpByteArray, StandardCharsets.UTF_8);
    }
}
