package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class WebRequest extends PanacheEntity {

    /** The timestamp when the request was recorded. */
    public LocalDateTime requestTimestamp;

    /** The User-Agent string of the browser that made the request. */
    public String userAgent;

    /**
     * Default constructor for JPA.
     */
    public WebRequest() {
    }

    /**
     * Convenience constructor to create a new WebRequest.
     * @param userAgent The User-Agent header from the incoming request.
     */
    public WebRequest(String userAgent) {
        this.userAgent = userAgent;
        this.requestTimestamp = LocalDateTime.now();
    }
}
