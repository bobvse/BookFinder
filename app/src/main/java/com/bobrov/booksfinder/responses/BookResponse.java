package com.bobrov.booksfinder.responses;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookResponse implements Serializable {
    @SerializedName("kind")
    private String kind;
    @SerializedName("id")
    private String id;
    @SerializedName("etag")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookResponse that = (BookResponse) o;
        return Objects.equal(kind, that.kind) &&
                Objects.equal(id, that.id) &&
                Objects.equal(etag, that.etag) &&
                Objects.equal(volumeInfo, that.volumeInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(kind, id, etag, volumeInfo);
    }

    public static class VolumeInfo implements Serializable {
        @SerializedName("title")
        private String title;
        @SerializedName("authors")
        private String[] authors;
        @SerializedName("publisher")
        private String publisher;
        @SerializedName("description")
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VolumeInfo that = (VolumeInfo) o;
            return Objects.equal(title, that.title) &&
                    Objects.equal(authors, that.authors) &&
                    Objects.equal(publisher, that.publisher) &&
                    Objects.equal(description, that.description) &&
                    Objects.equal(imageLinks, that.imageLinks);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(title, authors, publisher, description, imageLinks);
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

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ImageLinks that = (ImageLinks) o;
                return Objects.equal(smallThumbnail, that.smallThumbnail) &&
                        Objects.equal(thumbnail, that.thumbnail) &&
                        Objects.equal(small, that.small) &&
                        Objects.equal(medium, that.medium) &&
                        Objects.equal(large, that.large) &&
                        Objects.equal(extraLarge, that.extraLarge);
            }

            @Override
            public int hashCode() {
                return Objects.hashCode(smallThumbnail, thumbnail, small, medium, large, extraLarge);
            }
        }

    }


}
