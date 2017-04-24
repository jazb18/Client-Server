package uni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uni.database.AccesoDB;
import uni.entity.Detalle;
import uni.entity.Venta;

public class VentaDao {
// metodos

    public int registraVenta(Venta reg) throws Exception {
        Connection cn = null;
        int nroVenta;
        try {
            cn = AccesoDB.getConnection();
            // inicia transaccion
            cn.setAutoCommit(false);
            //
            String consulta = "Select Valor from Control where parametro='Ventas'";
            Statement stm1 = cn.createStatement();
            ResultSet rset = stm1.executeQuery(consulta);
            rset.next();
            nroVenta = rset.getInt("Valor");
            rset.close();
            consulta = "update Control set Valor=Valor+1 where parametro='Ventas'";
            stm1 = cn.createStatement();
            stm1.executeUpdate(consulta);
            // registra ventas
            String query = "Insert Into Ventas(IdVenta,IdCliente,idEmpleado,tipodoc,Nrodoc,Fecha,Total) Values(?,?,?,?,?,sysdate,?)";
            PreparedStatement stm = cn.prepareStatement(query);
            stm.setInt(1, nroVenta);
            stm.setString(2, reg.getIdcliente());
            stm.setString(3, reg.getIdempleado());
            stm.setString(4, reg.getTipodoc());
            stm.setString(5, reg.getNrodoc());
            stm.setDouble(6, reg.getTotal());
            stm.executeUpdate();
            //graba detalle venta
            query = "Insert Into DetalleVenta(IdVenta,idproducto,precio,cantidad,importe) Values(?,?,?,?,?)";
            PreparedStatement stma = cn.prepareStatement(query);
            //actualiza stock
            query = "Update Productos  set Stock= Stock - ? where idProducto=?";
            PreparedStatement stmb = cn.prepareStatement(query);
            for (Detalle item : reg.getDetalle()) {
                stma.setInt(1, nroVenta);
                stma.setString(2, item.getIdproducto());
                stma.setDouble(3, item.getPrecio());
                stma.setInt(4, item.getCantidad());
                stma.setDouble(5, item.getImporte());
                stma.executeUpdate();
                // actualizar stock de producto
                stmb.setInt(1, item.getCantidad());
                stmb.setString(2, item.getIdproducto());
                stmb.executeUpdate();
            }
            stm1.close();
            stm.close();
            stma.close();
            stmb.close();
            cn.commit(); // confirma la transaccion
        } catch (SQLException | ClassNotFoundException e) {
            try {
                cn.rollback();// deshacer la transaccion
            } catch (Exception e1) {
            }
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return nroVenta;
    }
}
