package com.edix.ventas.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comerciales database table.
 * 
 */
@Entity
@Table(name="comerciales")
@NamedQuery(name="Comercial.findAll", query="SELECT c FROM Comercial c")
public class Comercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comercial")
	private int idComercial;

	private String apellido1;

	private String apellido2;

	private double comision;

	private String nombre;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="comerciale")
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

	public double getComision() {
		return this.comision;
	}

	public void setComision(double comision) {
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
		pedido.setComerciale(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setComerciale(null);

		return pedido;
	}

}