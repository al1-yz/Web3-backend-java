/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpe.recife.raincifedelivery.controllers;

import br.edu.ifpe.recife.raincifedelivery.model.entities.MarcaAgua;
import br.edu.ifpe.recife.raincifedelivery.model.repositories.MarcaAguaRepository;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ALUNOS 2
 */
@WebServlet(name = "MarcaAguas", urlPatterns = {"/MarcaAguas"})
public class MarcaAguas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MarcaAguas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MarcaAguas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
        String op = request.getParameter("operacao");
        if(op != null && op.equals("detalhar")){
            String id = request.getParameter("id");
            MarcaAgua agua = MarcaAguaRepository.read(id);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MarcaAguas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Marca de Água cadastrada</h1>");
            out.println("<a href='MarcaAguas'>Ver marcas cadastradas</a></br>");
            out.println("Nome:"+agua.getNome()+"</br>");
            out.println("Nome:"+agua.getFonteOrigem()+"</br>");
            out.println("Nome:"+agua.getPrecoMarca()+"</br>");
            out.println("Nome:"+agua.getDescricao()+"</br>");
            out.println("</body>");
            out.println("</html>");
        }
        return;
        }
        
        List<MarcaAgua> aguas = MarcaAguaRepository.readAll();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MarcaAguas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Marcas de Água Cadastradas</h1>");
            out.println("<a href='cadastroMarcaAgua.html'>cadastrar nova marca</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>Nome</th><th>Fonte</th><th>Preço</th></tr>");
            
            for(MarcaAgua agua: aguas){
                out.println("<tr>");
                out.println("<td>"+agua.getNome()+"</td>");
                out.println("<td>"+agua.getFonteOrigem()+"</td>");
                out.println("<td>"+agua.getPrecoMarca()+"</td>");
                out.println("<td><a href='MarcaAguas?operacao=detalhar&id=" +agua.getNome() + "'>detalhar</a></td>");
                out.println("</tr>");
            }
            out.println("<a href='index.html'>voltar</a></br>");
            out.println("</body>");
            out.println("</html>");
        }
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
