package com.ndrewcoding.rh.service;

import com.ndrewcoding.rh.ValidacaoException;
import com.ndrewcoding.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualDeReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualDeReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste não pode ser superior à 40%");
        }

        BigDecimal novoSalario = salarioAtual.add(aumento);
        funcionario.atualizarSalario(novoSalario);
    }

}
