package com.acumedicalinc.web.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Entity
@Table(name = "users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    boolean enabled;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        this.password = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
    }

    @Transient
    public String getPasswordConfirm() {
        return new String(Base64.getDecoder().decode(passwordConfirm));
    }

    public void setPasswordConfirm(String passwordConfirm) throws Exception {
        this.passwordConfirm = Base64.getEncoder().encodeToString(passwordConfirm.getBytes("UTF-8"));
    }

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
