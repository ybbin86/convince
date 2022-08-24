package com.festa.hack.kurly.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class TagDto {

    private String name;
    private LocalDate start_date;
    private LocalDate end_date;

}
