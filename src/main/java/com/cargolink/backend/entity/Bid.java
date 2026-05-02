package com.cargolink.backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "bids")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Bid {
     @Id
    @GeneratedValue
    private UUID bidId;

    private BigDecimal proposedPrice;

    private String status;

    @ManyToOne
    @JoinColumn(name = "load_id")
    private Load load;

    @ManyToOne
    @JoinColumn(name = "submitted_by")
    private User submittedBy;

    public void setStatus(String status) { this.status = status; }
    
}
