package frgp.utn.edu.ar.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.ZCB010Dao;

@Service
public class ZCB010Negocio {
	
	private ZCB010Dao zcb010Dao;
	
	
	public ZCB010Dao getZcb010Dao() {
		return zcb010Dao;
	}

	@Autowired
	public void setZcb010Dao(ZCB010Dao zcb010Dao) {
		this.zcb010Dao = zcb010Dao;
	}
	

	public String readWithCod(String codbar) {
		return zcb010Dao.readWithCod(codbar);
	}
	
}
