package com.rappi.cube.controller;

import com.rappi.cube.controller.response.QueryResponse;
import com.rappi.cube.domain.Cube;
import com.rappi.cube.exception.CubeNotCreatedException;
import com.rappi.cube.service.CubeService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/v1/cube")
public class CubeController {

    @Inject
    private CubeService service;

    @PostMapping
    public Cube create(@RequestParam(value="size") int size) throws CubeNotCreatedException {
        service.create(size);
        return service.getCube();
    }

    @PutMapping
    public Cube update(@RequestParam(value="x") int x,
                       @RequestParam(value="y") int y,
                       @RequestParam(value="z") int z,
                       @RequestParam(value="value") int value) throws CubeNotCreatedException {
        service.update(x, y, z, value);
        return service.getCube();
    }

    @GetMapping
    public QueryResponse query(@RequestParam(value="x1") int x1,
                      @RequestParam(value="y1") int y1,
                      @RequestParam(value="z1") int z1,
                      @RequestParam(value="x2") int x2,
                      @RequestParam(value="y2") int y2,
                      @RequestParam(value="z2") int z2) throws CubeNotCreatedException {
        return new QueryResponse(service.query(x1, y1, z1, x2, y2, z2));
    }
}
