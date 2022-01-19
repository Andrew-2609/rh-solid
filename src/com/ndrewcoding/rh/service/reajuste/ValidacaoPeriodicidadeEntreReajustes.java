package com.ndrewcoding.rh.service.reajuste;

import com.ndrewcoding.rh.ValidacaoException;
import com.ndrewcoding.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataDoUltimoReajuste = funcionario.getDataDoUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesteOUltimoReajuste = ChronoUnit.MONTHS.between(dataDoUltimoReajuste, dataAtual);
        if (mesesDesteOUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes salariais não podem ser menores que 6 meses!");
        }
    }

}
