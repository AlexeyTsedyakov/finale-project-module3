package com.example.finaleprojectmodule3.servlets;

import com.example.finaleprojectmodule3.game.QuestGame;
import com.example.finaleprojectmodule3.game.Scene;
import com.example.finaleprojectmodule3.servlets.exceptions.BadRequestException;
import com.example.finaleprojectmodule3.servlets.exceptions.NotFoundException;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "logicServlet", value = "/quest-game")
public class LogicServlet extends HttpServlet {
    private QuestGame questGame;

    public void init() {
        questGame = QuestGame.getInstance();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        Scene nextScene;
        try {
            nextScene = getNextScene(request);
        } catch (BadRequestException e) {
            response.sendError(400, e.getMessage());
            return;
        } catch (NotFoundException e) {
            response.sendError(404, e.getMessage());
            return;
        }

        session.setAttribute("scene", nextScene);
        if (checkDeathOrWin(nextScene, session)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/end.jsp");
            dispatcher.forward(request, response);
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("quest-game.jsp");
        dispatcher.forward(request, response);
    }

    private Scene getNextScene(HttpServletRequest request) {
        String nextScene = request.getParameter("nextScene");
        if (nextScene == null) {
            throw new BadRequestException("Bad Request: nextScene parameter is missing.");
        }

        Scene scene = questGame.getScene(nextScene);
        if (scene == null) {
            throw new NotFoundException("Not Found: Missing scene " + nextScene);
        }

        return scene;
    }

    private boolean checkDeathOrWin(Scene scene, HttpSession session) throws ServletException, IOException {
        if (scene.isDeath() || scene.isWin()) {
            session.setAttribute("isDeath", scene.isDeath());
            session.setAttribute("isWin", scene.isWin());
            return true;
        } else {
            return false;
        }
    }
}