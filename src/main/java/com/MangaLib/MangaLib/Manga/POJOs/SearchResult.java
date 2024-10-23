package com.MangaLib.MangaLib.Manga.POJOs;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.jar.Attributes;

public class SearchResult {
    private  List<SearchResultManga> data;
    private  Integer total;
    public static class SearchResultManga{
        private  String id;
        private  Attributes attributes;
        private  List<Relationship> relationships;
        public static class Attributes{
            private  Title title;
            public static class Title{
                private  String en;

                public Title(String en) {
                    this.en = en;
                }

                public String getEn() {
                    return en;
                }

                public Title() {
                }

                public void setEn(String en) {
                    this.en = en;
                }
            }

            public Attributes(Title title) {
                this.title = title;
            }

            public Attributes() {
            }

            public Title getTitle() {
                return title;
            }

            public void setTitle(Title title) {
                this.title = title;
            }
        }
        public static class Relationship{
            private  String id;
            private  String type;

            public Relationship(String id, String type) {
                this.id = id;
                this.type = type;
            }

            public Relationship() {
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public SearchResultManga(String id, Attributes attributes, List<Relationship> relationships) {
            this.id = id;
            this.attributes = attributes;
            this.relationships = relationships;
        }

        public SearchResultManga() {
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
            return attributes.title.en+" "+relationships.stream().filter(s->s.type.equals("cover_art")).map(s->s.id).collect(Collectors.toList());
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public void setRelationships(List<Relationship> relationships) {
            this.relationships = relationships;
        }
    }

    public SearchResult(List<SearchResultManga> data, Integer total) {
        this.data = data;
        this.total = total;
    }
    public SearchResult() {
    }
    public List<SearchResultManga> getData() {
        return data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setData(List<SearchResultManga> data) {
        this.data = data;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
