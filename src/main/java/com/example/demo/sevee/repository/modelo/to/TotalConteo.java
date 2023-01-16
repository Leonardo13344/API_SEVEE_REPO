package com.example.demo.sevee.repository.modelo.to;

import java.math.BigInteger;

public class TotalConteo {
    private BigInteger total;
    private Integer numero;

    public TotalConteo() {
    }

    public TotalConteo(BigInteger total, Integer numero) {
        this.total = total;
        this.numero = numero;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
