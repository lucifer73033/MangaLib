package com.MangaLib.MangaLib.Manga.POJOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterDTO {
    @JsonProperty(value = "baseUrl")
    private final String baseURL;
    private final Chapter chapter;

    @JsonCreator
    public ChapterDTO(String baseURL, Chapter chapter) {
        this.baseURL = baseURL;
        this.chapter = chapter;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public List<String> getPages(){
        return chapter.getPages().stream().map(x->String.format("%s/data-saver/%s/%s",baseURL,chapter.getHash(),x)).collect(Collectors.toList());
    }

    public static class Chapter{
        private final String hash;
        @JsonProperty(value = "dataSaver")
        private final List<String> pages;

        public Chapter(String hash, List<String> pages) {
            this.hash = hash;
            this.pages = pages;
        }

        public String getHash() {
            return hash;
        }

        public List<String> getPages() {
            return pages;
        }
    }
}
