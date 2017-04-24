package uni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.database.AccesoDB;
import uni.entity.Empleado;
import uni.entity.Producto;

public class ProductoDao implements Icrud<Producto> {

    @Override
    public int Grabar(Producto o) throws Exception {
        Connection cn = null;
        int iresult;
        try {
            cn = AccesoDB.getConnection();
            String sql = "insert into productos(idproducto,descripcion,idlinea,preciocompra,precioventa,stock)"
                    + " values(?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, o.getIdproducto());
            pstm.setString(2, o.getDescripcion());
            pstm.setInt(3, o.getIdlinea());
            pstm.setDouble(4, o.getPreciocompra());
            pstm.setDouble(5, o.getPrecioventa());
            pstm.setInt(6, o.getStock());
            iresult = pstm.executeUpdate() == 1 ? 1 : 0;
            pstm.close();
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
    public int Modificar(Producto o) throws Exception {
        Connection cn = null;
        int iresult;
        try {
            cn = AccesoDB.getConnection();
            String sql = "update productos set descripcion=?,idlinea=?,preciocompra=?,precioventa=?,stock=?"
                    + " where idproducto=?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, o.getDescripcion());
            pstm.setInt(2, o.getIdlinea());
            pstm.setDouble(3, o.getPreciocompra());
            pstm.setDouble(4, o.getPrecioventa());
            pstm.setInt(5, o.getStock());
            pstm.setString(6, o.getIdproducto());
            iresult = pstm.executeUpdate() == 1 ? 1 : 0;
            pstm.close();
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
    public int Eliminar(Producto o) throws Exception {
        Connection cn = null;
        int iresult;
        try {
            cn = AccesoDB.getConnection();
            String sql = "delete from productos where idproducto=?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, o.getIdproducto());
            iresult = pstm.executeUpdate() == 1 ? 1 : 0;
            pstm.close();
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
    public List<Producto> listar() throws Exception {
        Connection cn = null;
        List<Producto> lista = new ArrayList<>();
        try {
            cn = AccesoDB.getConnection();
            String sql = "select * from productos order by idproducto";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getString("idproducto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setIdlinea(rs.getInt("idlinea"));
                p.setPrecioventa(rs.getDouble("precioventa"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
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
    public List<Producto> listar(int id) throws Exception {
        List<Producto> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select * from productos where idlinea=? order by idproducto";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getString("idproducto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setIdlinea(rs.getInt("idlinea"));
                p.setPrecioventa(rs.getDouble("precioventa"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
            rs.close();
            pstm.close();
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
    public List<Producto> listar(String cadena) throws Exception {
        Connection cn = null;
        List<Producto> lista = new ArrayList<>();
        try {
            cn = AccesoDB.getConnection();
            String sql = "select * from productos where descripcion like ? order by idproducto";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cadena + '%');
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getString("idproducto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setIdlinea(rs.getInt("idlinea"));
                p.setPrecioventa(rs.getDouble("precioventa"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
            rs.close();
            pstm.close();
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
    public Producto Buscar(String cadena) throws Exception {
     Producto r = new Producto();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select * from productos where idproducto=?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, cadena);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                r.setIdproducto(rs.getString("idproducto"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setIdlinea(rs.getInt("idlinea"));
                r.setPreciocompra(rs.getDouble("preciocompra"));
                r.setPrecioventa(rs.getDouble("precioventa"));
                r.setStock(rs.getInt("stock"));
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
