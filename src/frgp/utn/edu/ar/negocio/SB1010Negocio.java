package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.SB1010Dao;
import frgp.utn.edu.ar.entidad.SB1010;

@Service
public class SB1010Negocio {
	
	private SB1010Dao sb1010Dao;
	
	
	public SB1010Dao getSb1010Dao() {
		return sb1010Dao;
	}

	@Autowired
	public void setSb1010Dao(SB1010Dao sb1010Dao) {
		this.sb1010Dao = sb1010Dao;
	}
	
	public List<SB1010> readAll() {
		return sb1010Dao.readAll();
	}

/* 
	public List<SB1010> readWithCod(String cod) {
		return sb1010Dao.readWithCod(cod);
	}
*/
	public SB1010 readWithCod(String cod) {
		return sb1010Dao.readWithCod(cod);
	}
	
}
