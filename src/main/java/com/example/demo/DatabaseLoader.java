package com.example.demo;

import com.example.demo.Entidades.Producto;
import com.example.demo.Entidades.VentaDetalle;
import com.example.demo.Repositorios.ProductoRepository;
import com.example.demo.Repositorios.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository repositoryP;
	
	private final VentaDetalleRepository repositoryDV;

	@Autowired
	public DatabaseLoader(
		ProductoRepository repositoryP,
		 VentaDetalleRepository repositoryDV) {
		this.repositoryP = repositoryP;
		this.repositoryDV = repositoryDV;
	}

	@Override
	public void run(String... strings) throws Exception {
		//insertar productos
		this.repositoryP.save(new Producto("Coca Cola", 1.5));
		this.repositoryP.save(new Producto("Pepsi", 1.5));
		this.repositoryP.save(new Producto("Fanta", 1.5));
		this.repositoryP.save(new Producto("Sprite", 1.5));
		this.repositoryP.save(new Producto("Coca Cola Zero", 1.5));
		this.repositoryP.save(new Producto("Pepsi Light", 1.5));
		this.repositoryP.save(new Producto("Fanta Light", 1.5));
		this.repositoryP.save(new Producto("Sprite Light", 1.5));

		//insertar ventas
		this.repositoryDV.save(new VentaDetalle(2,repositoryP.findById(1L).get()));
		this.repositoryDV.save(new VentaDetalle(2,repositoryP.findById(2L).get()));
		this.repositoryDV.save(new VentaDetalle(3,repositoryP.findById(3L).get()));
		this.repositoryDV.save(new VentaDetalle(5,repositoryP.findById(4L).get()));
		this.repositoryDV.save(new VentaDetalle(5,repositoryP.findById(5L).get()));
		this.repositoryDV.save(new VentaDetalle(5,repositoryP.findById(6L).get()));
		this.repositoryDV.save(new VentaDetalle(7,repositoryP.findById(7L).get()));
	}

	
}