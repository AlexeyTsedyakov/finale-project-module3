package com.example.finaleprojectmodule3.servlets;

import com.example.finaleprojectmodule3.game.QuestGame;
import com.example.finaleprojectmodule3.game.Scene;

import java.io.*;
import java.net.http.HttpRequest;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "logicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    private QuestGame questGame;

    public void init() {
        questGame = QuestGame.getInstance();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
//        if (session.isNew()) {
//            session.setAttribute("currentScene", questGame.getStartScene());
//            response.sendRedirect("quest-game.jsp");
//            return;
//        }

        Scene nextScene = getNextScene(request, session);
        session.setAttribute("currentScene", nextScene);
    }

    public void destroy() {
    }

    private Scene getCurrentScene(HttpSession session) {
        Object currentScene = session.getAttribute("currentScene");
        if (currentScene.getClass() != Scene.class) {
            session.invalidate();
            throw new RuntimeException("Session is broken, try one more time!");
        }

        return (Scene) currentScene;
    }

    private Scene getNextScene(HttpServletRequest request, HttpSession session) {
        String userChoice = request.getParameter("userChoice");
        try {
            return questGame.getScene(userChoice);
        } catch (RuntimeException e) {
            session.invalidate();
            throw new RuntimeException(e);
        }
    }
}