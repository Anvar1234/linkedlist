package org.example;

import org.example.anvarlinkedlist.AnvarList;
import org.example.anvarlinkedlist.list.AnvarLinkedList;

public class Main {
    public static void main(String[] args) {
        AnvarList<String> list = new AnvarLinkedList<>();
        list.add("str3");
        list.add(("str3"));
        list.add("str3");
        list.add("str4");
        list.add(("str3"));
        list.add("str5");

        //for-each почему-то удаляет все эл из листа
//        for(String s : list){
//            System.out.println(s);
//        }
//        System.out.println(list);

//        System.out.println("size = " + list.size());
//        System.out.println("set = " + list.set(0, "123"));
//        System.out.println("get = " + list.get(0));
//        System.out.println("list after set element:\n" + list);

        //если есть одинаковые значения в листе, то удаляет первое встреченное.
        list.remove("str3");
        System.out.println("list after remove:\n" + list);
        System.out.println("size = " + list.size());
    }
}