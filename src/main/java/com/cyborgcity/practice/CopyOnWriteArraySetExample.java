package com.cyborgcity.practice;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Ravi on 18-07-2017.
 */
public class CopyOnWriteArraySetExample {
    public static void main(String args[]){

        Set<String> copyOnWriteArraySet=new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add("audi");

        //fail-safe
        Iterator<String> iterator=copyOnWriteArraySet.iterator();
        while(iterator.hasNext()){
            copyOnWriteArraySet.add("newElement1");
            System.out.println(iterator.next());
        }

        //fail-safe
        Enumeration<String> listEnum= Collections.enumeration(copyOnWriteArraySet);
        while(listEnum.hasMoreElements()){
            copyOnWriteArraySet.add("newElement2");
            System.out.println(listEnum.nextElement());
        }

        //enhanced for loop is fail-safe
        for(String string:copyOnWriteArraySet){
            copyOnWriteArraySet.add("newElement3");
            System.out.println(string);
        }



    }
}
