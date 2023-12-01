package frgp.utn.edu.ar.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.entidad.ZCB010;
import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.daoInt.ZCB010DaoInt;

@Repository("ZCB010Dao")
public class ZCB010Dao implements ZCB010DaoInt {

	private ConfigHibernate config;
	
	public ZCB010Dao()
	{
		this.config = new ConfigHibernate();
	}
	
	public ConfigHibernate getConfig() {
		return config;
	}

	public void setConfig(ConfigHibernate config) {
		this.config = config;
	}

	
	
	@Override
	@Transactional()
	public String readWithCod(String cod) {
	    Session session = config.abrirConexion();
	    //session.beginTransaction();
	    String codigodev = "0000000";
	    //SB1010 producto = new SB1010();
	    
	    try
	    {
	    	String hql = "FROM ZCB010 a WHERE a.zcb_codbar='" + cod + "' AND a.d_e_l_e_t_<> '*' order by a.zcb_quant asc";
			Query query = session.createQuery(hql);
			query.setMaxResults(1);
			ZCB010 producto = (ZCB010) query.uniqueResult();
			if (producto != null) {
	            codigodev = producto.getZcb_cod();
			}
			return codigodev;
	    } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud ZCB010Dao readWithCod", e);
		} finally {
			session.close();
		}
	    
	}
}
