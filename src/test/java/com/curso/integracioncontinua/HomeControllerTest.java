package com.curso.integracioncontinua;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HomeControllerTest {
	

	@Test
	public void testHome() {
		HomeController controller= new HomeController();
		assertNotNull(controller.home());
	}

	@Test
	public void testCalcular() {
		HomeController homeController= new HomeController();
		Comisiones comisiones= new Comisiones();
		comisiones.setTipoSeleccionado(HomeController.VENDEDOR);
		comisiones.setVentasMes(1250);
		comisiones.setHorasExtras(5);
		assertNotNull(comisiones);
	}

}
