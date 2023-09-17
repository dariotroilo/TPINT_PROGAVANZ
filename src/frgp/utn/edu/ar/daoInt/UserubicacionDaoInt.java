package frgp.utn.edu.ar.daoInt;
import java.util.List;

import frgp.utn.edu.ar.entidad.Userubicacion;

public interface UserubicacionDaoInt {

	public List<Userubicacion> readAll();
	public Userubicacion Get(Long id);
	public Userubicacion Getuser(String nombre);
	public void Update(Userubicacion userubicacion);
}
