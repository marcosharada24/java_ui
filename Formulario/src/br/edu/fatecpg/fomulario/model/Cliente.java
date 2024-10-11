package br.edu.fatecpg.fomulario.model;

public class Cliente {
private String nome;
private int  idade;
private String sexo;

public Cliente(String nome, int idade, String sexo) {
	this.nome = nome;
	this.idade = idade;
	this.sexo = sexo;
}
@Override
public String toString() {
	return "nome: " + nome + ", idade: " + idade + ", sexo: " + sexo;
}
}
