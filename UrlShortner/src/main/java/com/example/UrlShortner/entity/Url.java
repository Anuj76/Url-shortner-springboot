package com.example.UrlShortner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Url {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String longUrl;
	    private String shortUrl;
	    private LocalDateTime expiryDate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getLongUrl() {
			return longUrl;
		}
		public void setLongUrl(String longUrl) {
			this.longUrl = longUrl;
		}
		public String getShortUrl() {
			return shortUrl;
		}
		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
		public LocalDateTime getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(LocalDateTime expiryDate) {
			this.expiryDate = expiryDate;
		}
	    
	    
}
