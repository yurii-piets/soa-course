package com.soa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Id;

@Data
@NoArgsConstructor
public class Film {

    @Id
    private Long id;
}
