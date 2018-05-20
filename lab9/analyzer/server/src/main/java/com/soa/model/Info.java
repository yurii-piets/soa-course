package com.soa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Info {

    private Integer charAmount;

    private Integer spaceAmount;

    private Integer capitalAmount;

    private Integer lowerAmount;

    private Integer numberAmount;
}