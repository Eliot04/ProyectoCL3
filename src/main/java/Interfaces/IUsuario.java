package Interfaces;

import model.TblUsuariocl3;

public interface IUsuario {
	//declaracion de metodos
			public void RegistrarUsuario (TblUsuariocl3 usuario);
			public boolean validarUsuario(String usuario, String password);
}
