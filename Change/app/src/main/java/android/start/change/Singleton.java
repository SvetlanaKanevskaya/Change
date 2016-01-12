package android.start.change;

import java.util.ArrayList;


public class Singleton {
    private static Singleton instanse;
    private ArrayList<Currency> array;

    private Singleton() {
        array = new ArrayList<>();
    }

    public static Singleton makeArray() {
        if (instanse == null) instanse = new Singleton();
        return instanse;
    }

    public ArrayList<Currency> getArray() {
        return array;
    }
}



