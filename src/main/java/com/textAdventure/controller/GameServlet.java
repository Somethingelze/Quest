package com.textAdventure.controller;

import com.textAdventure.model.Game;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = (Game) request.getSession().getAttribute("game");
        if (game == null) {
            game = new Game();
            request.getSession().setAttribute("game", game);
        }
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = (Game) request.getSession().getAttribute("game");
        if (game == null) {
            game = new Game();
            request.getSession().setAttribute("game", game);
        }

        String choice = request.getParameter("choice");
        if (choice != null) {
            game.nextStep(choice);
        }

        if (game.isFinished()) {
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/game.jsp").forward(request, response);
        }
    }
}
