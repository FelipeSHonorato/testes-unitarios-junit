package service;

import modelo.Funcionario;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BonusServiceTest {

    private Funcionario funcionario;
    private BonusService bonusService;
    private BigDecimal bonus;

    @Before
    public void inicializar() {
        funcionario = new Funcionario("Felipe", LocalDate.now(), new BigDecimal("1000"));
        bonusService = new BonusService();
    }


    @Test

    /** Verificando se o método está lançando uma exception **/

    public void calcularBonusSalarioAcimaPermitido() {
        inicializar();
        funcionario.setSalario(new BigDecimal ("25000"));
        bonus = bonusService.calcularBonus(funcionario);
        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(funcionario));
    }

    @Test
    public void calcularBonusSalarioAbaixoPermitido() {
        inicializar();
        funcionario.setSalario(new BigDecimal ("2500"));
        bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void calcularBonusSalarioIgualPermitido() {
        inicializar();
        funcionario.setSalario(new BigDecimal ("10000"));
        bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("1000.0"), bonus);
    }


}
