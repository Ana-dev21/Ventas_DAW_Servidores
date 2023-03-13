package com.edix.ventas.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the comerciales database table.
 * 
 */
@Entity
@Table(name="comerciales")
@NamedQuery(name="Comercial.findAll", query="SELECT c FROM Comercial c")
public class Comercial implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comercial")
	private int idComercial;

	private String apellido1;

	private String apellido2;

	private Double comision;

	private String nombre;

	//bi-directional many-to-one association to Pedido
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy="comercial")
	private List<Pedido> pedidos;

	public Comercial() {
	}

	public int getIdComercial() {
		return this.idComercial;
	}

	public void setIdComercial(int idComercial) {
		this.idComercial = idComercial;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Double getComision() {
		return this.comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setComercial(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setComercial(null);

		return pedido;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Comercial comercial = (Comercial) o;
		return idComercial == comercial.idComercial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idComercial);
	}

	@Override
	public String toString() {
		return "Comercial{" +
				"idComercial=" + idComercial +
				", apellido1='" + apellido1 + '\'' +
				", apellido2='" + apellido2 + '\'' +
				", comision=" + comision +
				", nombre='" + nombre + '\'' +
				'}';
	}
}