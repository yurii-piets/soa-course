package com.soa.zad2.data;

import lombok.Builder;
import lombok.Value;

@Value
public class FeedbackData {

    private String name;

    private String email;

    private String comment;

    @Builder
    public FeedbackData(String name, String email, String comment) {
        this.name = name;
        this.email = email;
        this.comment = comment;
    }
}
