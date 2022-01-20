package com.ndrewcoding.rh.service.reajuste;

import com.ndrewcoding.rh.ValidacaoException;
import com.ndrewcoding.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getDadosPessoais().getSalario();
        BigDecimal percentualDeReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualDeReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste salarial não pode ser superior à 40%!");
        }
    }

}
