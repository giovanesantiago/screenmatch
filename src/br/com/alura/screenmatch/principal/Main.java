package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.model.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Filme meufilme = new Filme("O Poderoso chefão", 1970);
        meufilme.setDuracaoEmMinutos(180);
        System.out.println("Duração meuFIlme " + meufilme.getDuracaoEmMinutos());

        meufilme.exibeFichaTecnica();
        meufilme.avalia(8);
        meufilme.avalia(5);
        meufilme.avalia(10);

        System.out.println(meufilme.getTotalDeAvaliacao());
        System.out.println(meufilme.obterMedia());


        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração da Serie : " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2023);

        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meufilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meufilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisulizacoes(300);
        filtro.filtra(episodio);

        Filme filmeDoPaulo = new Filme("DogVille", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meufilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho de lista : " + listaDeFilmes.size());
        System.out.println("Primeiro filme : " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);

    }
}