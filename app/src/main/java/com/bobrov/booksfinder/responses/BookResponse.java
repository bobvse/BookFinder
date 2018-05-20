package com.bobrov.booksfinder.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookResponse implements Serializable {
    private String kind;
    private String id;
    private String etag;
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
        @SerializedName("imageLinks")
        private ImageLinks imageLinks;

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

        public ImageLinks getImageLinks() {
            return imageLinks;
        }

        public static class ImageLinks implements Serializable {
            private String smallThumbnail;
            private String thumbnail;
            private String small;
            private String medium;
            private String large;
            private String extraLarge;

            public String getSmallThumbnail() {
                return smallThumbnail;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public String getSmall() {
                return small;
            }

            public String getMedium() {
                return medium;
            }

            public String getLarge() {
                return large;
            }

            public String getExtraLarge() {
                return extraLarge;
            }
        }

    }


}
