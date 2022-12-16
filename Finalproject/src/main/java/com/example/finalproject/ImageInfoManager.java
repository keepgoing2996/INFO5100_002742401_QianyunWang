package com.example.finalproject;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite class to handle list of ImageView objects
 * */
public class ImageInfoManager extends javafx.scene.control.Label implements ImageManager{
    private List<javafx.scene.control.Label> infoList = new ArrayList<>();

    // reset all Label objects to null
    public void reset() {
        int numS = infoList.size();
        for (int i = 0; i < numS; i++) {
            infoList.get(i).setText("");
        }
    }

    // add Label
    public void add(javafx.scene.control.Label info) {
        if (info != null) {
            infoList.add(info);
        }
    }

    // get image infor label
    public javafx.scene.control.Label get(int index) {
        try {
            return infoList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nIndex out of bounds Exception");
            return null;
        }
    }

    // get size
    public int size() {
        return infoList.size();
    }
}
