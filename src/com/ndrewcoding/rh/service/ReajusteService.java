package com.ndrewcoding.rh.service;

import com.ndrewcoding.rh.ValidacaoException;
import com.ndrewcoding.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReajusteService {

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualDeReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualDeReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste salarial não pode ser superior à 40%!");
        }

        LocalDate dataDoUltimoReajuste = funcionario.getDataDoUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesteOUltimoReajuste = ChronoUnit.MONTHS.between(dataDoUltimoReajuste, dataAtual);
        if (mesesDesteOUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes salariais não podem ser menores que 6 meses!");
        }

        BigDecimal novoSalario = salarioAtual.add(aumento);
        funcionario.atualizarSalario(novoSalario);
    }

}
