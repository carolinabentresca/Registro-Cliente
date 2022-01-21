
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page import="modelo.ClienteDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Cliente</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>
    <body style="background: #333333;font-family: cursive">
        <h3 style="color: #ffcc00;text-align: center">Registros de Clientes</h3>
        <br/>
    <center>
        <form action="registro" method="POST">
            <label style="color: #ffffff">Usuario (*)</label><br/>
            <input type="text" name="usuario"  placeholder=" " required="requiered" style="font-size: 100%"/><br/>
            <label style="color: #ffffff">Email (*)</label><br/>
            <input type="email" name="mail"  placeholder=" " required="requiered" style="font-size: 100%"/><br/>
            <label style="color: #ffffff">Password (*)</label><br/>
            <input type="password" name="password"  placeholder=" " required="requiered" style="font-size: 100%"/><br/>
            <br/>      
            <input type="submit" value="Registrar" name="btnRegistrar"  style="background: #ffcc00;color: #ffffff;font-size: 18px"/>
        </form>
        <hr style="background: #ffffff"/>
        <br/>
        <table border="1" style="background: #ffffff;color: #ffcc00">
            <tr>
                <td style="background: #ffcc00;color: #ffffff">Usuario</td>
                <td style="background: #ffcc00;color: #ffffff">Email</td>
            </tr>
            <%
                ClienteDao dao = new ClienteDao();
                Cliente cliente = new Cliente();
                List<Cliente> lista = dao.listar();
                for (Cliente cli : lista) {
            %>
            <tr>
                <td> <%= cli.getUsuario()%></td>
                <td> <%= cli.getMail()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </center>
</body>
</html>
