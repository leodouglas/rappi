package com.rappi.cube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cube")
public class CubeController {

    @GetMapping
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {
        return "hello";
    }
}
