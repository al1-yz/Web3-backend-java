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

/**
 *
 * @author ALUNOS 2
 */
@WebServlet(name = "MarcaAguaController", urlPatterns = {"/MarcaAguaCadastro"})
public class MarcaAguaController extends HttpServlet {

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
            out.println("<title>Servlet MarcaAguaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MarcaAguaController at " + request.getContextPath() + "</h1>");
            out.println("<a href='cadastroMarcaAgua.html'>Voltar</a>");
            out.println("<a href='marcaAguas'>Ver marcas cadastradas</a>");
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
        
        String nome = request.getParameter("nome");
        String fonte = request.getParameter("fonte");
        double preco = Double.parseDouble(request.getParameter("preco"));
        String descricao = request.getParameter("Descricao");
        
        MarcaAgua mAgua = new MarcaAgua();
        
        mAgua.setNome(nome);
        mAgua.setFonteOrigem(fonte);
        mAgua.setPrecoMarca(preco);
        mAgua.setDescricao(descricao);
        
        MarcaAguaRepository.create(mAgua);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MarcaAguaCadastro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadastro feito com o lobo pidão</h1>");
            out.println("<a href='cadastroMarcaAgua.html'>voltar</a></br>");
            out.println("<a href='MarcaAguas'>Ver marcas cadastradas</a></br>");
            out.println("</body>");
            out.println("</html>");
        }
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
