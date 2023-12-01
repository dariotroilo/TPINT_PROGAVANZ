package frgp.utn.edu.ar.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.entidad.Userubicacion;
import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.daoInt.UserubicacionDaoInt;

@Repository("UserubicacionDao")
public class UserubicacionDao implements UserubicacionDaoInt {

	private ConfigHibernate config;

	public UserubicacionDao() {
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
	public List<Userubicacion> readAll() {
		Session session = config.abrirConexion();
		List<Userubicacion> userubicaciones = new ArrayList<>();

		try {
			String hql = "FROM Userubicacion";
			Query query = session.createQuery(hql);
			Object[] result = query.list().toArray();

			for (Object obj : result) {
				if (obj instanceof Userubicacion) {
					userubicaciones.add((Userubicacion) obj);
				}
			}
			return userubicaciones;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud UserubicacionDao readAll", e);
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional()
	public Userubicacion Get(Long Id) {
		Session session = config.abrirConexion();

		try {
			session.beginTransaction();
			String hql = "FROM Userubicacion a WHERE a.id = :Id";
			Query query = session.createQuery(hql);
			query.setParameter("id", Id);
			Userubicacion userubicacion = (Userubicacion) query.uniqueResult();

			return userubicacion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud UserubicacionDao Get", e);
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional()
	public Userubicacion Getuser(String usuario) {
		Session session = config.abrirConexion();

		try {
			session.beginTransaction();
			String hql = "FROM Userubicacion a WHERE a.usuario = :usuario";
			Query query = session.createQuery(hql);
			query.setParameter("usuario", usuario);
			Userubicacion userubicacion = (Userubicacion) query.uniqueResult();

			return userubicacion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud UserubicacionDao Getuser", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void Update(Userubicacion userubicacion) {
		Session session = config.abrirConexion();

		try {
			session.beginTransaction();
			session.update(userubicacion);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud UserubicacionDao Update", e);
		} finally {
			session.close();
		}
	}

}
