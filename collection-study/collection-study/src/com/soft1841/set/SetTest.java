package com.soft1841.set;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.xml.ws.soap.Addressing;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set接口基础程序
 *
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set =new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");

        System.out.println("用for循环输出结果");

        for (int i =0,len =set.size();i<len;i++) {
        }
        //用Iterator迭代器遍历set集合
        System.out.println("用Inerator迭代器输出的结果");
        Iterator<String>iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "  ");
        }
        System.out.println();
        System.out.println("用lambda遍历器输出结果；");
            //用lambda遍历set集合
            set.forEach(s -> System.out.println(s));
        }
    }

