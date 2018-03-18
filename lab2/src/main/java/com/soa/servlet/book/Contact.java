package com.soa.servlet.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String email;
    private String name;
    private String comment;
}
