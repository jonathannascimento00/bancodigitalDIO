package br.com.dioBank;

public interface IBank {
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(Conta contaDestino, double valor);
	
	void imprimirExtrato();
	
	void imprimirSaldoInsuficiente();
}
