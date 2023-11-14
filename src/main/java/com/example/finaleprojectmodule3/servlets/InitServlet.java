package com.example.finaleprojectmodule3.servlets;

import com.example.finaleprojectmodule3.game.QuestGame;
import com.example.finaleprojectmodule3.servlets.exceptions.BadRequestException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "initServlet", urlPatterns = (""))
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/start.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String playerName;
        try {
            playerName = getPlayerName(request);
        } catch (BadRequestException e) {
            response.sendError(400, e.getMessage());
            return;
        }

        session.setAttribute("playerName", playerName);
    }

    private String getPlayerName(HttpServletRequest request) {
        String playerName = request.getParameter("playerName");
        if (playerName == null) {
            throw new BadRequestException("Bad Request: playerName parameter is missing.");
        }

        return playerName;
    }
}
