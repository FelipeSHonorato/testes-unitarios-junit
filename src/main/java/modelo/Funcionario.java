package modelo;

import service.ReajusteService;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void reajusteDesempeho(BigDecimal x){
       this.salario = this.salario.add(x);
       arrendondarSalario();
    }
    private void arrendondarSalario(){
        this.salario.setScale(2, RoundingMode.HALF_UP);
    }
}
