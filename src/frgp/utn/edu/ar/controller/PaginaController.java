package frgp.utn.edu.ar.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dao.UserubicacionDao;
import frgp.utn.edu.ar.entidad.R_RegistroInventario;
import frgp.utn.edu.ar.entidad.Userubicacion;
import frgp.utn.edu.ar.negocio.R_RegistroInventarioNegocio;
import frgp.utn.edu.ar.negocio.SB1010Negocio;
import frgp.utn.edu.ar.negocio.SBE010Negocio;
import frgp.utn.edu.ar.negocio.UserubicacionNegocio;
import frgp.utn.edu.ar.negocio.ZCB010Negocio;

@Controller
public class PaginaController {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	@RequestMapping("redireccionar_pagPantallaUbicacion.html")
	public ModelAndView eventoPantallaUbicacion() {
		ModelAndView MV = new ModelAndView();
		UserubicacionNegocio userubicacionNegocio = (UserubicacionNegocio) appContext.getBean("UserubicacionNegocio");
		MV.addObject("listaUserubicacion", userubicacionNegocio.readAll());
		MV.setViewName("PantallaUbicacion");
		return MV;
	}

//	@RequestMapping("redireccionar_pagPantallaClientes.html")
//	public ModelAndView eventoPantallaCliente() {
		// aca hay que obtener que deacuerdo al usuario logueado me muestre o el usuario
		// vendedor o el usuario contador
//		ModelAndView MV = new ModelAndView();
//		MV.setViewName("PantallaClientes");
//		return MV;
//	}
	
	@RequestMapping("redireccionar_pagArticulosListar.html")
	public ModelAndView eventoR_RegistroInventarioListar()
	{
		ModelAndView MV = new ModelAndView();
		R_RegistroInventarioNegocio R_RegistroInventarioNegocio = (R_RegistroInventarioNegocio) appContext.getBean("R_RegistroInventarioNegocio");
		MV.addObject("listaR_RegistroInventario", R_RegistroInventarioNegocio.readAll());
		MV.setViewName("R_RegistroInventarioListar");
		return MV;
	}
	
	@RequestMapping("redireccionar_pagArticulosAgregar.html")
	public ModelAndView eventoArticulosAgregar()
	{
		ModelAndView MV = new ModelAndView();
		R_RegistroInventarioNegocio r_registroinventarioNegocio = (R_RegistroInventarioNegocio) appContext.getBean("R_RegistroInventarioNegocio");
		//MV.addObject("listaR_RegistroInventario", r_registroinventarioNegocio.readAll());
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    String usuario = userDetail.getUsername();
		MV.addObject("listaR_RegistroInventario", r_registroinventarioNegocio.readAllUser(usuario));
		MV.setViewName("R_RegistroInventarioAgregar");
		return MV;
	}

	@RequestMapping("redireccionar_pag1.html")
	public ModelAndView eventoRedireccionarPag1() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("R_RegistroInventarioAgregar");
		return MV;
	}

	
	@RequestMapping("redireccionar_pagModificar.html")
	 public ModelAndView eventoRedireccionarModificar(
	            @RequestParam String id,
	            @RequestParam String usuario,
	            @RequestParam String filial,
	            @RequestParam String localiz,
	            @RequestParam(value = "IdArticuloModificar", required = false) String idArticuloModificar) {
	    ModelAndView MV = new ModelAndView();



	    if (idArticuloModificar != null) {
	    	System.out.println("llega el id " + id + " - " + usuario + " - " + filial + " - " + localiz );
	        Userubicacion userubicacion = new Userubicacion();
	        userubicacion.setId(Long.parseLong(id));
	        userubicacion.setUsuario(usuario);
	        userubicacion.setFilial(filial);
	        userubicacion.setLocalizacion(localiz); 

	        UserubicacionDao userubiDAO = new UserubicacionDao();
	        userubiDAO.Update(userubicacion);
	        
			UserubicacionNegocio userubicacionNegocio = (UserubicacionNegocio) appContext.getBean("UserubicacionNegocio");
			MV.addObject("listaUserubicacion", userubicacionNegocio.readAll());
			MV.setViewName("PantallaUbicacion");

	    }

	    else { 
	    	
	    MV.addObject("id", id);
	    MV.addObject("usuario", usuario);
	    MV.addObject("filial", filial);
	    MV.addObject("localiz", localiz); 
	    	    
	    SBE010Negocio sbe010Negocio = (SBE010Negocio) appContext.getBean("SBE010Negocio");
	    MV.addObject("listaSBE010", sbe010Negocio.readAll());
	    MV.setViewName("Modificar");
	    }
	    
	    return MV;
	}
	
	@RequestMapping("logout.html")
	public ModelAndView logout() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("logout");
		return MV;
	}

	
	@RequestMapping("redireccionar_pagArticulosAccion.html")
	public ModelAndView eventoArticulosAccion(
			  @RequestParam String codigo,
			  @RequestParam(required = false) String descri,
			  @RequestParam(required = false) Integer cantidad,
			  @RequestParam(name = "btnBuscar", required = false) String btnBuscar,
		      @RequestParam(name = "btnGuardarCantidad", required = false) String btnGuardarCantidad,
		      @RequestParam(name = "IdArticuloEliminar", required = false) Integer IdArticuloEliminar 
			  ) {
		ModelAndView MV = new ModelAndView();
		// Recupero nombre de usuario
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    String usuario = userDetail.getUsername();
		codigo=codigo.trim();
	    if (btnBuscar != null) {
	    	SB1010Negocio SB1010Negocio = (SB1010Negocio) appContext.getBean("SB1010Negocio");
	    	if ( codigo.length() > 7 ) {
	    		ZCB010Negocio ZCB010Negocio = (ZCB010Negocio) appContext.getBean("ZCB010Negocio");
	    		codigo=ZCB010Negocio.readWithCod(codigo);
	    	}
	    	if ( codigo != null ) { 
	    		MV.addObject("SB1010Negocio", SB1010Negocio.readWithCod(codigo));
	    	}
	    } else if (btnGuardarCantidad != null) {
	    	R_RegistroInventarioNegocio registro = (R_RegistroInventarioNegocio) appContext.getBean("R_RegistroInventarioNegocio");
			R_RegistroInventario r_registroinventario = (R_RegistroInventario) appContext.getBean("R_RegistroInventario");;
			// Seteo la fecha del guardado
			LocalDate fechaActual = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			String fecha = fechaActual.format(formatter);

		    //Recupero Filial y Ubicacion
		    Userubicacion userubicacion = (Userubicacion) appContext.getBean("UserUbicaciones");
		    UserubicacionDao userubicacionDao = (UserubicacionDao) appContext.getBean("UserubicacionDao");
		    userubicacion = userubicacionDao.Getuser(usuario);
		    String filial = userubicacion.getFilial();
		    String ubicacion = userubicacion.getLocalizacion();
			
			r_registroinventario.setCodigo(codigo);
			r_registroinventario.setDescripcion(descri);
			r_registroinventario.setCantidad(cantidad);
			r_registroinventario.setFilial(filial);
			r_registroinventario.setUbicacion(ubicacion);
			r_registroinventario.setUsuario(usuario);
			r_registroinventario.setFecha(fecha);
			if (codigo != "" && descri != "" && cantidad > 0 && cantidad != null) {
				registro.agregarR_RegistroInventario(r_registroinventario);
			}
			MV.addObject("usuario","");
			MV.addObject("cantidad",0);
			MV.addObject("descri","");
		}
	    
	    if (IdArticuloEliminar != null) {
	    	R_RegistroInventarioNegocio eliminaregistro = (R_RegistroInventarioNegocio) appContext.getBean("R_RegistroInventarioNegocio");
	    	eliminaregistro.Delete(IdArticuloEliminar);
	    }
	    	

		R_RegistroInventarioNegocio R_RegistroInventarioNegocio = (R_RegistroInventarioNegocio) appContext.getBean("R_RegistroInventarioNegocio");
		MV.addObject("listaR_RegistroInventario", R_RegistroInventarioNegocio.readAllUser(usuario));
		
		MV.setViewName("R_RegistroInventarioAgregar");
		return MV;
	}
}
