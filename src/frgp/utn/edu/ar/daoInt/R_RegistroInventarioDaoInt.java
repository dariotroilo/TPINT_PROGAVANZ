package frgp.utn.edu.ar.daoInt;
import java.util.List;
import frgp.utn.edu.ar.entidad.R_RegistroInventario;

public interface R_RegistroInventarioDaoInt {

	public List<R_RegistroInventario> readAll();
	public List<R_RegistroInventario> readAllWithFilter(String filtro);
	public List<R_RegistroInventario> readAllUser(String usuario);
	public boolean agregarR_RegistroInventario(R_RegistroInventario a);
	public void Update(R_RegistroInventario r_registroinventario);
	public boolean Delete(Integer id);


}
