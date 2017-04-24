
package uni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.database.AccesoDB;
import uni.entity.Linea;
import uni.entity.Producto;

public class LineaDao implements Icrud<Linea> {

    @Override
    public int Grabar(Linea o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Modificar(Linea o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Eliminar(Linea o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Linea> listar() throws Exception {
       Connection cn = null;
        List<Linea> lista = new ArrayList<>();
        try {
            cn = AccesoDB.getConnection();
            String sql = "select * from lineas order by idlinea";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Linea l = new Linea();
                l.setIdlinea(rs.getInt("idlinea"));
                l.setNombre(rs.getString("nombre"));
                lista.add(l);
            }
            rs.close();
            stm.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public List<Linea> listar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Linea> listar(String cadena) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Linea Buscar(String cadena) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
