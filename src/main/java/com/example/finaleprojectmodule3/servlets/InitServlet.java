package com.example.finaleprojectmodule3.servlets;

import com.example.finaleprojectmodule3.game.QuestGame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "initServlet", urlPatterns = {"/", "/start"})
public class InitServlet extends HttpServlet {
    private QuestGame questGame;

    @Override
    public void init() throws ServletException {
        questGame = QuestGame.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("currentScene", questGame.getStartScene());
        response.sendRedirect("start.jsp");
    }
}
