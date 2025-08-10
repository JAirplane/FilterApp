package com.jefferson;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3, 4, 5};

        Integer[] result = Main.filter(arr, x -> x + 1);

        //initial array stay unchanged because Integer is immutable
        for(Integer value: arr) {
            System.out.println(value);
        }

    }

    //Filter<T> do not work for primitive types, so we need an IntFilter etc
    public static <T> T[] filter(T[] arr, Filter<T> filterer) {
        //we can use new Object[arr.length] as well and cast it to T
        //I preferred not to use Arrays.copyOf() because it is a shallow copy
        //so, in this case creating new elements is a job of apply() method
        //otherwise elements of initial array will be changed as well
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);

        for(int i = 0; i < arr.length; i++) {
            result[i] = filterer.apply(arr[i]);
        }

        return result;
    }
}