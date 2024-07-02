package com.example.UrlShortner.controller;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.UrlShortner.entity.Url;
import com.example.UrlShortner.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/url")
public class UrlController {
	 @Autowired
	    private UrlService urlService;

	    @PostMapping("/shorten")
	    public ResponseEntity<String> shortenUrl(@RequestBody String longUrl) {
	        Url url = urlService.shortenUrl(longUrl);
	        return ResponseEntity.ok("http://localhost:8080/" + url.getShortUrl());
	    }

	    @PostMapping("/update")
	    public ResponseEntity<Boolean> updateShortUrl(@RequestBody Map<String, String> request) {
	        urlService.updateShortUrl(request.get("shortUrl"), request.get("longUrl"));
	        return ResponseEntity.ok(true);
	    }

	    @GetMapping("/{shortUrl}")
	    public void redirectToFullUrl(HttpServletResponse response, @PathVariable String shortUrl) {
	        try {
	            String longUrl = urlService.getLongUrl(shortUrl);
	            response.sendRedirect(longUrl);
	        } catch (NoSuchElementException e) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url not found", e);
	        } catch (IOException e) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not redirect to the full url", e);
	        }
	    }

	    @PostMapping("/updateExpiry")
	    public ResponseEntity<Boolean> updateExpiry(@RequestBody Map<String, Object> request) {
	        String shortUrl = (String) request.get("shortUrl");
	        Integer daysToAdd = (Integer) request.get("daysToAdd");
	        urlService.updateExpiry(shortUrl, daysToAdd);
	        return ResponseEntity.ok(true);
	    }
}
