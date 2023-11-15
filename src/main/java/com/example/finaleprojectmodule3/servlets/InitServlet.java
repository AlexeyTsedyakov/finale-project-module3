package com.example.finaleprojectmodule3.servlets;

import com.example.finaleprojectmodule3.servlets.exceptions.BadRequestException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String playerName;
        try {
            playerName = getPlayerName(request);
        } catch (BadRequestException e) {
            response.sendError(400, e.getMessage());
            return;
        }
        String ipAddress = getIpAddress(request);
        int gameCount = 1;

        session.setAttribute("playerName", playerName);
        session.setAttribute("ipAddress", ipAddress);
        session.setAttribute("gameCount", gameCount);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(getResponseBody());
    }

    private String getPlayerName(HttpServletRequest request) {
        Gson gson = new Gson();
        JsonObject jsonObject;
        try {
            jsonObject = gson.fromJson(request.getReader(), JsonObject.class);
        } catch (IOException e) {
            throw new BadRequestException(e.getMessage());
        }
        JsonElement jsonElement = jsonObject.get("playerName");
        if (jsonElement == null || jsonElement.isJsonNull()) {
            throw new BadRequestException("Bad Request: field playerName is missing.");
        }

        return jsonElement.getAsString();
    }

    private String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }

    private String getResponseBody() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("redirect", "/quest-game?nextScene=startScene");
        return new Gson().toJson(jsonObject);
    }
}