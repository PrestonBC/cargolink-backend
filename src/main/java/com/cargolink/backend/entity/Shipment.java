package com.cargolink.backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Shipment {
    
    @Id
    @GeneratedValue
    private UUID shipmentId;

    private String status;

    private String proofOfDelivery;

    @OneToOne
    @JoinColumn(name = "load_id")
    private Load load;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;
    
}
