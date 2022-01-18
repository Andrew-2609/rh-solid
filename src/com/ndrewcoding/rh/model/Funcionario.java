package com.ndrewcoding.rh.model;

import com.ndrewcoding.rh.ValidacaoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

    private String nome;
    private String cpf;
    private Cargo cargo;
    private BigDecimal salario;
    private LocalDate dataDoUltimoReajuste;

    public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void reajustarSalario(BigDecimal aumento) {
        BigDecimal percentualDeReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
        if (percentualDeReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste não pode ser superior à 40%");
        }

        this.salario = this.salario.add(aumento);
        this.dataDoUltimoReajuste = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataDoUltimoReajuste() {
        return dataDoUltimoReajuste;
    }

    public void setDataDoUltimoReajuste(LocalDate dataDoUltimoReajuste) {
        this.dataDoUltimoReajuste = dataDoUltimoReajuste;
    }

}
