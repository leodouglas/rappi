package com.rappi.cube.exception;

/**
 * Created by leo on 01/03/17.
 */
public abstract class CubeException extends Exception {

    public abstract String getMessage();

    @Override
    public String toString() {
        return getMessage();
    }
}
