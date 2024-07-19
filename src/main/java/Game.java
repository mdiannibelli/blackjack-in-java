package src.main.java;

import java.util.List;

public class Game {
    public static int BlackjackGame(int userMoney, int userBet) {

        // All BJ Cards
        List<String> cards = CardsUtils.createDeck();

        int userCardsValue1 = 0;
        int userCardsValue2 = 0;

        int crupierCardsValue1 = 0;
        int crupierCardsValue2 = 0;

        String userMsg = "";
        String crupierMsg = "";

        boolean winner = false;

        // Start game
        BlackjackDialog.showStartMsg();

        BlackjackDialog.showGiveUserCardsMsg();
        System.out.println("Dealing user's cards...");
        // Declare userCards array
        String[] userCards = CardsUtils.generateRandomCards(cards, 2);
        boolean hasUserA = false;
        Object[] userResult = CardsUtils.showUserCardsValue(userCards, userCardsValue1, userCardsValue2, hasUserA);
        hasUserA = (boolean) userResult[3];
        userMsg = (String) userResult[0];
        userCardsValue1 += (int) userResult[1];
        userCardsValue2 += (int) userResult[2];

        // Check if user has Blackjack
        Object[] checkBj = CardsUtils.checkBlackjack(userCardsValue1, userCardsValue2, crupierCardsValue1,
                crupierCardsValue2,
                userMoney, userBet);
        boolean isBlackjack = (boolean) checkBj[0];
        int userMoneyWithBlackjack = (int) checkBj[1];
        if (isBlackjack)
            return userMoneyWithBlackjack;

        BlackjackDialog.showGiveCrupierCardsMsg();
        System.out.println("Dealing crupier's cards...");
        // Declare crupierCards array
        String[] crupierCards = CardsUtils.generateRandomCards(cards, 1);
        boolean hasCrupierA = false;
        Object[] crupierResult = CardsUtils.showCrupierCardsValue(crupierCards, crupierCardsValue1, crupierCardsValue2,
                hasCrupierA);
        hasCrupierA = (boolean) crupierResult[3];
        crupierMsg = (String) crupierResult[0];
        crupierCardsValue1 += (int) crupierResult[1];
        crupierCardsValue2 += (int) crupierResult[2];

        int selection = BlackjackDialog.showUserOptions(userMsg + " & " + crupierMsg);

        if (selection == 0) {
            // Generate user card;

            BlackjackDialog.showGiveUserCardsMsg();
            do {
                System.out.println("Dealing user's cards...");
                userCards = CardsUtils.generateRandomCards(cards, 1);
                Object[] userNewCard = CardsUtils.showUserCardsValue(userCards, userCardsValue1, userCardsValue2,
                        hasUserA);
                userCardsValue1 = (int) userNewCard[1];
                userCardsValue2 = (int) userNewCard[2];
                userMsg = (String) userNewCard[0];
                hasUserA = (boolean) userNewCard[3];

                // Show option again
                if (userCardsValue1 < 21 | userCardsValue2 < 21) {
                    var requestAnotherCard = BlackjackDialog
                            .showUserOptions(userMsg + " & " + crupierMsg);
                    if (requestAnotherCard == 1) {
                        int restMoney = CardsUtils.generateCrupierCards(crupierCards, crupierCardsValue1,
                                crupierCardsValue2,
                                hasCrupierA, winner,
                                userCardsValue1, userCardsValue2, cards, userMoney, userBet);
                        userMoney = restMoney;
                        break;
                    }
                }
            } while (userCardsValue1 < 21 || userCardsValue2 < 21);

            if (userCardsValue1 >= 21 && userCardsValue2 >= 21) {
                int restMoney = CardsUtils.generateCrupierCards(crupierCards, crupierCardsValue1, crupierCardsValue2,
                        hasCrupierA, winner,
                        userCardsValue1, userCardsValue2, cards, userMoney, userBet);
                userMoney = restMoney;
            }
        }

        if (selection == 1) {
            // Generate crupier card;
            int restMoney = CardsUtils.generateCrupierCards(crupierCards, crupierCardsValue1, crupierCardsValue2,
                    hasCrupierA, winner,
                    userCardsValue1, userCardsValue2, cards, userMoney, userBet);
            userMoney = restMoney;
        }
        return userMoney;
    }
}
