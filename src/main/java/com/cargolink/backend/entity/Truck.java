package com.cargolink.backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "trucks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Truck {
     @Id
    @GeneratedValue
    private UUID truckId;

    private String plateNumber;

    private Double capacityTons;

    private String type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
