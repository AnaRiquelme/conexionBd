package net.daw.control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.io.*;
import javax.servlet.ServletConfig;
/**
 *
 * @author al037793
 */
public class ConectaBD extends HttpServlet {

    public void init(ServletConfig conf) throws ServletException{
        super.init(conf);
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conexion = null;
        try {
             
        
      
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:3306:facturacion","root","bitnami");
        
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controllerjsp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Nos hemos conectado</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        }catch (ClassNotFoundException e1){
            //Error si no puedo leer el driver de Oracle
            out.println("ERROR: No encuentro el driver de la BD:" + e1.getMessage());
        }catch(SQLException e2){
            //Error SQL: login/psswd mal
            out.println("ERROR: Fallo en SQL: " + e2.getMessage());
        } 
        finally {            
            try{
                if (conexion != null){
                    conexion.close();
                }
            }catch (SQLException e3){
                out.println("ERROR: Fallo al desconectar de la BD: " + e3.getMessage());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
