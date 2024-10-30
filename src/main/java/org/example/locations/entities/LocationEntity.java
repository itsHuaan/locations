package org.example.locations.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationEntity {
    private int locationId;
    private String name;
    private int parentId;
    private String coords;
}
