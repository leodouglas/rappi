package com.rappi.cube.domain;

import java.math.BigInteger;

/**
 * Created by leo on 02/03/17.
 */
public class Cube {

    private int[][][] content;

    public Cube(int size) {
        content = new int[size][size][size];
    }

    public void update(int x, int y, int z, int value) {
        content[--x][--y][--z] = value;
    }

    @Override
    public String toString() {
        if (content == null) {
            return "Cube wasn't created";
        }
        return String.format("Size X:%s, Y:%s, Z:%s", content.length, content.length, content.length);
    }

    public BigInteger sum(int x1, int y1, int z1, int x2, int y2, int z2) {
        BigInteger sum = BigInteger.ZERO;
        x1--;
        y1--;
        z1--;

        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                for (int z = z1; z < z2; z++) {

                    int[][] xl = content[x];
                    int[] yl = xl[y];
                    int value = yl[z];
                    sum = sum.add(BigInteger.valueOf(value));
                }
            }
        }
        return sum;
    }

    public String getSize(){
        return toString();
    }
}
