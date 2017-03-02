package com.rappi.cube.controller.response;

import java.math.BigInteger;

/**
 * Created by leo on 02/03/17.
 */
public class QueryResponse {

    private BigInteger sum;

    public QueryResponse(BigInteger sum) {
        this.sum = sum;
    }

    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }
}
