package com.cargolink.backend.dto;

import java.util.UUID;

public class LoadRequest {

    public String title;
    public String origin;
    public String destination;
    public String cargoType;
    public Double weightTons;

    public UUID postedById;
}
