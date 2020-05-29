package com.curso.integracioncontinua;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	int a;
	
	public static final String VENDEDOR="Vendedor";
	public static  final String ENCARGADO="Encargado"; 
	public static final  String HOME="home";
	public static final  int IMPORTE_VENTAS_MES_TRAMO_1=1000;
	public static  final int IMPORTE_VENTAS_MES_TRAMO_2=1500;
	public static final  int SALARIO=1500;
	public static  final int SALARIO1=2000;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		//TODO sfdgfdd
		Comisiones comisiones= new Comisiones();
		
		comisiones.setTiposVendedor(new HashMap<String, String>());
		comisiones.getTiposVendedor().put(HomeController.VENDEDOR,HomeController.VENDEDOR);
		comisiones.getTiposVendedor().put(HomeController.ENCARGADO,HomeController.ENCARGADO);
		comisiones.setVentasMes(0);
		comisiones.setHorasExtras(0);
		
		ModelAndView modelAndView= new ModelAndView(HomeController.HOME);
		modelAndView.addObject("comisiones", comisiones);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "calcular", method = RequestMethod.POST)
	public ModelAndView calcular(Comisiones comisiones) {
		
		int salario=HomeController.SALARIO;
		if(comisiones.getTipoSeleccionado().equals(HomeController.ENCARGADO))
			salario=HomeController.SALARIO1;
		if(comisiones.getVentasMes()>=HomeController.IMPORTE_VENTAS_MES_TRAMO_1)
			salario+=100;
		if(comisiones.getVentasMes()>=HomeController.IMPORTE_VENTAS_MES_TRAMO_2)
			salario+=100;
		
		
		salario+=comisiones.getHorasExtras()*20;
		
		
		ModelAndView modelAndView=home();
		modelAndView.addObject("criterios", comisiones);
		modelAndView.addObject("salario", salario);
		return modelAndView;
	}
	
}
