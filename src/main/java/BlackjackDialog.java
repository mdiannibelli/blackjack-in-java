package src.main.java;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlackjackDialog {
    public static void showStartMsg() {
        // Image
        ImageIcon blackjackStart = new ImageIcon(Blackjack.class.getResource("/src/main/resources/blackjack-game.png"));

        // JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Order in column

        // Label for image
        JLabel blackjackStartLabelImg = new JLabel(blackjackStart);
        blackjackStartLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT); // Img center

        // Label for text
        JLabel blackjackStartLabelText = new JLabel("The game has begun");
        blackjackStartLabelText.setAlignmentX(Component.CENTER_ALIGNMENT); // Text Center

        // Label font & size
        blackjackStartLabelText.setFont(new Font("Arial", Font.BOLD, 18));

        // Add image & label to JPanel
        panel.add(blackjackStartLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between img & label
        panel.add(blackjackStartLabelText);

        JOptionPane.showMessageDialog(null, panel, "Blackjack", JOptionPane.PLAIN_MESSAGE);
    }

    public static void showGiveUserCardsMsg() {
        ImageIcon giveUserCard = new ImageIcon(Blackjack.class.getResource("/src/main/resources/user-cards.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Order in column

        JLabel giveUserCardImg = new JLabel(giveUserCard);
        giveUserCardImg.setAlignmentX(Component.CENTER_ALIGNMENT); // Img center

        JLabel giveUserCardText = new JLabel("Dealing user's cards...");
        giveUserCardText.setAlignmentX(Component.CENTER_ALIGNMENT); // Text Center

        giveUserCardText.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(giveUserCardImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between img & label
        panel.add(giveUserCardText);

        JOptionPane.showMessageDialog(null, panel, "User cards", JOptionPane.PLAIN_MESSAGE);
    }

    public static void showGiveCrupierCardsMsg() {
        ImageIcon giveCrupierCard = new ImageIcon(Blackjack.class.getResource("/src/main/resources/crupier-cards.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Order in column

        JLabel giveCrupierCardImg = new JLabel(giveCrupierCard);
        giveCrupierCardImg.setAlignmentX(Component.CENTER_ALIGNMENT); // Img center

        JLabel giveCrupierCardText = new JLabel("Dealing crupier's cards...");
        giveCrupierCardText.setAlignmentX(Component.CENTER_ALIGNMENT); // Text Center

        giveCrupierCardText.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(giveCrupierCardImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between img & label
        panel.add(giveCrupierCardText);

        JOptionPane.showMessageDialog(null, panel, "Crupier cards", JOptionPane.PLAIN_MESSAGE);
    }

    public static int showUserOptions(String msg) {
        ImageIcon optionImg = new ImageIcon(Blackjack.class.getResource("/src/main/resources/request-stand.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel optionLabelImg = new JLabel(optionImg);
        optionLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel optionLabelText = new JLabel("Make your decision");
        optionLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel optionLabelSubText = new JLabel(msg);
        optionLabelSubText.setAlignmentX(Component.CENTER_ALIGNMENT);

        optionLabelText.setFont(new Font("Arial", Font.BOLD, 18));
        optionLabelSubText.setFont(new Font("Arial", Font.ITALIC, 14));

        panel.add(optionLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(optionLabelText);
        panel.add(optionLabelSubText);

        String options[] = { "HIT", "STAND" };
        var selection = JOptionPane.showOptionDialog(
                null,
                panel,
                "Phase 3",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[1]);

        return selection;
    }

    public static void showCard(String route, String msg) {
        ImageIcon cardImg = new ImageIcon(Blackjack.class.getResource("/src/main/resources/cards/" + route + ".png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cardLabelImage = new JLabel(cardImg);
        cardLabelImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cardLabelText = new JLabel(msg);
        cardLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        cardLabelText.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(cardLabelImage);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(cardLabelText);

        JOptionPane.showMessageDialog(null, panel, "Card",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void showUserLose(String msg) {
        ImageIcon userOver21Img = new ImageIcon(Blackjack.class.getResource("/src/main/resources/user-lose.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel userOver21LabelImg = new JLabel(userOver21Img);
        userOver21LabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userOver21LabelText = new JLabel(msg);
        userOver21LabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        userOver21LabelText.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(userOver21LabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(userOver21LabelText);

        JOptionPane.showMessageDialog(null, panel, "Game Over",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void showDraw(String msg) {
        ImageIcon drawImg = new ImageIcon(Blackjack.class.getResource("/src/main/resources/draw.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel drawLabelImg = new JLabel(drawImg);
        drawLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel drawLabelText = new JLabel(msg);
        drawLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        drawLabelText.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(drawLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(drawLabelText);

        JOptionPane.showMessageDialog(null, panel, "Game Over",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void showUserWin(String msg) {
        ImageIcon userWinImg = new ImageIcon(Blackjack.class.getResource("/src/main/resources/user-win.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel userWinLabelImg = new JLabel(userWinImg);
        userWinLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userWinLabelText = new JLabel(msg);
        userWinLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        userWinLabelText.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(userWinLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(userWinLabelText);

        JOptionPane.showMessageDialog(null, panel, "Game Over",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void showBlackjack(String msg) {
        ImageIcon blackjackImg = new ImageIcon(Blackjack.class.getResource("/src/main/resources/blackjack.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel blackjackLabelImg = new JLabel(blackjackImg);
        blackjackLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel blackjackLabelText = new JLabel(msg);
        blackjackLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        blackjackLabelText.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(blackjackLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(blackjackLabelText);

        JOptionPane.showMessageDialog(null, panel, "Blackjack",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void userCardsAddUp(String msg) {
        ImageIcon userCardsAddUpImg = new ImageIcon(
                Blackjack.class.getResource("/src/main/resources/user-cards-addup.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel userCardsAddUpLabelImg = new JLabel(userCardsAddUpImg);
        userCardsAddUpLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userCardsAddUpLabelText = new JLabel(msg);
        userCardsAddUpLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        userCardsAddUpLabelText.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(userCardsAddUpLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(userCardsAddUpLabelText);

        JOptionPane.showMessageDialog(null, panel, "User cards add up",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void crupierCardsAddUp(String msg) {
        ImageIcon crupierCardsAddUpImg = new ImageIcon(
                Blackjack.class.getResource("/src/main/resources/crupier-cards-addup.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel crupierCardsAddUpLabelImg = new JLabel(crupierCardsAddUpImg);
        crupierCardsAddUpLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel crupierCardsAddUpLabelText = new JLabel(msg);
        crupierCardsAddUpLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        crupierCardsAddUpLabelText.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(crupierCardsAddUpLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(crupierCardsAddUpLabelText);

        JOptionPane.showMessageDialog(null, panel, "Crupier cards add up",
                JOptionPane.PLAIN_MESSAGE);
    }
}
