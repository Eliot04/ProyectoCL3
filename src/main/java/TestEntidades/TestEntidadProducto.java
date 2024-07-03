package TestEntidades;

import java.util.List;

import Dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {

	public static void main(String[] args) {
		//instancia de clases
				TblProductocl3 producto=new TblProductocl3();
				ClassProductoImp crud=new ClassProductoImp();
				//asignamos valores
				producto.setNombrecl3("Mayonesa");
				producto.setPrecioventacl3(2.20);
				producto.setPreciocompcl3(3.50);
				producto.setEstadocl3("En stock");
				producto.setDescripcl3("Mayonesa casera");
				//invocacion metodo registro
				crud.RegistrarProducto(producto);
				
				
			/*	//testeo del metodo list
				List<TblProductocl3> listado=crud.ListadoProducto();
				//bucle for
				for(TblProductocl3 lis:listado){
					
					//imprimimos
					System.out.println("Codigo : "+lis.getIdproductocl3()+
							"Nombre : "+lis.getNombrecl3()+"PV : "+lis.getPrecioventacl3()
							+"PC : "+lis.getPreciocompcl3()+"Estado : "+lis.getEstadocl3()
							+"Descrip. : "+lis.getDescripcl3());
					
				}*/
			}
}
