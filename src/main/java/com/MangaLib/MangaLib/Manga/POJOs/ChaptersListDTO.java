package com.MangaLib.MangaLib.Manga.POJOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChaptersListDTO {
    @JsonProperty(value = "data")
    private final List<Data> chapters;
    private final Integer limit;
    private final Integer offset;
    private final Integer total;
    @JsonCreator
    public ChaptersListDTO(List<Data> chapters, Integer limit, Integer offset, Integer total) {
        this.chapters = chapters;
        this.limit = limit;
        this.offset = offset;
        this.total = total;
    }

    public List<Data> getChapters() {
        return chapters;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getTotal() {
        return total;
    }
    public static class Data{
        private final String id;
        private final Attributes attributes;
        private final List<Relationship> relationships;
        @JsonCreator
        public Data(String id, Attributes attributes, List<Relationship> relationships) {
            this.id = id;
            this.attributes = attributes;
            this.relationships = relationships;
        }

        public String getId() {
            return id;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public List<Relationship> getRelationships() {
            return relationships;
        }

        public static class Attributes{
            private final String volume;
            private final String chapter;
            private final String title;
            @JsonCreator
            public Attributes(String volume, String chapter, String title) {
                this.volume = volume;
                this.chapter = chapter;
                this.title = title;
            }

            public String getVolume() {
                return volume;
            }

            public String getChapter() {
                return chapter;
            }

            public String getTitle() {
                return title;
            }
        }

        public static class Relationship{
            private final String id;
            private final String type;
            @JsonCreator
            public Relationship(String id, String type) {
                this.id = id;
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public String getType() {
                return type;
            }
        }
    }
}
