package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductoImp;
import Dao.ParseoDouble;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		TblProductocl3 producto=new TblProductocl3();
		ClassProductoImp crud=new ClassProductoImp();
		
		//recuperamos la accion y codigo
				String accion=request.getParameter("accion");
				//aplicamos una condicion...
				if(accion!=null){
					switch(accion){
					case "Modificar":
						int codigo=Integer.parseInt(request.getParameter("cod"));
						//asignar el codigo...
						producto.setIdproductocl3(codigo);
						TblProductocl3 buscarcod=crud.BuscarProducto(producto);
						//enviar los valores buscados por codigo de la base de datos
						//al formulario actualizar..
						request.setAttribute("codigo",buscarcod.getIdproductocl3());
						request.setAttribute("nombre",buscarcod.getNombrecl3());
						request.setAttribute("precioventa",buscarcod.getPrecioventacl3());
						request.setAttribute("preciocomp",buscarcod.getPreciocompcl3());
						request.setAttribute("estado",buscarcod.getEstadocl3());
						request.setAttribute("descrip",buscarcod.getDescripcl3());
						
						//redireccionar..
						request.getRequestDispatcher("/FormActualizarProducto.jsp").forward(request, response);
						//salimos
						break;
					case "Eliminar":
					    int codeliminar = Integer.parseInt(request.getParameter("cod"));
					    // asignamos el codigo a eliminar
					    producto.setIdproductocl3(codeliminar);
					    // invocamos al metodo eliminar...
					    crud.EliminarProducto(producto);
					    // redirigir al listado de productos
					    response.sendRedirect(request.getContextPath() + "/ControladorProducto?accion=Listar");
					    break;

					
					case "Listar":
		
		
		List<TblProductocl3> listadoproducto=crud.ListadoProducto();
		
		//invocamos el listado 
		request.setAttribute("listadoproducto", listadoproducto);
		//redireccionamos
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
		//salimos
		break;
					}
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//recuperamos los valores del formulario
				String nombre=request.getParameter("nombre");
				double precio = ParseoDouble.getDoubleParameter(request, "precio");
			    double precioven = ParseoDouble.getDoubleParameter(request, "precioven");
				String estado=request.getParameter("estado");
				String descrip=request.getParameter("descrip");
				
			//	List<TblProductocl3> listadoproductos=null;
				
				//instanciar las entidades
				TblProductocl3 producto=new TblProductocl3();
				ClassProductoImp crud=new ClassProductoImp();
				//asignacion de valores
				producto.setNombrecl3(nombre);
				producto.setPrecioventacl3(precio);
				producto.setPreciocompcl3(precioven);
				producto.setEstadocl3(estado);
				producto.setDescripcl3(descrip);
			//	if(nombre!=null){
					//recupero el nombre a  actualizar...
					
					//asigno el codigo a actualizar
				//	producto.setNombrecl3(nombre);
					//invoco al metodo actualizar
				//	crud.ActualizarProducto(producto);
					//actualizador listado de clientes
				//	listadoproductos=crud.ListadoProducto();
					
				//}else{	
				//invocacion del metodo registrar
				crud.RegistrarProducto(producto);
				//actualizar listado de los productos
				List<TblProductocl3> listadoproducto=crud.ListadoProducto();
				
				//invocamos el listado 
				request.setAttribute("listadoproducto", listadoproducto);
				//redireccionamos
				request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
				
				
	}

	}
//}
