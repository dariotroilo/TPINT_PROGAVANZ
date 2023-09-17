package frgp.utn.edu.ar.daoInt;
import java.util.List;
import frgp.utn.edu.ar.entidad.SB1010;

public interface SB1010DaoInt {

	public SB1010 readWithCod(String codigo);
	public List<SB1010> readAll();

}
