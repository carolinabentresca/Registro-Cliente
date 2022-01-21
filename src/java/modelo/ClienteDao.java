package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends Conexion {

    PreparedStatement ps;
    ResultSet rs;
    Connection con = null;

    //Registrar Cliente
    public boolean registrar(Cliente cli) {
        String sql = "insert into cliente(usuario,mail,password)values(?,?,?)";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getUsuario());
            ps.setString(2, cli.getMail());
            ps.setString(3, cli.getPassword());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    //Listar Clientes
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList();
        String sql = "select * from cliente";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String mail = rs.getString("mail");
                String password = rs.getString("password");
                Cliente cliente = new Cliente(usuario, mail, password);
                lista.add(cliente);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }
}
