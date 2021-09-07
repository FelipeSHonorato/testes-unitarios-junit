package service;

import modelo.Funcionario;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BonusServiceTest {

    private Funcionario funcionario;
    private BonusService bonusService;
    private BigDecimal bonus;

    @BeforeAll
    public void iniciarTestes() {
        System.out.println("Iniciando testes unitários");
    }

    @AfterAll
    public void finalizarTestes() {
        System.out.println("Finalizando testes unitários");
    }

    @Before
    public void inicializar() {
        this.funcionario = new Funcionario("Felipe", LocalDate.now(), new BigDecimal("1000"));
        this.bonusService = new BonusService();
        System.out.println("Inicializando");
    }


    @Test

    /** Verificando se o método está lançando uma exception **/

    public void calcularBonusSalarioAcimaPermitido() {
        funcionario.setSalario(new BigDecimal("25000"));
        bonus = bonusService.calcularBonus(funcionario);
        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(funcionario));
    }

    @Test
    public void calcularBonusSalarioAbaixoPermitido() {
        funcionario.setSalario(new BigDecimal("2500"));
        bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void calcularBonusSalarioIgualPermitido() {
        funcionario.setSalario(new BigDecimal("10000"));
        bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("1000.0"), bonus);
    }


}
