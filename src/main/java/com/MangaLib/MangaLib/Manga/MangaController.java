package com.MangaLib.MangaLib.Manga;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MangaController {
    private final MangaDexProxy mangaDexProxy;

    public MangaController(MangaDexProxy mangaDexProxy) {
        this.mangaDexProxy = mangaDexProxy;
    }
    @GetMapping("/search")
    public List<String> searchResultTest(@RequestParam String title,@RequestParam int limit,@RequestParam int offset){
        return mangaDexProxy.search(title,limit,offset).getSearchResultMangaList().stream().map(s->s.toString()).collect(Collectors.toList());
    }
    @GetMapping("/manga/{id}")
    public String getDetails(@PathVariable String id){
        return mangaDexProxy.getDetails(id).toString();
    }
}
