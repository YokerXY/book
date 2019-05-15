package com.soft1841.io;

import java.io.*;

public class TestCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:/Hello.txt");
        File destFile = new File("D:/Hello.副本.txt");
        FileReader in  = new FileReader(srcFile);
        char [] chars = new char [(int)srcFile.length()];
        in.read(chars);
        Writer out = new FileWriter(destFile);
        out.write(chars);
        in.close();
        out.close();
    }
}
