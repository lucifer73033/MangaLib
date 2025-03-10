package com.MangaLib.MangaLib.Manga;

import com.MangaLib.MangaLib.Manga.POJOs.ChapterDTO;
import com.MangaLib.MangaLib.Manga.POJOs.MangaDTO;
import com.MangaLib.MangaLib.Manga.POJOs.SearchResultDTO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MangaController {
    private final MangaService mangaService;

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchResultTest(@RequestParam String title,@RequestParam int limit,@RequestParam int offset){
        Optional<SearchResultDTO> searchResult=mangaService.search(title,limit,offset);
        return searchResult.isPresent()?ResponseEntity.status(200).body(searchResult.get().getSearchResultMangaList().stream().map(s->s.toString()).collect(Collectors.toList())):ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
    @GetMapping("/manga/{id}")
    public ResponseEntity<?> getDetails(@PathVariable String id) {
        Optional mangaDTO=mangaService.getDetails(id);
        return mangaDTO.isPresent()?ResponseEntity.status(200).body(mangaDTO.get()):ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
    @GetMapping("manga/chapters/{id}")
    public ResponseEntity<?> getChapters(@PathVariable String id,@RequestParam int limit,@RequestParam int offset){
        Optional chaptersListDTO=mangaService.getChaptersList(id,limit,offset);
        return chaptersListDTO.isPresent()?ResponseEntity.status(200).body(chaptersListDTO.get()):ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<?> getPages(@PathVariable String id){
        Optional<ChapterDTO> pages=mangaService.getPages(id);
        return pages.isPresent()?ResponseEntity.status(200).body(pages.get().getPages()):ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
}
