package xyz.berby.im.util;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultValueTest {

    @Test
    public void test() {
        String expression = "0.userId=user";
        String[] args = expression.split(",");
        Pattern pattern = Pattern.compile("(\\d)\\.(\\w+)=(\\w+)\\.?(\\w+)?");
        Matcher m = pattern.matcher(expression);
        System.out.println(m.groupCount());
        while (m.find()) {

            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
            System.out.println("Found value: " + (m.group(4) == null) );
        }
    }
}
