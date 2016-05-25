package br.com.projetoppint.enums;

public enum TiposItens {
	Entrada(0), PratoPrincipal(1), Sobremesa(2);
	
	private int value;
	
	TiposItens(int value)
	{
		this.value = value;
	}
	
	public int value()
	{
		return value;
	}
}
