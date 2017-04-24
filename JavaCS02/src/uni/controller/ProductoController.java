
package uni.controller;

import java.util.List;
import uni.dao.ProductoDao;
import uni.entity.Producto;

public class ProductoController {
  
    private ProductoDao dao;

    public ProductoController() {
        dao=new ProductoDao();
    }
    // metodos
    public List<Producto> ProductoListar() throws Exception{
        return dao.listar();
    }
    
    public List<Producto> ProductoPorNombre(String nom) throws Exception{
        return dao.listar(nom);
    }
    
    public List<Producto> ProductoPorLinea(int id) throws Exception{
        return dao.listar(id);
    }
    
    public int ProductoAdicionar(Producto p) throws Exception{
       return dao.Grabar(p);
    }
    
     public int ProductoModificar(Producto p) throws Exception{
       return dao.Modificar(p);
    }
     
     public int ProductoEliminar(Producto p) throws Exception{
       return dao.Eliminar(p);
    }
     
    public Producto DameProducto(String id) throws Exception{
       return dao.Buscar(id);
    }
}
