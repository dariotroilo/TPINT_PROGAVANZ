package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.dao.UserubicacionDao;
import frgp.utn.edu.ar.entidad.Userubicacion;

public class UserubicacionNegocio {
	
	private UserubicacionDao userubicacionDao;
	
	
	public UserubicacionDao getUserubicacionDao() {
		return userubicacionDao;
	}


	public void setUserubicacionDao(UserubicacionDao userubicacionDao) {
		this.userubicacionDao = userubicacionDao;
	}

	public List<Userubicacion> readAll() {
		return userubicacionDao.readAll();
	}
	
}
