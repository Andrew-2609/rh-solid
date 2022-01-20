package com.ndrewcoding.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements Reajuste {

    private final BigDecimal valor;
    private final LocalDate data;

    public Promocao(BigDecimal valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public LocalDate data() {
        return data;
    }

}
