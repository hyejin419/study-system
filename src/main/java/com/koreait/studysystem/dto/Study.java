package com.koreait.studysystem.dto;

import lombok.Data;

@Data
public class Study {
    private Long id;
    private String title;
    private String description;
    private Long creatorId;
}
