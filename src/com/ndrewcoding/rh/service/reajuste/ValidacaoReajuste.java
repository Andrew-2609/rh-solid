package com.ndrewcoding.rh.service.reajuste;

import com.ndrewcoding.rh.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal aumento);

}
