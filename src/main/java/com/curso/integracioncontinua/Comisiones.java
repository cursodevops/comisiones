package com.curso.integracioncontinua;

import java.util.Map;

public class Comisiones {

	
	private Map<String,String> tiposVendedor;
	private String tipoSeleccionado;
	private int ventasMes;
	private int horasExtras;
	
	
	
	public int getVentasMes() {
		return ventasMes;
	}
	public void setVentasMes(int ventasMes) {
		this.ventasMes = ventasMes;
	}
	public int getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}
	public String getTipoSeleccionado() {
		return tipoSeleccionado;
	}
	public void setTipoSeleccionado(String tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}
	public Map<String,String> getTiposVendedor() {
		return tiposVendedor;
	}
	public void setTiposVendedor(Map<String,String> tiposVendedor) {
		this.tiposVendedor = tiposVendedor;
	}
}
