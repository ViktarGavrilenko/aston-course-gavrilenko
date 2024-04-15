package org.example;

import org.example.list.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 11; i++) {
            myArrayList.add((int) (Math.random() * 50) + " someText");
        }
        System.out.println("Source array:");
        System.out.println(myArrayList);
        MyArrayList.bubbleSort(myArrayList);
        System.out.println("Sorted array:");
        System.out.println(myArrayList);

        myArrayList.add(2, "someElement");
        System.out.println("Array with someElement in the third position:");
        System.out.println(myArrayList);

        MyArrayList<String> newTypeList = new MyArrayList<>(myArrayList);

        System.out.println("Collection from constructor with another collection");
        System.out.println(newTypeList);

        newTypeList.bubbleSort();
        System.out.println("Sorted new Array:");
        System.out.println(newTypeList);
        myArrayList.addAll(newTypeList);
        System.out.println("Add all elements from newTypeList to myArrayList:");
        System.out.println(myArrayList);
        myArrayList.remove(1);
        System.out.println("Removed second element from array:");
        System.out.println(myArrayList);
        MyArrayList.bubbleSort(myArrayList);
        System.out.println("Sorted array:");
        System.out.println(myArrayList);

    }
}