package com.example.UrlShortner.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UrlShortner.entity.Url;
import com.example.UrlShortner.repository.UrlRepository;

@Service
public class UrlService {
	  @Autowired
	    private UrlRepository urlRepository;

	    public Url shortenUrl(String longUrl) {
	        String shortUrl = generateShortUrl();
	        Url url = new Url();
	        url.setLongUrl(longUrl);
	        url.setShortUrl(shortUrl);
	        url.setExpiryDate(LocalDateTime.now().plusMonths(10));
	        return urlRepository.save(url);
	    }

	    public Url updateShortUrl(String shortUrl, String newLongUrl) {
	        Url url = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new NoSuchElementException("Url not found"));
	        url.setLongUrl(newLongUrl);
	        return urlRepository.save(url);
	    }

	    public String getLongUrl(String shortUrl) {
	        Url url = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new NoSuchElementException("Url not found"));
	        return url.getLongUrl();
	    }

	    public Url updateExpiry(String shortUrl, long daysToAdd) {
	        Url url = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new NoSuchElementException("Url not found"));
	        url.setExpiryDate(url.getExpiryDate().plusDays(daysToAdd));
	        return urlRepository.save(url);
	    }

	    private String generateShortUrl() {
	       
	        return RandomStringUtils.randomAlphanumeric(10);
	    }
}
