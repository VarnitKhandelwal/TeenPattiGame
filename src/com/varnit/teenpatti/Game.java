package com.varnit.teenpatti;

public class Game {

    private String winnerName;
    private String reason;
    private int score;
    private String cards;

    public Game(String winnerName, String reason, int score, String cards) {
        super();
        this.winnerName = winnerName;
        this.reason = reason;
        this.score = score;
        this.cards = cards;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String getReason() {
        return reason;
    }

    public int getScore() {
        return score;
    }

    public String getCards() {
        return cards;
    }
}
