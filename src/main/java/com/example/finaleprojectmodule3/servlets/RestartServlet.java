package com.example.finaleprojectmodule3.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "restartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int gameCount = getGameCount(session);
        session.setAttribute("gameCount", ++gameCount);
        session.setAttribute("isDeath", false);
        session.setAttribute("isWin", false);

        response.sendRedirect("/quest-game?scene=startScene");
    }

    private int getGameCount(HttpSession session) {
        try {
            return (int) session.getAttribute("gameCount");
        } catch (Exception e) {
            return  0;
        }
    }
}
