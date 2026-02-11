package core.io.library.system.util;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Multa {

    private static final double VALOR_POR_DIA = 2.5;
    private long diasAtraso;
    private double valorTotal;

    public Multa(LocalDate dataPrevistaDevolucao, LocalDate dataDevolucaoReal) {
        calcularMulta(dataPrevistaDevolucao, dataDevolucaoReal);
    }

    private void calcularMulta(LocalDate dataPrevista, LocalDate dataReal) {
        if(dataReal.isAfter(dataPrevista)){
            diasAtraso = ChronoUnit.DAYS.between(dataPrevista, dataReal);
            valorTotal = diasAtraso * VALOR_POR_DIA;
        } else {
            diasAtraso = 0;
            valorTotal = 0.0;
        }
    }

    public long getDiasAtraso() {
        return diasAtraso;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
