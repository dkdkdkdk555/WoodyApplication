package com.example.woodyapplication.net;

public class Image {
    private int kind;
    private String originalFileName;
    private String storedFilePath;

    public Image(int kind, String originalFileName, String storedFilePath) {
        this.kind = kind;
        this.originalFileName = originalFileName;
        this.storedFilePath = storedFilePath;
    }

    @Override
    public String toString() {
        return "Image{" +
                "kind=" + kind +
                ", originalFileName='" + originalFileName + '\'' +
                ", storedFilePath='" + storedFilePath + '\'' +
                '}';
    }
}
