package com.demo.jvm.other_test;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/1 13:44
 * @Description:
 */

public enum Stage {

    PRE("学前"),
    PRIMARY("小学"),
    MIDDLE("初中"),
    HIGH("高中"),
    TECHNICAL("中专、中职"),
    //COLLEGE("大学"),
    OTHER("其它");

    private String text;

    Stage(String text) {
        this.text = text;
    }
    public int getValue() {
        return this.ordinal();
    }
    public String getText() {
        return text;
    }
    static String values[] = {"学前","小学","初中","高中","中专、中职","其它"};
    public static String valueOf(int ordinal){
        if (ordinal < 0 || ordinal >= values().length) {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
        return values[ordinal];
    }
}
