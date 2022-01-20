package com.ndrewcoding.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

    private final DadosPessoais dadosPessoais;
    private LocalDate dataDoUltimoReajuste;

    public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
    }

    public void atualizarSalario(BigDecimal novoSalario) {
        this.dadosPessoais.setSalario(novoSalario);
        this.dataDoUltimoReajuste = LocalDate.now();
    }

    public void promover(Cargo novoCargo) {
        this.dadosPessoais.setCargo(novoCargo);
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public LocalDate getDataDoUltimoReajuste() {
        return dataDoUltimoReajuste;
    }

    public void setDataDoUltimoReajuste(LocalDate dataDoUltimoReajuste) {
        this.dataDoUltimoReajuste = dataDoUltimoReajuste;
    }

}
