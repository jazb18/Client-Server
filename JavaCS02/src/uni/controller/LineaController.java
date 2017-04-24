
package uni.controller;

import java.util.List;
import uni.dao.LineaDao;
import uni.entity.Linea;

public class LineaController {
  
    private LineaDao dao;

    public LineaController() {
        dao=new LineaDao();
    }
    //metodos
    public List<Linea> ListaLineas() throws Exception{
        return dao.listar();
    }
    
    
}
