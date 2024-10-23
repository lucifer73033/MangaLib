package com.MangaLib.MangaLib;

import com.MangaLib.MangaLib.Manga.POJOs.SearchResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestingController {
    @GetMapping("/SearchResultTest")
    public List<String> searchResultTest(@RequestBody SearchResult searchResult){
        return searchResult.getData().stream().map(SearchResult.SearchResultManga::toString).collect(Collectors.toList());

    }

}
