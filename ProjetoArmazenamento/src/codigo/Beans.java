package codigo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

public class Beans {

	String usuario;
	int senha;
	String novouser;
	int novasenha;
	String userbanc;
	int senhabanc;
	String ID;
	String cargo;
	private byte [] imagem;
	int codgoferramenta;
	String nomeferramenta;
	String caminhodaimagem;
	File sourceimage;
	int quantidadeferramentas_lista;
	int idferramenta_lista;
	String nomeferramenta_lista;
	String descricaoferramenta_lista;
	String marcaferramenta_lista;
	String garantiaferramenta_lista;
	int valorferramenta_lista;
	
	
	
	
	
	
	public int getQuantidadeferramentas_lista() {
		return quantidadeferramentas_lista;
	}
	public void setQuantidadeferramentas_lista(int quantidadeferramentas_lista) {
		this.quantidadeferramentas_lista = quantidadeferramentas_lista;
	}
	public int getIdferramenta_lista() {
		return idferramenta_lista;
	}
	public void setIdferramenta_lista(int idferramenta_lista) {
		this.idferramenta_lista = idferramenta_lista;
	}
	public String getNomeferramenta_lista() {
		return nomeferramenta_lista;
	}
	public void setNomeferramenta_lista(String nomeferramenta_lista) {
		this.nomeferramenta_lista = nomeferramenta_lista;
	}
	public String getDescricaoferramenta_lista() {
		return descricaoferramenta_lista;
	}
	public void setDescricaoferramenta_lista(String descricaoferramenta_lista) {
		this.descricaoferramenta_lista = descricaoferramenta_lista;
	}
	public String getMarcaferramenta_lista() {
		return marcaferramenta_lista;
	}
	public void setMarcaferramenta_lista(String marcaferramenta_lista) {
		this.marcaferramenta_lista = marcaferramenta_lista;
	}
	public String getGarantiaferramenta_lista() {
		return garantiaferramenta_lista;
	}
	public void setGarantiaferramenta_lista(String garantiaferramenta_lista) {
		this.garantiaferramenta_lista = garantiaferramenta_lista;
	}
	public int getValorferramenta_lista() {
		return valorferramenta_lista;
	}
	public void setValorferramenta_lista(int valorferramenta_lista) {
		this.valorferramenta_lista = valorferramenta_lista;
	}
	public File getSourceimage() {
		return sourceimage;
	}
	public void setSourceimage(File sourceimage) {
		this.sourceimage = sourceimage;
	}
	public String getCaminhodaimagem() {
		return caminhodaimagem;
	}
	public void setCaminhodaimagem(String caminhodaimagem) {
		this.caminhodaimagem = caminhodaimagem;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public int getCodgoferramenta() {
		return codgoferramenta;
	}
	public void setCodgoferramenta(int codgoferramenta) {
		this.codgoferramenta = codgoferramenta;
	}
	public String getNomeferramenta() {
		return nomeferramenta;
	}
	public void setNomeferramenta(String nomeferramenta) {
		this.nomeferramenta = nomeferramenta;
	}


	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUserbanc() {
		return userbanc;
	}
	public void setUserbanc(String userbanc) {
		this.userbanc = userbanc;
	}
	public int getSenhabanc() {
		return senhabanc;
	}
	public void setSenhabanc(int senhabanc) {
		this.senhabanc = senhabanc;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getNovouser() {
		return novouser;
	}
	public void setNovouser(String novouser) {
		this.novouser = novouser;
	}
	public int getNovasenha() {
		return novasenha;
	}
	public void setNovasenha(int novasenha) {
		this.novasenha = novasenha;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}


		
}
