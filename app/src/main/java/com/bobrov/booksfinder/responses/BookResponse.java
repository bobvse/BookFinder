package com.bobrov.booksfinder.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookResponse implements Serializable {
    private  String kind;
    private  String id;
    private  String etag;
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public static class VolumeInfo implements Serializable {
        private String title;
        private String[] authors;
        private String publisher;
        private String description;

        public String getTitle() {
            return title;
        }

        public String[] getAuthors() {
            return authors;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getDescription() {
            return description;
        }
    }
}
