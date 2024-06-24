package com.textAdventure.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.textAdventure.model.Game;

import java.io.IOException;

public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = new Game();
        req.getSession().setAttribute("game", game);
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
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
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
    }
}
