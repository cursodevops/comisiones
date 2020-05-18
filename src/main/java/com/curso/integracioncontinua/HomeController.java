package com.curso.integracioncontinua;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	public static String VENDEDOR="Vendedor";
	public static String ENCARGADO="Encargado";
	public static String HOME="home";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
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
		
		int salario=1000;
		if(comisiones.getTipoSeleccionado().equals(HomeController.ENCARGADO))
			salario=1500;
		if(comisiones.getVentasMes()>=1000)
			salario+=100;
		if(comisiones.getVentasMes()>=1500)
			salario+=100;
		
		
		salario+=comisiones.getHorasExtras()*20;
		
		
		ModelAndView modelAndView=home();
		modelAndView.addObject("criterios", comisiones);
		modelAndView.addObject("salario", salario);
		return modelAndView;
	}
	
}
