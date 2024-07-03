package TestEntidades;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl3;

public class TestEntidadUsuario {

	public static void main(String[] args) {
		//instancia de clases
		TblUsuariocl3 usuario=new TblUsuariocl3();
		ClassUsuarioImp crud=new ClassUsuarioImp();
		//asignamos valores
		usuario.setUsuariocl3("Juanalberto");
		usuario.setPasswordcl3("juan1234");
		
		//invocacion metodo registro
		crud.RegistrarUsuario(usuario);
		
}

}
