package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.model.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo f){
        tempoTotal += f.getDuracaoEmMinutos();
    }
}
