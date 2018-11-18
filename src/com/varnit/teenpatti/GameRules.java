package com.varnit.teenpatti;

import java.util.*;

public class GameRules {

    Deck deck;
    Player pl;

    List<String> randCardsList = new ArrayList<>();
    List<String> playerList = new ArrayList<>();
    List<String> cardList = new ArrayList<>();
    Map<String, List<String>> finalList = new HashMap<>();
    List<Game> result = new ArrayList<Game>();

    public GameRules() {
        super();
        deck = new Deck();
        pl = new Player();
    }

    public void addPlayers(String name) {
        pl.addPlayers(name);
    }

    public void shuffle() {
        Collections.shuffle(deck.getCollectionCards());
        randCardsList.addAll(deck.getCollectionCards());
    }

    public List<String> getRandCardsList() {
        return randCardsList;
    }

    public List<Game> getResult() {
        return result;
    }

    public void setPlayerCard() {
        shuffle();
        Integer noOfPlayers = pl.getPlayers().size();
        for (int i = 0; i < noOfPlayers; i++) {
            int temp = i;
            playerList.add(pl.getPlayers().get(i));
            for (int j = 0; j < 3; j++) {
                cardList.add(getRandCardsList().get(temp));
                temp += noOfPlayers;
            }
        }
        int c = 0;
        for (int i = 0; i < pl.getPlayers().size(); i++) {
            finalList.put(pl.getPlayers().get(i), Arrays.asList(cardList.get(c++), cardList.get(c++), cardList.get(c++)));
        }
        System.out.println(finalList);
    }

    public int cardValue(String cardVal) {
        int c = 0;
        for (Cards cards : Cards.values()) {
            String cardName = cards.getCardName();
            if (cardName.equals(cardVal)) {
                c = cards.getValue();
                break;
            }
        }
        return c;
    }

    public void findPlayersCard() {
        int k = 0;
        int cardSequences[] = new int[3];
        String cardsInHand;
        String reason;

        for (int j = 0; j < finalList.size(); j++) {
            String player = pl.getPlayers().get(j);
            List<String> playerCards = finalList.get(pl.getPlayers().get(j));

            cardsInHand = finalList.get(player).toString();
            String first = playerCards.get(0);
            String second = playerCards.get(1);
            String third = playerCards.get(2);

            String cardSymbol1 = first.substring(0, 1);
            String cardSymbol2 = second.substring(0, 1);
            String cardSymbol3 = third.substring(0, 1);

            String cardNumber1 = first.substring(1);
            String cardNumber2 = second.substring(1);
            String cardNumber3 = third.substring(1);

            cardSequences[0] = cardValue(cardNumber1);
            cardSequences[1] = cardValue(cardNumber2);
            cardSequences[2] = cardValue(cardNumber3);

            Arrays.sort(cardSequences);

            if (cardSequences[2] == 14 && cardSequences[0] == 2 && cardSequences[1] == 3) {
                cardSequences[0] = 1;
                cardSequences[1] = 2;
                cardSequences[2] = 3;
            }
            int total = 0;
            int score = 0;

            // Games Rules
            // 1. For Trio
            if (cardNumber1.equals(cardNumber2) && cardNumber2.equals(cardNumber3)) { //For Triple
                total = total + 5000000;
                score = calculatePriority(cardSequences, total, score);
                reason = "Trio";
                System.out.println("Reason : " + reason);
            }
            // 2. Sequence cases
            else if (cardSequences[0] + 1 == cardSequences[1] && cardSequences[0] + 2 == cardSequences[2]) { //For Sequence
                total = total + 3000000;
                if (cardSequences[0] == 1 && cardSequences[1] == 2 && cardSequences[2] == 3) {
                    cardSequences[0] = 2;
                    cardSequences[1] = 3;
                    cardSequences[2] = 14;
                }
                // 3. Straight Run
                boolean isStraightRun = false;
                reason = "";
                if (cardSymbol1.equals(cardSymbol2) && cardSymbol2.equals(cardSymbol3) && cardSymbol3.equals(cardSymbol1)) {
                    total = total + 2500000;
                    score = calculatePriority(cardSequences, total, score);
                    reason = "Straight Run";
                    isStraightRun = true;
                    System.out.println("Reason : " + reason);
                }
                // 4. Normal run
                score = calculatePriority(cardSequences, total, score);
                if (!isStraightRun)
                    reason = "Normal Run";
                System.out.println("Reason : " + reason);
            }
            // 5. Colour
            else if (cardSymbol1.equals(cardSymbol2) && cardSymbol2.equals(cardSymbol3) && cardSymbol3.equals(cardSymbol1)) { // For Color
                total = total + 1000000;
                score = calculatePriority(cardSequences, total, score);
                reason = "Colour";
                System.out.println("Reason : " + reason);
            }
            // 6. Pair
            else if (cardNumber1.equals(cardNumber2) || cardNumber2.equals(cardNumber3) || cardNumber3.equals(cardNumber1)) {
                total = total + 500000;
                k = cardSequences[1];
                for (int i = 1; i <= 14; i++) {
                    if (k == i) {
                        score = total + cardSequences[0] + cardSequences[1] + cardSequences[2] + (k * k * k);
                        break;
                    }
                }
                reason = "Pair";
                System.out.println("Reason : " + reason);
            }
            // 7. High card
            else {
                score = calculatePriority(cardSequences, total, score);
                reason = "High card";
                System.out.println("Reason : " + reason);
            }
            System.out.println("Player Name: " + pl.getPlayers().get(j));
            System.out.println("Score : " + score);
            System.out.println("=========================================");
            result.add(new Game(pl.getPlayers().get(j), reason, score, cardsInHand));
        }

    }

    public int calculatePriority(int seq[], int total, int sum) {
        int minSeq = 2;
        int maxSeq = 14;
        int[] seqValues = {600, 800, 1000, 2000, 4000, 6000, 8000, 10000, 20000, 40000, 60000, 80000, 100000};
        total = total + seq[0] + seq[1] + seq[2];

        for (int i = minSeq; i <= maxSeq; i++) {
            if (seq[2] == i) {
                total += seqValues[i - minSeq];
                break;
            }
        }
        return total;
    }

    public void showWinner() {
        result.sort(Comparator.comparing(g -> g.getScore()));
        Collections.reverse(result);
        Game winner = result.get(0);
        System.out.println();
        System.out.println("Winner Player");
        System.out.println("===========================================");
        System.out.println("Player Name : " + winner.getWinnerName());
        System.out.println("Winning Reason : " + winner.getReason());
        System.out.println("Player Score : " + winner.getScore());
        System.out.println("Cards : " + winner.getCards());
    }

    public void findWinner() {
        findPlayersCard();
        showWinner();
    }
}
