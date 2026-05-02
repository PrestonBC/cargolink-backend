package com.cargolink.backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "loads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Load {
     @Id
    @GeneratedValue
    private UUID loadId;

    private String title;

    private String origin;

    private String destination;

    private String cargoType;

    private Double weightTons;

    private String status;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private User postedBy;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck assignedTruck;


    public void setTitle(String title) { this.title = title; }
public void setOrigin(String origin) { this.origin = origin; }
public void setDestination(String destination) { this.destination = destination; }
public void setCargoType(String cargoType) { this.cargoType = cargoType; }
public void setWeightTons(Double weightTons) { this.weightTons = weightTons; }
public void setStatus(String status) { this.status = status; }
public void setPostedBy(User user) { this.postedBy = user; }
    
}
