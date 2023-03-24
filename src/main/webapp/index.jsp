<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<style>
    body {
        margin: auto;
        max-width: max-content;
        text-align: center;
    }

    h1 {
        align-content: center;
    }

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }

    th {
        width: 200px;
    }

    td {
        width: 600px;
        text-align: start;
        padding: 4px;
    }
</style>

<head>
    <title>Banco</title>
</head>

<body>
<h1 style="align-content: center"><%= "Banco Nacional" %></h1>
<br/>
<form id="form" action="Servlet" method="POST">
    <table style="align-content: center">
        <tr>
            <th>
                <label for="clienteNombre">Nombre Cliente</label>
            </th>
            <td>
                <input type="text" id="clienteNombre" name="clienteNombre" style="width: 99%">
            </td>
        </tr>

        <tr>
            <th>
                <label for="idFiscal">Id Fiscal (DNI, NIE)</label>
            </th>
            <td>
                <input type="text" id="idFiscal" name="idFiscal" maxlength="9" style="width: 20%">
            </td>
        </tr>

        <tr>
            <th>
                <label for="clienteEmail">Email Cliente</label>
            </th>
            <td>
                <input type="email" id="clienteEmail" name="clienteEmail" style="width: 40%">
            </td>
        </tr>

        <tr>
            <th>
                <label for="clientePais">Pais</label>
            </th>
            <td>
                <input type="text" id="clientePais" name="clientePais" style="width: 25%">
            </td>
        </tr>

        <tr>
            <th>
                <label for="clienteCuenta">Cuenta</label>
            </th>
            <td>
                <input type="text" id="clienteCuenta" name="clienteCuenta" style="width: 30%">
            </td>
        </tr>

        <tr>
            <th>
                <label for="clienteIngreso">Ingreso inicial (€)</label>
            </th>
            <td>
                <input type="number" id="clienteIngreso" name="clienteIngreso" style="width: 27%">
            </td>
        </tr>

        <tr>
            <td style="text-align: center" colspan="2">
                <button type="submit" form="form" value="accion" name="accion">Crear cliente</button>
            </td>
        </tr>

        <tr>
            <td style="text-align: center" colspan="2">
                <button type="submit" form="form" value="mostrar" name="accion">Mostrar clientes</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>