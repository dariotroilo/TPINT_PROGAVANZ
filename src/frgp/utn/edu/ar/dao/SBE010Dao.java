package frgp.utn.edu.ar.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.entidad.SBE010;
import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.daoInt.SBE010DaoInt;

@Repository("SBE010Dao")
public class SBE010Dao implements SBE010DaoInt {

	private ConfigHibernate config;
	
	public SBE010Dao()
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
	public List<SBE010> readWithFilial(String filial) {
	    Session session = config.abrirConexion();
	    //session.beginTransaction();
	    List<SBE010> ubicaciones = new ArrayList<>();

	    try
	    {
	        //String hql = "SELECT R_E_C_N_O_,BE_FILIAL,LEFT(BE_LOCALIZ,5) as BE_LOCAL, BE_LOCALIZ, BE_DESCRIC, BE_PRIOR FROM SBE010 a WHERE a.D_E_L_E_T_= '' and a.BE_FILIAL='" + filial; // +"' group by LEFT(BE_FILIAL,5) desc";
	    	String hql = "FROM SBE010 a WHERE a.be_filial='" + filial + "' AND a.D_E_L_E_T_= ''";
	    	Query query = session.createQuery(hql);
	    	//query.setParameter("filial", filial);
	        Object[] result = query.list().toArray();
	        
	        for (Object obj : result) {
	            if (obj instanceof SBE010) {
	                ubicaciones.add((SBE010) obj);
	            }
	        }

	        return ubicaciones;
	    }
	    catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud SBE010DAO readWithFilial", e);
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional()
	public List<SBE010> readAll() {
	    Session session = config.abrirConexion();
	    //session.beginTransaction();
	    List<SBE010> ubicaciones = new ArrayList<>();

	    try
	    {
	        String hql = "FROM SBE010 a WHERE a.D_E_L_E_T_= '' order by a.be_localiz";
	        Query query = session.createQuery(hql);
	        Object[] result = query.list().toArray();
	        
	        for (Object obj : result) {
	            if (obj instanceof SBE010) {
	                ubicaciones.add((SBE010) obj);
	            }
	        }
		    return ubicaciones;
	    }
	    catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud SBE010DAO readAll", e);
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional()
	public List<SBE010> readFirst(String filial, String inicio) {
	    Session session = config.abrirConexion();
	    List<SBE010> ubicaciones = new ArrayList<>();

	    try
	    {
	        String hql = "a.R_E_C_N_O_,a.BE_FILIAL,LEFT(a.BE_LOCALIZ,5) as BE_LOCAL, a.BE_LOCALIZ, a.BE_DESCRIC, a.BE_PRIOR FROM SBE010 a WHERE a.D_E_L_E_T_= '' AND a.BE_FILIAL='" + filial + "' AND LEFT(a.BE_LOCALIZ,5)='" + inicio + "'";
	        Query query = session.createQuery(hql);
	        Object[] result = query.list().toArray();
	        
	        for (Object obj : result) {
	            if (obj instanceof SBE010) {
	            	ubicaciones.add((SBE010) obj);
	            }
	        }
		    return ubicaciones;
	    }
	    catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud SBE010DAO readFirst", e);
		} finally {
			session.close();
		}
	}

}
