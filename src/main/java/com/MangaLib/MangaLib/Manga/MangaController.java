package com.MangaLib.MangaLib.Manga;

import com.MangaLib.MangaLib.Manga.POJOs.MangaDTO;
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
    public List<String> searchResultTest(@RequestParam String title,@RequestParam int limit,@RequestParam int offset){
        return mangaService.search(title,limit,offset).getSearchResultMangaList().stream().map(s->s.toString()).collect(Collectors.toList());
    }
    @GetMapping("/manga/{id}")
    public ResponseEntity<?> getDetails(@PathVariable String id) {
        Optional mangaDTO=mangaService.getDetails(id);
        return mangaDTO.isPresent()?ResponseEntity.status(200).body(mangaDTO.get()):ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
}
