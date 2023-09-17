package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.dao.R_RegistroInventarioDao;
import frgp.utn.edu.ar.entidad.R_RegistroInventario;

public class R_RegistroInventarioNegocio {
	
	private R_RegistroInventarioDao r_registroinventarioDao;
	
	
	public R_RegistroInventarioDao getR_RegistroInventarioDao() {
		return r_registroinventarioDao;
	}


	public void setR_RegistroInventarioDao(R_RegistroInventarioDao r_registroinventarioDao) {
		this.r_registroinventarioDao = r_registroinventarioDao;
	}


	public boolean agregarR_RegistroInventario(R_RegistroInventario r_registroinventario)
	{
		r_registroinventarioDao = new R_RegistroInventarioDao();
		r_registroinventarioDao.agregarR_RegistroInventarioDao(r_registroinventario);
		return true;
	}
	
	public List<R_RegistroInventario> readAll() {
		return r_registroinventarioDao.readAll();
	}
	
	public List<R_RegistroInventario> readAllUser(String user) {
		return r_registroinventarioDao.readAllUser(user);
	}

	public boolean Delete(Integer id)
	{
		r_registroinventarioDao = new R_RegistroInventarioDao();
		r_registroinventarioDao.Delete(id);
		return true;
	}
}
