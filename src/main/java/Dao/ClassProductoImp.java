package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductocl3;

public class ClassProductoImp implements IProducto {

	//@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		//cadena de conexion con la unidad de persistencia
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoCL3");
				//gestion de entidades
				EntityManager em=fabr.createEntityManager();
				//inicio de transaccion
				em.getTransaction().begin();
				//registramos
				em.persist(producto);
				//mensaje de consola
				System.out.println("Producto Registrado en la BD");
				//confirmamos
				em.getTransaction().commit();
				//cerramos
				em.close();
			}//fin del registro
		

	//@Override
	public List<TblProductocl3> ListadoProducto() {
		//cadena de conexion con la unidad de persistencia
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoCL3");
				//gestion de entidades
				EntityManager em=fabr.createEntityManager();
				//inicio de transaccion
				em.getTransaction().begin();
				//recuperamos los productos de la bd(jpql)
				List<TblProductocl3> listadoproducto= em.createQuery("select c from TblProductocl3 c",TblProductocl3.class).getResultList();
				//confirmamos la transaccion
				em.getTransaction().commit();
				//cerramos
				em.close();
						
				return listadoproducto;
	}

}
