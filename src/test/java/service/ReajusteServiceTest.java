package service;

import modelo.Funcionario;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    public void inicializar(){
        service = new ReajusteService();
        funcionario = new Funcionario("Felipe", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteTresPorcentoDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
    }

    @Test
    public void reajusteQuinzePorcentoDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.BOM);
    }

    @Test
    public void reajusteVintePorcentoDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
    }


}
