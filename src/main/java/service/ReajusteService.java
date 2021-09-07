package service;

import modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho){
        BigDecimal aumentoReajuste = funcionario.getSalario().multiply(desempenho.percentualReajuste());
        funcionario.reajusteDesempeho((aumentoReajuste));
    }
}
