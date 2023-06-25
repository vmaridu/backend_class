package spring_boot;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        var flag = StringUtils.startsWith("abcdef", "abc");
        System.out.println(flag);
    }
}