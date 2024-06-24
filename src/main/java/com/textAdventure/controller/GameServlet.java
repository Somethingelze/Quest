package com.textadventure.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.textAdventure.model.Game;

import java.io.IOException;

// Убедитесь, что аннотация @WebServlet удалена, так как мы будем использовать web.xml для настройки
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = new Game();
        req.getSession().setAttribute("game", game);
        req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = (Game) req.getSession().getAttribute("game");
        if (game == null) {
            resp.sendRedirect("game");
            return;
        }

        String choice = req.getParameter("choice");
        if (choice != null) {
            game.nextStep(choice);
        }

        if (game.isFinished()) {
            req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req, resp);
        }
    }
}
