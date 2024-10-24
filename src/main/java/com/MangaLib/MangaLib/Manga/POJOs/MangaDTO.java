package com.MangaLib.MangaLib.Manga.POJOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MangaDTO {
    private final Data data;
    public static class Data{
        private final String id;
        private final Attributes attributes;
        private final List<Relationship> relationships;
        public static class Attributes{
            private final Title title;
            private final Description description;
            public static class Title{
                @JsonProperty("en")@JsonInclude(JsonInclude.Include.NON_EMPTY)
                String name;
                @JsonCreator
                public Title(String name) {
                    this.name = name;
                }
                public String getName() {
                    return name;
                }
            }
            public static class Description{
                @JsonProperty("en")@JsonInclude(JsonInclude.Include.NON_EMPTY)
                private final String description;
                @JsonCreator
                public Description(String description) {
                    this.description = description;
                }


                public String getDescription() {
                    return description;
                }

            }
            @JsonCreator
            public Attributes(Title title, Description description) {
                this.title = title;
                this.description = description;
            }


            public Title getTitle() {
                return title;
            }
            public Description getDescription() {
                return description;
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

    }
    @JsonCreator
    public MangaDTO(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }
    @Override
    public String toString(){
        return data.id+"\n"+data.getAttributes().title.getName()+"\n"+data.getAttributes().description.getDescription()+"\n"
                +data.getRelationships().stream().filter(s->s.type.equals("author")||s.type.equals("artist")||s.type.equals("cover_art")).map(s->s.id+" "+s.type).toList();
    }
}
