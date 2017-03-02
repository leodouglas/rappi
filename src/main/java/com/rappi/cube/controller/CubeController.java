package com.rappi.cube.controller;

import com.rappi.cube.exception.CubeNotCreatedException;
import com.rappi.cube.service.CubeService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/v1/cube")
public class CubeController {

    @Inject
    private CubeService service;

    @GetMapping
    public String create() throws CubeNotCreatedException {
        return service.getCube().toString();
    }
}
