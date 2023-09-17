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
	    session.beginTransaction();
	    /*SB1010 producto = new SB1010();*/

	    try
	    {
	        //String hql = "SELECT R_E_C_N_O_,BE_FILIAL,LEFT(BE_LOCALIZ,5) as BE_LOCAL, BE_LOCALIZ, BE_DESCRIC, BE_PRIOR FROM SBE010 a WHERE a.D_E_L_E_T_= '' and a.BE_FILIAL='" + filial; // +"' group by LEFT(BE_FILIAL,5) desc";
	    	String hql = "FROM ZCB010 a WHERE a.zcb_codbar='" + cod + "' AND a.d_e_l_e_t_<> '*' order by a.zcb_quant asc";
			Query query = session.createQuery(hql);
			query.setMaxResults(1);
			ZCB010 producto = (ZCB010) query.uniqueResult();
			session.getTransaction().commit();
			return producto.getZcb_cod();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			config.cerrarSession();
		}	
	}
}
