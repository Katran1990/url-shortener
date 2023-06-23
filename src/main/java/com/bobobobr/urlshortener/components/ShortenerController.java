package com.bobobobr.urlshortener.components;

import com.bobobobr.urlshortener.dto.UrlWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ShortenerController {

    private final ShortUrlService shortUrlService;

    @PostMapping(value = "/shorten")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<UrlWrapper> shortenUrl(@RequestBody UrlWrapper urlWrapper) {
        return ResponseEntity.ok(new UrlWrapper(shortUrlService.shortenUrl(urlWrapper.url())));
    }

    @GetMapping(value = "/{key}")
    public void redirection(@PathVariable("key") String key, HttpServletResponse response) throws IOException {
        response.sendRedirect(shortUrlService.findUrlByKey(key));
    }
}
