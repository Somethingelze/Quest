package com.textAdventure.model;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private int step;
    private boolean isFinished;
    private String message;

    public Game() {
        reset();
    }

    public void reset() {
        step = 0;
        isFinished = false;
        message = "Добро пожаловать в текстовый квест!";
    }

    public String getMessage() {
        return message;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void nextStep(String choice) {
        step++;
        switch (step) {
            case 1:
                if ("left".equals(choice)) {
                    message = "Вы пошли налево и встретили дракона!";
                } else if ("right".equals(choice)) {
                    message = "Вы пошли направо и нашли сокровище!";
                } else {
                    message = "Вы остались на месте и ничего не произошло.";
                }
                break;
            case 2:
                if ("fight".equals(choice)) {
                    message = "Вы победили дракона!";
                    isFinished = true;
                } else if ("run".equals(choice)) {
                    message = "Вы убежали от дракона.";
                    isFinished = true;
                } else {
                    message = "Ничего не произошло.";
                    isFinished = true;
                }
                break;
            default:
                message = "Конец игры.";
                isFinished = true;
                break;
        }
    }
}