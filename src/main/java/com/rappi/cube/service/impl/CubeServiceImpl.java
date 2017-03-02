package com.rappi.cube.service.impl;

import com.rappi.cube.domain.Cube;
import com.rappi.cube.exception.CubeNotCreatedException;
import com.rappi.cube.service.CubeService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by leo on 01/03/17.
 */
@Service
public class CubeServiceImpl implements CubeService {

    private Cube cube;

    @Override
    public boolean create(int size) {
        cube = new Cube(size);
        return true;
    }

    @Override
    public void update(int x, int y, int z, int value){
        cube.update(x, y, z, value);
    }

    @Override
    public Cube getCube() throws CubeNotCreatedException {
        if (cube == null) {
            throw new CubeNotCreatedException();
        }
        return cube;
    }

    @Override
    public BigInteger query(int x1, int y1, int z1, int x2, int y2, int z2) {
        return cube.sum(x1, y1, z1, x2, y2, z2);
    }
}
