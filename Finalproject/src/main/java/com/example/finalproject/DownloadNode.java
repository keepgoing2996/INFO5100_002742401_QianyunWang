package com.example.finalproject;

/**
 * Singleton Node used to download image
 */
public class DownloadNode {
    // create singleton download node
    private static DownloadNode downloadNode = new DownloadNode();

    // private constructor
    private DownloadNode() {}

    // function to read inputFile, download and save as outputFile
    public void doDownload(String inputFile, String outputFile) {
        new javaxt.io.Image(inputFile).saveAs(outputFile);
    }
    // return the singleton DownloadNode
    public static DownloadNode getDownloadNode() {
        return downloadNode;
    }
}
