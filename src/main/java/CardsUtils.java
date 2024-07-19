package src.main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsUtils {
    public static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        String nums[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        String suits[] = { "Heart", "Sword", "Clover", "Diamond" };
        for (String suit : suits) {
            for (String num : nums) {
                deck.add(num + "-" + suit);
            }
        }
        Collections.shuffle(deck); // Shuffle the deck
        return deck;
    }

    public static String[] generateRandomCards(List<String> deck, int quantity) {
        // Give the cards to the person (user or crupier)
        String newCards[] = new String[quantity];
        for (int i = 0; i < quantity; i++) {
            if (deck.isEmpty()) {
                throw new IllegalStateException("No more cards in deck");
            }
            String card = deck.remove(0); // Remove and get the card
            newCards[i] = card;
            String msg = card.split("-")[0] + " of " + card.split("-")[1];
            System.out.println("Card: " + msg);
            String route = card;
            BlackjackDialog.showCard(route, msg);
        }
        return newCards;
    }

    public static Object[] showUserCardsValue(String userCards[], int personValue1, int personValue2, boolean hasA) {
        // Show user cards value
        // boolean hasA = false;
        for (int i = 0; i < userCards.length; i++) {
            if (userCards[i] == null)
                break;
            String card = userCards[i].split("-")[0];
            if (card.equals("K") || card.equals("J") || card.equals("Q")) {
                personValue2 += 10;
                personValue1 += 10;
            } else if (card.equals("A")) {
                personValue2 += 1;
                personValue1 += 11;
                hasA = true;
            } else {
                personValue1 += Integer.parseInt(card);
                personValue2 += Integer.parseInt(card);
            }
        }

        String userMsg;
        if (hasA && personValue1 != 21) {
            userMsg = "Your cards add up " + Integer.toString(personValue1) + "/" + Integer.toString(personValue2);
            BlackjackDialog.userCardsAddUp(userMsg);
        } else {
            userMsg = "Your cards add up " + personValue1;
            BlackjackDialog.userCardsAddUp(userMsg);
        }
        return new Object[] { userMsg, personValue1, personValue2, hasA };
    }

    public static Object[] showCrupierCardsValue(String crupierCards[], int personValue1, int personValue2,
            boolean hasA) {
        // Show crupier cards value
        // boolean hasA = false;
        for (int i = 0; i < crupierCards.length; i++) {
            if (crupierCards[i] == null)
                break;
            String card = crupierCards[i].split("-")[0];
            if (card.equals("K") || card.equals("J") || card.equals("Q")) {
                personValue1 += 10;
                personValue2 += 10;
            } else if (card.equals("A")) {
                personValue2 += 1;
                personValue1 += 11;
                hasA = true;
            } else {
                personValue1 += Integer.parseInt(card);
                personValue2 += Integer.parseInt(card);
            }

        }

        String crupierMsg;
        if (hasA && personValue1 != 21) {
            crupierMsg = "Crupier cards add up " + Integer.toString(personValue1) + "/"
                    + Integer.toString(personValue2);
            BlackjackDialog.crupierCardsAddUp(crupierMsg);
        } else {
            crupierMsg = "Crupier cards add up " + personValue1;
            BlackjackDialog.crupierCardsAddUp(crupierMsg);
        }
        return new Object[] { crupierMsg, personValue1, personValue2, hasA };
    }

    public static Object[] checkBlackjack(int userCardsValue, int userCardsValue2, int crupierCardsValue,
            int crupierCardsValue2, int userMoney, int userBet) {
        boolean isBlackjack = false;
        if (userCardsValue == 21 || userCardsValue2 == 21 || crupierCardsValue == 21 || crupierCardsValue2 == 21) {
            isBlackjack = true;
        }

        if (isBlackjack) {
            if (userCardsValue == 21 || userCardsValue2 == 21) {
                BlackjackDialog.showBlackjack("You have a Blackjack!");
                BlackjackDialog.showUserWin("You won.");
                System.out.println("Blackjack!, You win.");
                userMoney = userMoney + userBet + (int) Math.floor(userBet * 1.5);
                return new Object[] { true, userMoney };
            }
        }
        return new Object[] { false, userMoney };
    }

    public static int showWinner(int crupierCardsValue1, int crupierCardsValue2, int userCardsValue1,
            int userCardsValue2, int userMoney, int userBet) {
        boolean crupierIsOver21 = crupierCardsValue1 > 21 && crupierCardsValue2 > 21;
        boolean userIsOver21 = userCardsValue1 > 21 && userCardsValue2 > 21;
        if (crupierIsOver21 && userIsOver21) {
            BlackjackDialog.showDraw("Both crupier and user are over 21, it's a draw!");
            System.out.println("Both crupier and user are over 21, it's a draw!");
            return userMoney;
        } else if (crupierIsOver21) {
            BlackjackDialog.showUserWin("Crupier is over 21, user win!");
            System.out.println("Crupier is over 21, user won!");
            userMoney = userMoney + userBet;
            return userMoney;
        } else if (userIsOver21) {
            BlackjackDialog.showUserLose("User is over 21, Crupier win!");
            System.out.println("Crupier won!");
            userMoney = userMoney - userBet;
            return userMoney;
        }

        int crupierBestValue = crupierCardsValue1 > 21 ? crupierCardsValue2
                : Math.max(crupierCardsValue1, crupierCardsValue2);

        int userBestValue = userCardsValue1 > 21 ? userCardsValue2 : Math.max(userCardsValue1, userCardsValue2);

        if (crupierBestValue == userBestValue) {
            BlackjackDialog.showDraw("It's a draw!");
            System.out.println("Draw!");
            return userMoney;
        } else if (crupierBestValue > userBestValue) {
            BlackjackDialog.showUserLose("Crupier won!");
            System.out.println("Crupier won!");
            userMoney = userMoney - userBet;
            return userMoney;
        } else {
            BlackjackDialog.showUserWin("User won!");
            System.out.println("User won!");
            userMoney = userMoney + userBet;
            return userMoney;
        }
    }

    public static int generateCrupierCards(String crupierCards[], int crupierCardsValue1, int crupierCardsValue2,
            boolean hasCrupierA, boolean winner, int userCardsValue1, int userCardsValue2, List<String> cards,
            int userMoney, int userBet) {
        // Generate crupier card;
        BlackjackDialog.showGiveCrupierCardsMsg();
        do {
            System.out.println("Dealing crupier's cards...");
            crupierCards = generateRandomCards(cards, 1);
            Object[] crupierNewCard = showCrupierCardsValue(crupierCards, crupierCardsValue1,
                    crupierCardsValue2,
                    hasCrupierA);
            crupierCardsValue1 = (int) crupierNewCard[1];
            crupierCardsValue2 = (int) crupierNewCard[2];
            hasCrupierA = (boolean) crupierNewCard[3];

            // 11/21 => break... 17/27 break;
            if (crupierCardsValue2 >= 17 && crupierCardsValue2 <= 21) {
                break;
            }

            // >= 21 => break;
            if (crupierCardsValue1 >= 17) {
                break;
            }
        } while (true);

        // Show Winner
        int restMoney = showWinner(crupierCardsValue1, crupierCardsValue2, userCardsValue1, userCardsValue2, userMoney,
                userBet);
        return restMoney;
    }
}
