package org.banta.citronix.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TreeDTO {
    private Long id;
    private LocalDate datePlanted;
}
