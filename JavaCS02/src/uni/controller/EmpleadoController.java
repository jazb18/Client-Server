
package uni.controller;

import java.util.List;
import uni.dao.EmpleadoDao;
import uni.entity.Empleado;

public class EmpleadoController {
    
  private EmpleadoDao dao;

    public EmpleadoController() {
        dao=new EmpleadoDao();
    }
    // metodos
    public List<Empleado> EmpleadoListar() throws Exception{
        return dao.listar();
    }
    
    public int EmpleadoAdicionar(Empleado r) throws Exception{
        return dao.Grabar(r);
    }
    
    public int EmpleadoActualizar(Empleado r) throws Exception{
        return dao.Modificar(r);
    }
  
    public int EmpleadoEliminar(Empleado r) throws Exception{
        return dao.Eliminar(r);
    }
  
}
