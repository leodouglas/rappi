package com.rappi.cube.exception;

/**
 * Created by leo on 01/03/17.
 */
public abstract class CubeException extends Throwable {

    public abstract String message();

    @Override
    public String toString() {
        return message();
    }
}
