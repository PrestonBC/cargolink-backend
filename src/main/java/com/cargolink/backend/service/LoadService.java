package com.cargolink.backend.service;
import com.cargolink.backend.dto.LoadRequest;
import com.cargolink.backend.entity.Load;
import com.cargolink.backend.repository.LoadRepository;
import com.cargolink.backend.repository.UserRepository;

import org.springframework.stereotype.Service;
import com.cargolink.backend.entity.User;
import java.util.List;
import java.util.UUID;

@Service

public class LoadService {
    private final LoadRepository loadRepository;
    private final UserRepository userRepository;

    public LoadService(LoadRepository loadRepository, UserRepository userRepository) {
        this.loadRepository = loadRepository;
        this.userRepository = userRepository;
    }

   public Load createLoad(LoadRequest request) {

    User user = userRepository.findById(request.postedById)
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.postedById));

    Load load = new Load();
    load.setTitle(request.title);
    load.setOrigin(request.origin);
    load.setDestination(request.destination);
    load.setCargoType(request.cargoType);
    load.setWeightTons(request.weightTons);
    load.setStatus("OPEN");
    load.setPostedBy(user);

    return loadRepository.save(load);
}

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Load getLoadById(UUID id) {
        return loadRepository.findById(id).orElse(null);
    }
}
