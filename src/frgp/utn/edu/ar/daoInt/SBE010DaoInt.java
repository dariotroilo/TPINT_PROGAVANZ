package frgp.utn.edu.ar.daoInt;
import java.util.List;
import frgp.utn.edu.ar.entidad.SBE010;

public interface SBE010DaoInt {

	public List<SBE010> readWithFilial(String filial);
	public List<SBE010> readAll();
	public List<SBE010> readFirst(String filial, String inicio);

}
