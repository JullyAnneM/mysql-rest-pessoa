package helloworld;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.Type;

@Entity
public class Pessoa {
	
	@Id
	@Column(nullable = false, name = "RG")
	@Min(value = 100000000, message="Numero de RG invalido")
	@Type(type="int")
	private int rg;
	
	@Column(nullable = false, name = "Nome")
	@Size(min=1, max=20)
	private String nome;
	
	public Pessoa () {
		
	}
	
	public Pessoa(int rg, String nome) {
		super();
		this.rg = rg;
		this.nome = nome;
	}
	
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String junto = rg + ", " + nome;
		return junto;
	}
	
}
