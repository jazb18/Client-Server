/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.controller;

import java.util.List;
import uni.dao.ClienteDao;
import uni.entity.Cliente;

/**
 *
 * @author Alumno
 */
public class ClienteController {
    
    ClienteDao cli=new ClienteDao();
    
     public List<Cliente> ListarClientes(){
         return cli.listar();
     }
     
}
