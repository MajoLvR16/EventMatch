/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Modelo.Dao.UsuarioDao;
import Modelo.Entity.Usuario;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Acer
 */
public class UsuarioTest {
    
    public static void main(String[] args) {
        UsuarioDao usuarioDao = new UsuarioDao();
        Date fechaDaniela = new Date(123, 19, 8);
        Usuario daniela = new Usuario("1152269", "Daniela", "manzana", fechaDaniela, "viva soda stereo", null, null, "1152269");
        System.out.println("Resultado al insertar: " + usuarioDao.Insertar(daniela));
    }
}
