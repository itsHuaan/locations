package org.example.locations.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrecipitationEntity {
    private int precipitationId;
    private int locationId;
    private int year;
    private int month;
    private double precipitationAmount;
}
