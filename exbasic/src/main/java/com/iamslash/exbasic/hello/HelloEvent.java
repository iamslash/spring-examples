package com.iamslash.exbasic.hello;


import org.springframework.context.ApplicationEvent;

// MyEvent.java
public class HelloEvent extends ApplicationEvent {
    private int data;
    private Object src;

    public HelloEvent(Object src, int data) {
        super(src);
        this.src = src;
        this.data = data;
    }

    public Object getSrc() {
        return src;
    }

    public int getData() {
        return data;
    }
}
