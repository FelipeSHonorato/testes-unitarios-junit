package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PublicKey;
import java.time.LocalDate;

public class Funcionario {

    private String nome;
    private LocalDate dataAdminssao;
    private BigDecimal salario;

    public Funcionario(String nome, LocalDate dataAdminssao, BigDecimal salario) {
        this.nome = nome;
        this.dataAdminssao = dataAdminssao;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataAdminssao() {
        return dataAdminssao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void reajusteDesempeho(BigDecimal x){
        ReajusteService reajuste = new ReajusteService();
        this.salario = this.salario.add(x).setScale(2, RoundingMode.HALF_UP);
    }
}
