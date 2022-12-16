package com.example.finalproject;
import java.util.ArrayList;
import java.util.List;
/**
 * Composite class to handle list of ImageView objects
 * */
public class ImageViewManager extends javafx.scene.image.ImageView implements ImageManager{
    private List<javafx.scene.image.ImageView> imageList = new ArrayList<>();

    // reset all ImageView objects to null
    public void reset() {
        int numS = imageList.size();
        for (int i = 0; i < numS; i++) {
            imageList.get(i).setImage(null);
        }
    }

    // add imageView
    public void addImage(javafx.scene.image.ImageView image) {
        if (image != null) {
            image.setPreserveRatio(false);
            image.setFitHeight(100);
            image.setFitWidth(100);
            imageList.add(image);
        }

    }

    // get image view
    public javafx.scene.image.ImageView get(int index) {
        try {
            return imageList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nIndex out of bounds Exception");
            return null;
        }
    }

    // get size
    public int size() {
        return imageList.size();
    }
}
