package com.example.act3uf2m06.Controlador;

import com.example.act3uf2m06.Model.Clients;
import com.example.act3uf2m06.Model.Comptes;
import com.example.act3uf2m06.Model.Hibernate;
import com.example.act3uf2m06.Model.HibernateDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    String dni;
    String nombre;
    String correo;
    String pais;
    String cuenta;
    String ingreso;
    int cantidad;
    String action;
    boolean acc=false;

    Clients cActual=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action= request.getParameter("accion");

        if (action.equals("accion")){
            int x=0;
            nombre=request.getParameter("clienteNombre");
            correo =request.getParameter("clienteEmail");
            dni=request.getParameter("idFiscal");
            pais=request.getParameter("clientePais");
            cuenta=request.getParameter("clienteCuenta");
            ingreso=request.getParameter("clienteIngreso");
            cantidad=Integer.parseInt(ingreso);


            Session ss=HibernateUtil.getsF();
            Transaction ts=null;

            try{
                ts=ss.beginTransaction();
                cActual=ss.get(Clients.class, dni);
                ts.commit();

            }catch (Exception ex){
                if (ts !=null){
                    ts.rollback();
                }
                System.out.println("error"+ex);
                ss.close();
            }


            if(cActual==null){
                cActual=new Clients(dni,nombre, correo,pais);
                acc=true;
            }

            Comptes cp= new Comptes(cuenta,cantidad,cActual);
            cActual.getIdCompte().add(cp);
            ss=HibernateUtil.getsF();
            ts=null;
            System.out.println(cActual.toString());

            try{
                ts=ss.beginTransaction();
                ss.merge(cActual);
                ts.commit();
            }catch (Exception ex){
                ts.rollback();
                ss.close();
                System.out.println("error"+ex);
            }

            response.setContentType("text/plain");
            PrintWriter pw=response.getWriter();
            if(acc){
                pw.print("Se ha creado el usuario: "+nombre);
            }else{
                pw.print("Nueva cuenta bancaria: "+ nombre);
            }
            pw.close();



        } else if (action.equals("mostrar")) {
            List<Clients> clientes;
            response.setContentType("text/html");
            StringBuilder sb=new StringBuilder();

            HibernateDao dao=new Hibernate(HibernateUtil.getsF().getSessionFactory());
            clientes=dao.getAll();

            sb.append("<html>");
            sb.append("<body>");
            sb.append("<h1>Cuentas</h1>");
            sb.append("<table>");
            sb.append("<tr><th>Nombre</th><th>DNI</th><th>Cuenta</th><th>Saldo</th></tr>");

            for(Clients client : clientes) {
                sb.append("<tr>");
                sb.append("<td>" + client.getNombre() + "</td>");
                sb.append("<td>" + client.getDni() + "</td>");

                List<Comptes> comptes = client.getIdCompte();

                for (Comptes compte : comptes) {
                    sb.append("<td>" + compte.getCuenta() + "</td>");
                    sb.append("<td>" + compte.getIngresoInicial() + "</td>");
                }
                sb.append("</tr>");
            }

            sb.append("</table>");
            sb.append("/html");
            sb.append("</body>");

            response.getWriter().println(sb.toString());
        }

    }
}
