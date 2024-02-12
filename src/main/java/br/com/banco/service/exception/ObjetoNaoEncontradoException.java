package br.com.banco.service.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{
    public ObjetoNaoEncontradoException(String msg){
        super(msg);
    }
}
