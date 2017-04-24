package uni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.database.AccesoDB;
import uni.entity.Cliente;

public class ClienteDao implements Icrud<Cliente> {

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String query = "select idCliente,nombre from Clientes order by idCliente";
            Statement stm = cn.createStatement();
            ResultSet rset = stm.executeQuery(query);
            while (rset.next()) {
                Cliente o = new Cliente();
                o.setIdcliente(rset.getString("idCliente"));
                o.setNombre(rset.getString("nombre"));
                lista.add(o);
            }
            rset.close();
            stm.close();
        } catch (SQLException | ClassNotFoundException e) {
            try {
                throw e;
            } catch (SQLException | ClassNotFoundException ex) {
            }
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public int Grabar(Cliente o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Modificar(Cliente o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Eliminar(Cliente o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar(String cadena) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente Buscar(String cadena) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
