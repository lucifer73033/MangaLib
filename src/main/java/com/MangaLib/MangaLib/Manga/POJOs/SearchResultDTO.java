package com.MangaLib.MangaLib.Manga.POJOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.jar.Attributes;

public class SearchResultDTO {
    @JsonProperty("data")
    private final  List<SearchResultManga> searchResultMangaList;
    private final  Integer total;
    public static class SearchResultManga{
        private final  String id;

        private final  Attributes attributes;
        private final  List<Relationship> relationships;
        public static class Attributes{
            private final  Title title;
            public static class Title{
                @JsonProperty(value="en",required = false)
                private final  String name;
                @JsonCreator
                public Title(String name) {
                    this.name = name;
                }

                public String getName() {
                    return name;
                }
            }
            @JsonCreator
            public Attributes(Title title) {
                this.title = title;
            }
            public Title getTitle() {
                return title;
            }
        }
        public static class Relationship{
            private final  String id;
            private final  String type;
            @JsonCreator
            public Relationship(String id, String type) {
                this.id = id;
                this.type = type;
            }
            public String getId() {
                return id;
            }
        }
        @JsonCreator
        public SearchResultManga(String id, Attributes attributes, List<Relationship> relationships) {
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
        @Override
        public String toString(){
            return id+" "+attributes.title.name +" "+relationships.stream().filter(s->s.type.equals("cover_art")).map(s->s.id).collect(Collectors.toList());
        }
    }
    @JsonCreator
    public SearchResultDTO(List<SearchResultManga> searchResultMangaList, Integer total) {
        this.searchResultMangaList = searchResultMangaList;
        this.total = total;
    }
    public List<SearchResultManga> getSearchResultMangaList() {
        return searchResultMangaList;
    }

    public Integer getTotal() {
        return total;
    }
}
