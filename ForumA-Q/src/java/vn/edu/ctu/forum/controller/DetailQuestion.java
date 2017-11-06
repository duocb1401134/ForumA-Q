/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.edu.ctu.forum.models.pojos.Question;
import vn.edu.ctu.forum.models.service.AnwserService;
import vn.edu.ctu.forum.models.service.AnwserServiceImpl;
import vn.edu.ctu.forum.models.service.QuestionService;
import vn.edu.ctu.forum.models.service.QuestionServiceImpl;
import vn.edu.ctu.forum.models.pojos.Answer;

/**
 *
 * @author NTD
 */
@WebServlet(name = "DetailQuestion", urlPatterns = {"/detailQuestion"})
public class DetailQuestion extends HttpServlet {

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

        if (request.getQueryString() != null) {
            String questionID = request.getParameter("questionId");
            try {
                int id = Integer.parseInt(questionID);
                QuestionService questionService = new QuestionServiceImpl();
                Question question = questionService.findById(id);
                request.setAttribute("question", question);
                AnwserService anwserService = new AnwserServiceImpl();
                List<Answer> listAnswers = anwserService.findByIdQuesion(id);
                if(listAnswers!=null){
                    request.setAttribute("listAnswers", listAnswers);
                }
            } catch (Exception ex) {
                return;
            }
        }
        request.getRequestDispatcher("/detailquestion.jsp").forward(request, response);
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
