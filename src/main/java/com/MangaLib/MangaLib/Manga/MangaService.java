package com.MangaLib.MangaLib.Manga;

import com.MangaLib.MangaLib.Manga.POJOs.MangaDTO;
import com.MangaLib.MangaLib.Manga.POJOs.SearchResultDTO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class MangaService {
    private final MangaDexProxy mangaDexProxy;

    public MangaService(MangaDexProxy mangaDexProxy) {
        this.mangaDexProxy = mangaDexProxy;
    }
    public SearchResultDTO search(@RequestParam String title, @RequestParam Integer limit, @RequestParam Integer offset){
        return mangaDexProxy.search(title,limit,offset);
    }
    @RateLimiter(name="manga",fallbackMethod = "mangaFallback")
    public Optional<MangaDTO> getDetails(@PathVariable String id){
        return Optional.of(mangaDexProxy.getDetails(id));
    }
    private Optional<MangaDTO> mangaFallback(String id,Throwable e){
        return Optional.empty();
    }

}
