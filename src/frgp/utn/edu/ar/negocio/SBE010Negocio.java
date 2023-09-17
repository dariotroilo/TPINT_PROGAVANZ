package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.SBE010Dao;
import frgp.utn.edu.ar.entidad.SBE010;

@Service
public class SBE010Negocio {
	
	private SBE010Dao sbe010Dao;
	
	
	public SBE010Dao getSbe010Dao() {
		return sbe010Dao;
	}

	@Autowired
	public void setSbe010Dao(SBE010Dao sbe010Dao) {
		this.sbe010Dao = sbe010Dao;
	}
	
	public List<SBE010> readAll() {
		return sbe010Dao.readAll();
	}

	public List<SBE010> readWithFilial(String filial) {
		return sbe010Dao.readWithFilial(filial);
	}
	
	public List<SBE010> readFirst(String filial, String first) {
		return sbe010Dao.readFirst(filial,first);
	}

}
