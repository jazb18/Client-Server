package uni.dao;

import java.util.List;

public interface Icrud<T> {
    // definir las firmas de los metodos

    public int Grabar(T o) throws Exception;

    public int Modificar(T o) throws Exception;

    public int Eliminar(T o) throws Exception;

    public List<T> listar() throws Exception;

    public List<T> listar(int id) throws Exception;

    public List<T> listar(String cadena) throws Exception;

    public T Buscar(String cadena) throws Exception;
}
