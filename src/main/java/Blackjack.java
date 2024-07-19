package src.main.java;

public class Blackjack {
    public static void main(String[] args) {
        GameDialog.welcomeMsg();
        Object[] result = GameDialog.enterUserName();
        boolean isOk = (boolean) result[0];
        String userName = (String) result[1];
        if (!isOk) {
            return;
        } else {
            GameDialog.welcomeUserName(userName);
            System.out.println("Welcome " + userName + "!");
        }

        // Make Bet, the min is $100
        int userMoney = 1000;
        int userBet = 0;
        while (userBet == 0) {
            if (userMoney < 100) {
                GameDialog.noMoreMoneyMsg();
                System.out.println("No more money!!");
                return;
            }
            userBet = GameDialog.enterBet(userMoney);
            if (userBet >= 100) {
                int restMoney = Game.BlackjackGame(userMoney, userBet);
                System.out.println(restMoney);
                userMoney = restMoney;
                userBet = 0;
            }
        }

    }

}