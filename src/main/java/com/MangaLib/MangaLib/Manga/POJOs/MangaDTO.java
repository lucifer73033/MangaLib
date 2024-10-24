package com.MangaLib.MangaLib.Manga.POJOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MangaDTO {
    private Data data;
    public static class Data{
        private String id;
        private Attributes attributes;
        private List<Relationship> relationships;
        public static class Attributes{
            private Title title;
            private Description description;
            public static class Title{
                String en;

                public Title(String en) {
                    this.en = en;
                }

                public Title() {
                }

                public String getEn() {
                    return en;
                }

                public void setEn(String en) {
                    this.en = en;
                }
            }
            public static class Description{
                @JsonProperty("en")
                private String en;

                public Description(String en) {
                    this.en = en;
                }

                public Description() {
                }

                public String getEn() {
                    return en;
                }

                public void setEn(String en) {
                    this.en = en;
                }
            }

            public Attributes(Title title, Description description) {
                this.title = title;
                this.description = description;
            }

            public Attributes() {
            }

            public Title getTitle() {
                return title;
            }

            public void setTitle(Title title) {
                this.title = title;
            }

            public Description getDescription() {
                return description;
            }

            public void setDescription(Description description) {
                this.description = description;
            }
        }
        public static class Relationship{
            private String id;
            private String type;

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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public Data(String id, Attributes attributes, List<Relationship> relationships) {
            this.id = id;
            this.attributes = attributes;
            this.relationships = relationships;
        }

        public Data() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public List<Relationship> getRelationships() {
            return relationships;
        }

        public void setRelationships(List<Relationship> relationships) {
            this.relationships = relationships;
        }
    }

    public MangaDTO(Data data) {
        this.data = data;
    }

    public MangaDTO() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return data.id+"\n"+data.getAttributes().title.getEn()+"\n"+data.getAttributes().description.getEn()+"\n"
                +data.getRelationships().stream().filter(s->s.type.equals("author")||s.type.equals("artist")||s.type.equals("cover_art")).map(s->s.id+" "+s.type).toList();
    }
}
