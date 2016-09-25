package modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Processo {	
	@Id
	private String numeroProcesso;
	
	@Column(nullable = false)
	private StringBuilder relatoFiscalizacao;
	
	@Column(nullable = false)
	private Date dataRelato;
	
	@Column(nullable = false)
	private String fiscalResponsavel;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	public Processo(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		this.numeroProcesso = gerarNumeroProcesso();
	}
	
	public String getNumeroProcesso() {
		return this.numeroProcesso;
	}
	
	public String gerarNumeroProcesso() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int ano = cal.get(Calendar.YEAR);
		int mes = cal.get(Calendar.MONTH);
		int dia = cal.get(Calendar.DATE);
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		int minuto = cal.get(Calendar.MINUTE);
		int segundo = cal.get(Calendar.SECOND);
		
		return ano + mes + dia + hora + minuto + segundo + fornecedor.getCNPJ();
	}
	
	public StringBuilder getRelatoFiscalizacao() {
		return relatoFiscalizacao;
	}
	
	public void setRelatoFiscalizacao(StringBuilder relatoFiscalizacao) {
		this.relatoFiscalizacao = relatoFiscalizacao;
	}
	
	public Date getDataRelato() {
		return dataRelato;
	}
	
	public void setDataRelato(Date dataRelato) {
		this.dataRelato = dataRelato;
	}
	
	public String getFiscalResponsavel() {
		return fiscalResponsavel;
	}
	
	public void setFiscalResponsavel(String fiscalResponsavel) {
		this.fiscalResponsavel = fiscalResponsavel;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
