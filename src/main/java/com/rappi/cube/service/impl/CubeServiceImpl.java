package com.rappi.cube.service.impl;

import com.rappi.cube.exception.CubeNotCreatedException;
import com.rappi.cube.service.CubeService;
import org.springframework.stereotype.Service;

/**
 * Created by leo on 01/03/17.
 */
@Service
public class CubeServiceImpl implements CubeService {

    private int[][][] cube;

    @Override
    public boolean create(int size) {
        cube = new int[size][size][size];
        return true;
    }

    @Override
    public void update(int x, int y, int z, int value){
        cube[x][y][z] = value;
    }

    @Override
    public int[][][] getCube() throws CubeNotCreatedException {
        if (cube == null) {
            throw new CubeNotCreatedException();
        }
        return cube;
    }
}
