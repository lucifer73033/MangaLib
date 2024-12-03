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
    @RateLimiter(name="def",fallbackMethod = "searchFallback")
    @Cacheable(value = "searchResultDTO" , key = "#title + #limit + #offset")
    public Optional<SearchResultDTO> search(@RequestParam String title, @RequestParam Integer limit, @RequestParam Integer offset){
        return Optional.of(mangaDexProxy.search(title,limit,offset));
    }
    @RateLimiter(name="def",fallbackMethod = "mangaFallback")
    @Cacheable(value = "mangaDTO" , key = "#id")
    public Optional<MangaDTO> getDetails(@PathVariable String id){
        return Optional.of(mangaDexProxy.getDetails(id));
    }

    @RateLimiter(name="def",fallbackMethod = "chapterFallback")
    @Cacheable(value = "chaptersListDTO" , key = "#id + #limit + #offset")
    public Optional<ChaptersListDTO> getChaptersList(String id,int limit,int offset){
        return Optional.of(mangaDexProxy.getChaptersList(id,"en","asc",limit,offset));
    }

    @RateLimiter(name="atHome",fallbackMethod = "pageFallback")
    @Cacheable(value = "chapterDTO" , key = "#id")
    public Optional<ChapterDTO> getPages(String id){
        return Optional.of(mangaDexProxy.getPages(id));
    }

    private Optional<MangaDTO> mangaFallback(String id,Throwable e){
        return Optional.empty();
    }
    private Optional<SearchResultDTO> searchFallback(String title,Integer limit,Integer offset,Throwable e){return Optional.empty();
    }
    private Optional<ChaptersListDTO> chapterFallback(String id,int limit,int offset,Throwable e){
        return Optional.empty();
    }
    private Optional<ChapterDTO> pageFallback(String id,Throwable e){
        return Optional.empty();
    }

}
