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


	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		//establecemos conexion con la unidad de persistencia...
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoCL3");
				//permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transaccion
				em.getTransaction().begin();
				//actualizamos
				em.merge(producto);
				//comfirmamos 
				em.getTransaction().commit();
				//cerramos
				em.close();
				
				
			}   //fin del metodo actualizar 
		
	


	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		//establecemos la conexion con unidad de persistencia.
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoCL3");
				//gestionar las entidades
				EntityManager em=fabr.createEntityManager();
				//iniciamos la transaccion
				em.getTransaction().begin();
				//recuperamos el codigo a eliminar
				TblProductocl3 elim=em.merge(producto);
				//procedemos a eliminar el registro
				em.remove(elim);
				//emitimos mensaje por consola
				System.out.println("Producto eliminado de la base de datos");
				//confirmamos
				em.getTransaction().commit();
				//cerramos
				em.close();
				
			}   //fin del metodo eliminar

}
