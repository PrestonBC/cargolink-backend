package com.cargolink.backend.service;
import com.cargolink.backend.entity.Bid;
import com.cargolink.backend.repository.BidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class BidService {
    private final BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Bid createBid(Bid bid) {
        bid.setStatus("PENDING");
        return bidRepository.save(bid);
    }

    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid getBidById(UUID id) {
        return bidRepository.findById(id).orElse(null);
    }
}
