package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{

    private String nome;

    private int anoDeLacamento;
    private boolean incluiNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLacamento) {
        this.nome = nome;
        this.anoDeLacamento = anoDeLacamento;
    }

    public Titulo(TituloDTO tituloDTO) {
        this.nome = tituloDTO.title();

        if(tituloDTO.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano para int");
        }

        this.anoDeLacamento = Integer.valueOf(tituloDTO.year());
        this.anoDeLacamento = Integer.valueOf(tituloDTO.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloDTO.runtime().substring(0, 2));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLacamento() {
        return anoDeLacamento;
    }

    public boolean isIncluiNoPlano() {
        return incluiNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setAnoDeLacamento(int anoDeLacamento) {
        this.anoDeLacamento = anoDeLacamento;
    }

    public void setIncluiNoPlano(boolean incluiNoPlano) {
        this.incluiNoPlano = incluiNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacao() {
        return totalDeAvaliacao;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do br.com.alura.screenmatch.model.Filme :" + this.nome);
        System.out.println("Ano de lançamento :" + this.anoDeLacamento);
    }


    public void avalia(double nota){
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacao++;
    }

    public double obterMedia() {
        return somaDasAvaliacoes / totalDeAvaliacao;
    }

    @Override
    public String toString() {
        var tipo = "";
        if(this instanceof Filme){
            tipo = "Filme";
        }else if (this instanceof Serie){
            tipo = "Serie";
        }else {
            tipo = "Titulo";
        }
        return tipo +": " + this.getNome() +
                " (" + this.getAnoDeLacamento() + ")" +
                " (" + this.getDuracaoEmMinutos() + "min)";
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}
