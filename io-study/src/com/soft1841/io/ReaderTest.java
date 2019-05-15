package com.soft1841.io;
import java.io.*;
import java.util.Scanner;

/**
 * 控制台输出字符串，加入txt文本中
 * @author 许源 2019年3月26日
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        File file  = new File("D:/Hello.txt");
        System.out.println("请输入内容");
        Scanner scanner = new Scanner(System.in);
        String str =scanner.nextLine();
        char[] chars = str.toCharArray();
        Writer out = new FileWriter(file);
        out.write(chars);
        out.close();



    }

}
