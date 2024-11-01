package org.example.locations.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityDto {
    private int locationId;
    private String name;
    private String coords;
    private String region;
}
