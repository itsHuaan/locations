package org.example.locations.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDto {
    private int locationId;
    private String name;
    private int parentId;
    private String coords;
}
