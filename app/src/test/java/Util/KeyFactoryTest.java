package Util;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class KeyFactoryTest {

    @Test
    void getRSAKeys() {

        Date d = new Date();
        System.out.println(d.getTime());
        KeyPair kp = KeyFactory.getRSAKeys();
        Date p = new Date();
        System.out.println(p.getTime());

        String s = "Este es el mensaje secreto, shhhh";

        byte[] b = KeyFactory.do_RSAEncryption(s,kp.getPublic());

        System.out.println(b);

        String res = KeyFactory.do_RSADecryption(b, kp.getPrivate());
        System.out.println(res);
    }
}