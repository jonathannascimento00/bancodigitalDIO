package br.com.dioBank;

public abstract class Conta implements IBank{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected Cliente titular;
	protected int agencia;
	protected int conta;
	protected double saldo = 0d;
	
	public Conta(Cliente titular) {
		this.agencia = AGENCIA_PADRAO;
		this.conta = SEQUENCIAL++;
		this.titular = titular;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		if(valor<=saldo) {
			saldo -= valor;
		}
		else {
			imprimirSaldoInsuficiente();
		}
		
	}

	@Override
	public void depositar(double valor) {
		if(valor>0) {
			saldo += valor;
		}
		else {
			System.out.println("Para depositar você deve inserir um valor válido!");
		}
		
	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		if(this.conta == contaDestino.conta) {
			System.out.println("Não é possível fazer transferência para a mesma conta!");
		}
		else {
			if(valor<=saldo) {
				System.out.println("chegou aqui");
				this.sacar(valor);
				contaDestino.depositar(valor);
			}
			else {
				imprimirSaldoInsuficiente();
			}
		}
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("*** Extrato ***");
		System.out.println(String.format("Titular: %s", this.titular.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número da Conta: %d", this.conta));
		System.out.println(String.format("Seu saldo é de: R$ %.2f", this.saldo));
	}
	
	@Override
	public void imprimirSaldoInsuficiente() {
		System.out.println("Seu saldo é insuficiente para realizar essa operação!");
	}

}
