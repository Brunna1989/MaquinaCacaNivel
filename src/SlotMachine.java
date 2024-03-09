import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlotMachine extends JFrame {
    private JLabel n1;
    private JLabel n2;
    private JLabel n3;
    private int credit = 0;

    public SlotMachine() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 90, 556, 577);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        n1 = new JLabel("0");
        n1.setBounds(55, 230, 150, 200);
        n1.setFont(new Font("Calibri", Font.BOLD, 200));
        panel.add(n1);

        n2 = new JLabel("0");
        n2.setBounds(230, 230, 150, 200);
        n2.setFont(new Font("Calibri", Font.BOLD, 200));
        panel.add(n2);

        n3 = new JLabel("0");
        n3.setBounds(405, 230, 150, 200);
        n3.setFont(new Font("Calibri", Font.BOLD, 200));
        panel.add(n3);

        JButton btnAddMoney = new JButton("Add Money (R$10)");
        btnAddMoney.setBounds(20, 10, 200, 30);
        panel.add(btnAddMoney);

        JButton btnPlay = new JButton("PLAY (R$1)");
        btnPlay.setBounds(145, 455, 250, 65);
        btnPlay.setFont(new Font("Calibri", Font.BOLD, 50));
        btnPlay.setBackground(Color.WHITE);
        panel.add(btnPlay);

        JButton btnEnd = new JButton("End Game");
        btnEnd.setBounds(20, 50, 150, 30);
        panel.add(btnEnd);

        JLabel lblCredit = new JLabel("Credit: R$ " + credit);
        lblCredit.setBounds(400, 10, 150, 30);
        panel.add(lblCredit);

        btnAddMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                credit += 10;
                lblCredit.setText("Credit: R$ " + credit);
            }
        });

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (credit >= 1) {
                    play();
                    credit -= 1;
                    lblCredit.setText("Credit: R$ " + credit);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient credit. Add money to play.");
                }
            }
        });

        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Game ended. You have R$" + credit + " remaining.");
                System.exit(0);
            }
        });
    }

    private void play() {
        Random random = new Random();
        int result1 = random.nextInt(7);
        int result2 = random.nextInt(7);
        int result3 = random.nextInt(7);

        n1.setText(String.valueOf(result1));
        n2.setText(String.valueOf(result2));
        n3.setText(String.valueOf(result3));

        int result = Integer.parseInt(n1.getText() + n2.getText() + n3.getText());

        switch (result) {
            case 111:
                credit += 11;
                break;
            case 222:
                credit += 12;
                break;
            case 333:
                credit += 13;
                break;
            case 000:
                credit += 20;
                break;
            case 777:
                credit += 100;
                break;
            default:
                // Do nothing for other results
                break;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SlotMachine frame = new SlotMachine();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}