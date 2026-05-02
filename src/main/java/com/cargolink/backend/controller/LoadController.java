package com.cargolink.backend.controller;
import com.cargolink.backend.dto.LoadRequest;
import com.cargolink.backend.entity.Load;
import com.cargolink.backend.service.LoadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loads")

public class LoadController {
     private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

   @PostMapping
public Load createLoad(@RequestBody LoadRequest request) {
    return loadService.createLoad(request);
}

    @GetMapping
    public List<Load> getAllLoads() {
        return loadService.getAllLoads();
    }

    @GetMapping("/{id}")
    public Load getLoad(@PathVariable UUID id) {
        return loadService.getLoadById(id);
    }
    
}
