package org.banta.citronix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Field area is required")
    @Min(value = 1000, message = "Field area must be at least 0.1 hectare (1000 m²)")
    private Double area; //

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Farm is required")
    private Farm farm;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Tree> trees = new ArrayList<>();
}