package com.zxin.louvre.learn;

public class InstanceLearn {

    
    public static void main(String[] args) {
        
        InstancePClass instance = new InstanceCClass();
        
        System.out.println(instance instanceof InstancePClass);
        System.out.println(instance instanceof InstanceCClass);
        
    }
    
}

interface InstancePClass {
    
}

class InstanceCClass implements InstancePClass {
    
}
