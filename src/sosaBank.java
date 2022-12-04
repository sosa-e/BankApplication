import javax.swing.*;


public class sosaBank {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        // JOptionPane.showInputDialog("Please enter your username: ");
        String userName = JOptionPane.showInputDialog("Please enter a username: ");
        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please type a valid username", "alert", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(f, "Welcome to sosaBank " + userName + "!");
        }
        String userPassword = JOptionPane.showInputDialog("Please enter an eight character password: ");
        if (userPassword.length() <= 7) {
            JOptionPane.showMessageDialog(null, "Please type a valid password", "alert", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(f, "Successful Password!");
        }
        Account user = new Account(userName, "000001", userPassword);
        user.showMenu();
    }
}