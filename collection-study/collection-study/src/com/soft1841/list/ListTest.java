package com.soft1841.list;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口的接口练习
 * @author 许源2019年3月19日
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //通过for循环遍历集合
        for (int i =0,len =list.size();i<len;i++){
            System.out.println(list.get(i));
        }
        //通过Interator贴带器遍历集合
        Iterator<String> iterator =list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //通过lambda表达式遍历集合
        list.forEach(s -> System.out.println(s));
    }
}
