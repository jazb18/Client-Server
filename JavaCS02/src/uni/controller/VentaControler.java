package uni.controller;

import uni.dao.VentaDao;
import uni.entity.Venta;

public class VentaControler {

    private VentaDao oventa;

    public VentaControler() {
        oventa = new VentaDao();
    }
    //metodo

    public int registraVenta(Venta reg) throws Exception {
        return oventa.registraVenta(reg);
    }
}
