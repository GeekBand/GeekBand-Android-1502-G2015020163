package com.geekband.snap.moran.model;


public class ImageItem {
    private int imageId;
    private String imageLink;

    public ImageItem(int imageId,String comment){
        this.imageId = imageId;
        this.imageLink = imageLink;

    }
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getComment() {
        return imageLink;
    }

    public void setComment(String comment) {
        this.imageLink = imageLink;
    }
}
