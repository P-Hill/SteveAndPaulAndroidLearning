package com.lordjoe.denovoandroidapp.dummy;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * A dummy item representing a piece of name.
 */
public class Person {
    public final String id;
    public final String name;
    public final Drawable icon;
    public final List<String> childrenNames;

    public Person(String id, String name, List<String> childre, Drawable icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        childrenNames = new ArrayList<>(childre);
    }

    @Override
    public String toString() {
        return name;
    }
}
