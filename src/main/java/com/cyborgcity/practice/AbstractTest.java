package com.cyborgcity.practice;

import java.util.Calendar;

/**
 * Created by Ravi on 19-07-2017.
 */
public class AbstractTest {

    public static void main(String[] args) {
        E o = new F();
        boolean b = (o instanceof F) && (!(o instanceof G));
        System.out.println(b);
        System.out.println(foo(8));
        Calendar.getInstance();
    }
    static int foo(int x){
        if (x <= 0)
            return 0;
        else
            return foo(x-2) + x;
    }
}

abstract class A{
    abstract void printA();
}
abstract class B{
    abstract void printB();
}

abstract class C{
    abstract void printC();
}

class E{

}

class F extends E{

}
class G extends F{

}

