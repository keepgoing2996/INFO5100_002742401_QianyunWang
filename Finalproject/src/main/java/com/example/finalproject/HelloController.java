package com.example.finalproject;

/**
 * Controller for image tool management
 * */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javafx.stage.DirectoryChooser;
public class HelloController {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button multiple;

    @FXML
    private Button gifFormat;

    @FXML
    private Label imageInfo0;

    @FXML
    private Label imageInfo1;

    @FXML
    private Label imageInfo2;

    @FXML
    private Label imageInfo3;

    @FXML
    private ImageView imageView0;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private Button jpegFormat;
    @FXML
    private Button pngFormat;

    @FXML
    private Button tiffFormat;

    // files list to hold the user selected images.
    private List<File> files = new ArrayList<>();
    // default saved image format
    private String imageFormat = ".png";

    // max number of files to open
    private static int maxFiles = 4;

    // imageViewManager
    private ImageViewManager imageViewManager = new ImageViewManager();

    // imageInfoManager
    private ImageInfoManager imageInfoManager = new ImageInfoManager();

    // choose different image format to save
    @FXML
    void onFormatButtonClick(ActionEvent event) {
        if (event.getSource() == pngFormat) {
            imageFormat = ".png";
        } else if (event.getSource() == tiffFormat) {
            imageFormat = ".tiff";
        } else if (event.getSource() == jpegFormat) {
            imageFormat = ".jpeg";
        } else if (event.getSource() == gifFormat) {
            imageFormat = ".gif";
        } else {
            imageFormat = ".png";
        }
    }

    // remove file extension
    static String removeExtension (String str) {
        if (str == null) return null;
        int pos = str.lastIndexOf(".");
        if (pos == -1) return str;
        return str.substring(0, pos);
    }

    // download the images
    @FXML
    void onDownload(ActionEvent event) {
        // select download folder
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle("Select directories to download images to");
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        File chosenDir = dirChooser.showDialog(stage);

        // download images
        DownloadNode downloadNode = DownloadNode.getDownloadNode();
        if (chosenDir == null) return;
        if (files == null) return;
        String saveDir = chosenDir.getPath();
        int numFile = Math.min(files.size(), maxFiles);
        for (int i = 0; i < numFile; i++) {
            File file = files.get(i);
            String fileName = removeExtension(file.getName());
            downloadNode.doDownload(file.getPath(), saveDir +  "/" + fileName + imageFormat);
        }
    }

    // add imageViews to imageViewManager
    void addImages() {
        imageViewManager.addImage(imageView0);
        imageViewManager.addImage(imageView1);
        imageViewManager.addImage(imageView2);
        imageViewManager.addImage(imageView3);
    }

    // add imageViews to imageViewManager
    void addLabels() {
        imageInfoManager.add(imageInfo0);
        imageInfoManager.add(imageInfo1);
        imageInfoManager.add(imageInfo2);
        imageInfoManager.add(imageInfo3);
    }

    // visualize selected images;
    private void visualizeImages() {
        int numFile = Math.min(files.size(), maxFiles);
        BufferedImage img = null;
        for (int i = 0; i < numFile; i++) {
            File file = files.get(i);
            try {
                img = ImageIO.read(file);
                if (img == null) {
                    System.out.println("The file " + file.getName() + " is not an image");
                    continue;
                }
                Image image = new Image(file.toURI().toString());
                if (image == null) {
                    System.out.println("The file " + file.getName() + " is not an image");
                }
                String text = "Height: " + image.getHeight() + "\nWidth: " + image.getWidth();
                javafx.scene.image.ImageView imageView = imageViewManager.get(i);
                if (imageView != null) {
                    imageView.setImage(image);
                    imageInfoManager.get(i).setText(text);
                }
            } catch (IOException e) {
                System.out.println("The file " + file.getName() + " can't be opened");
            }
        }
    }
    @FXML
    void multipleFileAction(ActionEvent event) {
        // select multiple files
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Multiple Image Files (max 4) Dialog");
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        List<File> curFiles = fileChooser.showOpenMultipleDialog(stage);
        if (curFiles == null) return;

        // reset current image visualization
        if (imageViewManager.size() == 0) {
            addImages();
            addLabels();
        }
        imageViewManager.reset();
        imageInfoManager.reset();
        files.clear();
        files =  new ArrayList<>(curFiles);;

        visualizeImages();
    }

}
