package com.rappi.cube.exception;

/**
 * Created by leo on 01/03/17.
 */
public class CubeNotCreatedException extends CubeException {

    @Override
    public String message() {
        return "The cube wasn't created";
    }
}
