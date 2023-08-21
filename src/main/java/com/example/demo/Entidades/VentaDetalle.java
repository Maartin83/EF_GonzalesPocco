package com.example.demo.Entidades;

import com.example.demo.Entidades.Producto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VentaDetalle {

	private @Id @GeneratedValue Long id;

	private int cantidad;

	@ManyToOne()
	@JoinColumn(name = "id_producto")
	private Producto producto;

	public VentaDetalle() {
		
	}


	public VentaDetalle( int cantidad, Producto producto) {
		
		this.cantidad = cantidad;
		this.producto = producto;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}




	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


}