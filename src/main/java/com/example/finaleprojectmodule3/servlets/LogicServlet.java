package com.example.finaleprojectmodule3.servlets;

import com.example.finaleprojectmodule3.game.QuestGame;
import com.example.finaleprojectmodule3.game.Scene;
import com.example.finaleprojectmodule3.servlets.exceptions.BadRequestException;
import com.example.finaleprojectmodule3.servlets.exceptions.NotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        String nextScene = request.getParameter("scene");
        if (nextScene == null) {
            throw new BadRequestException("Bad Request: scene parameter is missing.");
        }

        Scene scene = questGame.getScene(nextScene);
        if (scene == null) {
            throw new NotFoundException("Not Found: Missing scene " + nextScene);
        }

        return scene;
    }

    private boolean checkDeathOrWin(Scene scene, HttpSession session) {
        if (scene.isDeath() || scene.isWin()) {
            session.setAttribute("isDeath", scene.isDeath());
            session.setAttribute("isWin", scene.isWin());
            return true;
        } else {
            return false;
        }
    }
}