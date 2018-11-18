package com.varnit.teenpatti;

import java.util.Scanner;

public class TeenPattiGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Players: (Note: At least 2 Players required)");
        int noOfPlayers = sc.nextInt();
        if (noOfPlayers < 2) {
            System.out.println("At least 2 Players are required...");
            System.exit(0);
        }
        System.out.println("Enter No of Rounds want to play: ");
        int noOfRounds = sc.nextInt();
        for (int i = 0; i < noOfRounds; i++) {
            System.out.println("################ STARTING ROUND " + (i + 1) + " ################");
            GameRules pt = new GameRules();
            for (int j = 0; j < noOfPlayers; j++) {
                System.out.println("Enter Player " + (j + 1) + " Name: ");
                String playerName = sc.next();
                pt.addPlayers(playerName);
            }

            System.out.println("Distributing cards: ");
            pt.setPlayerCard();

            System.out.println("################ Finding Winner for Round " + (i + 1) + " ################");
            pt.findWinner();
        }
    }
}
