package br.com.bank.exceptions;

@SuppressWarnings("serial")
public class CommitException extends Exception {

    public CommitException(){
        super("Erro ao commitar!");
    }

}
