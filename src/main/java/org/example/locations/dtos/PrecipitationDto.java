package org.example.locations.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrecipitationDto {
    private int precipitationId;
    private int locationId;
    private int year;
    private int month;
    private double precipitationAmount;
}
