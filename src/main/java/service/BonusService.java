package service;

import modelo.Funcionario;

import java.math.BigDecimal;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario){
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000"))>0){
            throw new IllegalArgumentException(("Lança uma mensagem de erro"));
        }
        return valor;
    }
}
