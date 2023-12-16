package Exceptions;

public class BalanceInsufficientException extends Exception{
    public BalanceInsufficientException() {
        super("Insufficient balance.. Please recharge to sign up for more activities.");
    }
}
