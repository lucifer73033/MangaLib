package com.MangaLib.MangaLib.Manga;

import com.MangaLib.MangaLib.Manga.POJOs.ChapterDTO;
import com.MangaLib.MangaLib.Manga.POJOs.ChaptersListDTO;
import com.MangaLib.MangaLib.Manga.POJOs.MangaDTO;
import com.MangaLib.MangaLib.Manga.POJOs.SearchResultDTO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "searchResultDTO" , key = "#title + #limit + #offset")
    @RateLimiter(name="def",fallbackMethod = "searchFallback")
    public Optional<SearchResultDTO> search(@RequestParam String title, @RequestParam Integer limit, @RequestParam Integer offset){
        System.out.println("R-U-N-N-I-N-G  S-E-A-R-C-H  S-E-R-V-I-C-E  M-E-T-H-O-D");
        return Optional.of(mangaDexProxy.search(title,limit,offset));
    }
    @RateLimiter(name="def",fallbackMethod = "mangaFallback")
    public Optional<MangaDTO> getDetails(@PathVariable String id){
        return Optional.of(mangaDexProxy.getDetails(id));
    }

    @RateLimiter(name="def",fallbackMethod = "chapterFallback")
    public Optional<ChaptersListDTO> getChaptersList(String id,int limit,int offset){
        return Optional.of(mangaDexProxy.getChaptersList(id,"en","asc",limit,offset));
    }

    @RateLimiter(name="atHome",fallbackMethod = "pageFallback")
    public Optional<ChapterDTO> getPages(String id){
        return Optional.of(mangaDexProxy.getPages(id));
    }

    private Optional<MangaDTO> mangaFallback(String id,Throwable e){
        return Optional.empty();
    }
    private Optional<SearchResultDTO> searchFallback(String title,Integer limit,Integer offset,Throwable e){
        System.out.println("Fallback encountered");
        return Optional.empty();
    }
    private Optional<ChaptersListDTO> chapterFallback(String id,int limit,int offset,Throwable e){
        return Optional.empty();
    }
    private Optional<ChapterDTO> pageFallback(String id,Throwable e){
        return Optional.empty();
    }

}
