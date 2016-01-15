package com.lordjoe.denovoandroidapp.dummy;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.lordjoe.denovoandroidapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample name for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PersonContent {

    private static PersonContent instance;


    public static PersonContent getInstance() {
        return instance;
    }

    /**
     * An array of sample (dummy) items.
     */
    public final List<Person> ITEMS = new ArrayList<Person>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public final Map<String, Person> ITEM_MAP = new HashMap<String, Person>();

    private final int COUNT = 25;

    private final String[] femaleNames;
    private Random RND = new Random();

    public PersonContent(Resources resources) {
        // Add some sample items.
        femaleNames = resources.getStringArray(R.array.female_names);
        for (int i = 1; i <= COUNT; i++) {
            String name = randomFemaleName();

            Drawable icon = resources.getDrawable(R.drawable.baker_roger);
            addItem(createDummyItem(i, name, icon));
        }
        if (instance != null)
            throw new IllegalStateException("Multiple create; use getInstance()");
        instance = this;
    }

    public String randomFemaleName()
    {
        return femaleNames[RND.nextInt(femaleNames.length)];
    }

    private void addItem(Person item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private Person createDummyItem(int position, String name, Drawable icon) {
        return new Person(String.valueOf(position), name, makeDetails(position), icon);
    }

    private List<String> makeDetails(int position) {
        List<String> ret = new ArrayList<String>();
        int numberChildren = RND.nextInt(6);
        for(int i = 0;i < numberChildren; i++)
            ret.add(randomFemaleName());
        return ret;
    }

}
