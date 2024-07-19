package src.main.java;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class GameDialog {
    public static void welcomeMsg() {
        // Image
        ImageIcon blackjackStart = new ImageIcon(Blackjack.class.getResource("/src/main/resources/welcome.jpg"));

        // JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Order in column

        // Label for image
        JLabel blackjackStartLabelImg = new JLabel(blackjackStart);
        blackjackStartLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT); // Img center

        // Label for text
        JLabel blackjackStartLabelText = new JLabel("Welcome to Blackjack");
        blackjackStartLabelText.setAlignmentX(Component.CENTER_ALIGNMENT); // Text Center

        // Label font & size
        blackjackStartLabelText.setFont(new Font("Arial", Font.BOLD, 24));

        // Add image & label to JPanel
        panel.add(blackjackStartLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between img & label
        panel.add(blackjackStartLabelText);

        JOptionPane.showMessageDialog(null, panel, "Blackjack", JOptionPane.PLAIN_MESSAGE);
    }

    public static Object[] enterUserName() {
        ImageIcon optionImg = new ImageIcon(Blackjack.class.getResource("/src/main/resources/enter-name.png"));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Text field
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(180, 30));
        nameField.setMinimumSize(new Dimension(180, 30));
        nameField.setMaximumSize(new Dimension(180, 30));

        JLabel optionLabelImg = new JLabel(optionImg);
        optionLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel optionLabelText = new JLabel("Enter your name");
        optionLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabelText.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(optionLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(optionLabelText);
        panel.add(nameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Name", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            System.out.println("Username: " + name);
            return new Object[] { true, name };
        } else {
            System.out.println("Game canceled.");
            return new Object[] { false, "" };
        }
    }

    public static void welcomeUserName(String userName) {
        ImageIcon blackjackStart = new ImageIcon(
                Blackjack.class.getResource("/src/main/resources/welcome-username.png"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Order in column

        JLabel blackjackStartLabelImg = new JLabel(blackjackStart);
        blackjackStartLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT); // Img center

        JLabel blackjackStartLabelText = new JLabel("Welcome " + userName + "!");
        blackjackStartLabelText.setAlignmentX(Component.CENTER_ALIGNMENT); // Text Center

        blackjackStartLabelText.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(blackjackStartLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between img & label
        panel.add(blackjackStartLabelText);

        JOptionPane.showMessageDialog(null, panel, "Welcome " + userName + "!", JOptionPane.PLAIN_MESSAGE);
    }

    public static int enterBet(int userMoney) {
        ImageIcon optionImg = new ImageIcon(Blackjack.class.getResource("/src/main/resources/enter-bet.png"));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Formatter
        NumberFormat format = NumberFormat.getIntegerInstance(); // Just integer numbers are accepted
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(100);
        formatter.setMaximum(userMoney);
        formatter.setAllowsInvalid(true);
        formatter.setCommitsOnValidEdit(true); // Commit value on each valid edit

        // Formatted Text field
        JFormattedTextField betField = new JFormattedTextField(formatter);
        betField.setPreferredSize(new Dimension(180, 30));
        betField.setMinimumSize(new Dimension(180, 30));
        betField.setMaximumSize(new Dimension(180, 30));

        JLabel optionLabelImg = new JLabel(optionImg);
        optionLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel optionLabelText = new JLabel("Enter the amount of money you want to bet");
        optionLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabelText.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel optionLabelSubText = new JLabel("Your total amount is: " + userMoney + " USD");
        optionLabelSubText.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabelSubText.setFont(new Font("Arial", Font.ITALIC, 12));

        panel.add(optionLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(optionLabelText);
        panel.add(optionLabelSubText);
        panel.add(betField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Bet", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            Object value = betField.getValue();
            if (value != null) {
                int amountBet = (int) value;
                System.out.println("Your amount to bet is: " + amountBet + " USD");
                return amountBet;
            } else {
                System.out.println("No amount was entered, please enter an amount.");
                return 0;
            }
        } else {
            System.out.println("No amount was entered, please enter an amount.");
            return 0;
        }
    }

    public static void noMoreMoneyMsg() {
        // Image
        ImageIcon blackjackStart = new ImageIcon(Blackjack.class.getResource("/src/main/resources/no-more-money.png"));

        // JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Order in column

        // Label for image
        JLabel blackjackStartLabelImg = new JLabel(blackjackStart);
        blackjackStartLabelImg.setAlignmentX(Component.CENTER_ALIGNMENT); // Img center

        // Label for text
        JLabel blackjackStartLabelText = new JLabel("No more money :(");
        blackjackStartLabelText.setAlignmentX(Component.CENTER_ALIGNMENT); // Text Center

        // Label font & size
        blackjackStartLabelText.setFont(new Font("Arial", Font.BOLD, 24));

        // Add image & label to JPanel
        panel.add(blackjackStartLabelImg);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between img & label
        panel.add(blackjackStartLabelText);

        JOptionPane.showMessageDialog(null, panel, "Session Over", JOptionPane.PLAIN_MESSAGE);
    }
}
