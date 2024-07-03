package Interfaces;

import java.util.List;

import model.TblProductocl3;

public interface IProducto {
	//declaracion de metodos
		public void RegistrarProducto (TblProductocl3 producto);
		public List<TblProductocl3> ListadoProducto();
		public void ActualizarProducto(TblProductocl3 producto);
		public void EliminarProducto(TblProductocl3 producto);
}
