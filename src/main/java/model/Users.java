package model;

import java.util.Date;

public class Users {

	private Integer id;
	private String name;
	private String email;
	private String celular;
	
	public Users() {
	}
	
	public Users(Integer id, String name, String email, String celular, Date dataCadastro) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.celular = celular;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", celular=" + celular + "]";
	}
}
