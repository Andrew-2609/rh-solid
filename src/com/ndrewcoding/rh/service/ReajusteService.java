package com.ndrewcoding.rh.service;

import com.ndrewcoding.rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private final List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));
        BigDecimal novoSalario = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(novoSalario);
    }

}
