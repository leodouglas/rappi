package com.rappi.cube.service;

import com.rappi.cube.domain.Cube;
import com.rappi.cube.exception.CubeNotCreatedException;

import java.math.BigInteger;

/**
 * Created by leo on 01/03/17.
 */
public interface CubeService {

    boolean create(int size);

    void update(int x, int y, int z, int value);

    Cube getCube() throws CubeNotCreatedException;

    BigInteger query(int x1, int y1, int z1, int x2, int y2, int z2);
}
