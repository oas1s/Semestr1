package tests;

import db.MD5Util;

public class HashTest {
    public static void main(String[] args) {
        String st = "azattt";

        System.out.println("Custom MD5:");
        System.out.println(MD5Util.md5Custom(st));
    }
}

