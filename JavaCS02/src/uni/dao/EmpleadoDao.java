package uni.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.database.AccesoDB;
import uni.entity.Empleado;

public class EmpleadoDao implements Icrud<Empleado> {
    
    @Override
    public int Grabar(Empleado o) throws Exception {
        Connection cn = null;
        int iresult;
        try {
            cn = AccesoDB.getConnection();
            String sql = "{call sp_Empleado_Adicionar(?,?,?,?,?,?)}";
            CallableStatement stm = cn.prepareCall(sql);
            stm.setString(1, o.getIdempleado());
            stm.setString(2, o.getNombre());
            stm.setString(3, o.getApellido());
            stm.setString(4, o.getEmail());
            stm.setString(5, o.getUsuario());
            stm.setString(6, o.getClave());
            iresult = stm.executeUpdate() == 1 ? 1 : 0;
            stm.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return iresult;
    }
    
    @Override
    public int Modificar(Empleado o) throws Exception {
        Connection cn = null;
        int iresult;
        try {
            cn = AccesoDB.getConnection();
            String sql = "{call sp_Empleado_Modificar(?,?,?,?,?,?)}";
            CallableStatement stm = cn.prepareCall(sql);
            stm.setString(1, o.getIdempleado());
            stm.setString(2, o.getNombre());
            stm.setString(3, o.getApellido());
            stm.setString(4, o.getEmail());
            stm.setString(5, o.getUsuario());
            stm.setString(6, o.getClave());
            
            iresult = stm.executeUpdate() == 1 ? 1 : 0;
            stm.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return iresult;
    }
    
    @Override
    public int Eliminar(Empleado o) throws Exception {
        Connection cn = null;
        int iresult;
        try {
            cn = AccesoDB.getConnection();
            String sql = "{call sp_Empleado_Eliminar(?)}";
            CallableStatement stm = cn.prepareCall(sql);
            stm.setString(1, o.getIdempleado());
            iresult = stm.executeUpdate() == 1 ? 1 : 0;
            stm.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return iresult;
    }
    
    @Override
    public List<Empleado> listar() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idempleado,nombre,apellidos,email from empleados order by idempleado";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado r = new Empleado();
                r.setIdempleado(rs.getString("idempleado"));
                r.setNombre(rs.getString("nombre"));
                r.setApellido(rs.getString("apellidos"));
                r.setEmail(rs.getString("email"));
                lista.add(r);
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
    public List<Empleado> listar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Empleado> listar(String cadena) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Empleado Buscar(String cadena) throws Exception {
        Empleado r = new Empleado();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select * from empleados where idempleado=?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, cadena);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                r.setIdempleado(rs.getString("idempleado"));
                r.setNombre(rs.getString("nombre"));
                r.setApellido(rs.getString("apellidos"));
                r.setEmail(rs.getString("email"));
                r.setUsuario(rs.getString("usuario"));
                r.setClave(rs.getString("clave"));
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
        return r;
    }
}
