package br.com.dioBank;

public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		cliente1.setNome("Jonathan");
		cliente2.setNome("Gerisvaldo");
		
		Conta cc = new ContaCorrente(cliente1);
		Conta poupanca = new ContaPoupanca(cliente2);
		
		cc.depositar(100);
		poupanca.depositar(15);
		
		cc.transferir(poupanca, 50);
		poupanca.transferir(cc, 100);
		
		cc.transferir(cc, 50);
		
		cc.sacar(150);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		
	}

}
