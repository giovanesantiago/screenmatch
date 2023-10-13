package br.com.alura.screenmatch.exception;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private final String mensagem;
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
