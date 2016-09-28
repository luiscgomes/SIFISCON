package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue
	private int id;	
	
	@Column(nullable = false, unique = true)
	private String CNPJ;
	
	@Column(nullable = false)
	private String razaoSocial;	
	
	private String inscricaoMunicipal;
	
	@Column(nullable = false)
	private BigDecimal receitaBruta;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
	private List<Processo> processos;
	
	public Fornecedor() {
		endereco = new Endereco();
		processos = new ArrayList<Processo>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String incricaoMunicipal) {
		this.inscricaoMunicipal = incricaoMunicipal;
	}
	public BigDecimal getReceitaBruta() {
		return receitaBruta;
	}
	public void setReceitaBruta(BigDecimal receitaBruta) {
		this.receitaBruta = receitaBruta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Processo> getProcessos() {
		return processos;
	}
	public void setProcesso(List<Processo> processo) {
		this.processos = processos;
	}	
	
}
