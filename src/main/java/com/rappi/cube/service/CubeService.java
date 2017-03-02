package com.rappi.cube.service;

import com.rappi.cube.exception.CubeNotCreatedException;

/**
 * Created by leo on 01/03/17.
 */
public interface CubeService {

    boolean create(int size);

    void update(int x, int y, int z, int value);

    int[][][] getCube() throws CubeNotCreatedException;

}
