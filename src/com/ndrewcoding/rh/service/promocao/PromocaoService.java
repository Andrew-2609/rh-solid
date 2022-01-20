package com.ndrewcoding.rh.service.promocao;

import com.ndrewcoding.rh.ValidacaoException;
import com.ndrewcoding.rh.model.Cargo;
import com.ndrewcoding.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaAtingida) {
        Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }

        if (!metaAtingida) {
            throw new ValidacaoException("Funcionário não bateu a meta!");
        }

        Cargo novoCargo = cargoAtual.getProximoCargo();
        funcionario.promover(novoCargo);
    }

}
