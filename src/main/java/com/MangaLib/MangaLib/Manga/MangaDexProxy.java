package com.MangaLib.MangaLib.Manga;

import com.MangaLib.MangaLib.Manga.POJOs.ChapterDTO;
import com.MangaLib.MangaLib.Manga.POJOs.ChaptersListDTO;
import com.MangaLib.MangaLib.Manga.POJOs.MangaDTO;
import com.MangaLib.MangaLib.Manga.POJOs.SearchResultDTO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="mangaDexproxy",url="${mangaDexURL}")
public interface MangaDexProxy{
    @GetMapping("/manga")
    public SearchResultDTO search(@RequestParam String title,@RequestParam Integer limit,@RequestParam Integer offset);
    @GetMapping("manga/{id}")
    public MangaDTO getDetails(@PathVariable String id);
    @GetMapping("manga/{id}/feed")
    public ChaptersListDTO getChaptersList(@PathVariable String id, @RequestParam("translatedLanguage[]") String language, @RequestParam("order[chapter]") String order, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "offset", required = false) Integer offset);
    @GetMapping("at-home/server/{id}")
    public ChapterDTO getPages(@PathVariable String id);
}
