/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author geofr
 */
@WebServlet(urlPatterns = {"/procesar"})
public class procesar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtenemos el listado del html
        String listado = request.getParameter("listado");

        if (listado == null) {
            PrintWriter out = response.getWriter();
            out.print("<html>No se indico un parametro de listado.</html>");
        } else {
            String archivo = null;
            if (listado.equals("1")) {
                //listado de clientes
                String[] clientes = {"Nombre cliente 1", "Nombre cliente 2", "Nombre cliente 3"};
                request.setAttribute("tipoListado", "Clientes");
                request.setAttribute("listado", clientes);
            } else if (listado.equals("2")) {
                //listado de pruductos
                String[] productos = {"Ropa", "Perfumeria", "Joyeria", "Zapatos"};
                request.setAttribute("tipoListado", "Productos");
                request.setAttribute("listado", productos);
            } else {
                //listado de sucursales
                String[] tiendas = {"Tienda Chiquimula pradera", "Tienda Chiquimula centro", "Tienda Zacapa", "Tienda Guatemala"};
                request.setAttribute("tipoListado", "Sucursales");
                request.setAttribute("listado", tiendas);
            }
            //tipo de respuesta
            archivo = new String("/listados.jsp");
            //tipo de respuesta
            response.setContentType("text/html");
            //quien llama al metodo del servlet para enviarlo como respuesta
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(archivo);
            //contenido de respuesta
            dispatcher.include(request, response);
        }
        return;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
