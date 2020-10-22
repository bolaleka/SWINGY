package bolaleka.swingy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bolaleka.swingy.controller.DataController;

public class GuiManager {

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, newGameJPanel, selectJPanel, newHeroJPanel, saveButtonPanel,
            arenaTextPanel, loadButtonPanel, statPanel, statUpdatePanel;
    JLabel titleNameLabel, nameLabel, arenaTextLabel;
    JTextField enterHeroName;
    static JTextArea statTextField, statUpdateTextField;
    static List<String> statsData;
    JButton startButton, newGame, continueGame, saveButton, loadButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    Font gameFont = new Font("Times New Roman", Font.PLAIN, 12);
    Font medium = new Font("Times New Roman", Font.PLAIN, 20);


    DataController controller;
    ClickStart start = new ClickStart();
    CreateGameHandler createGame = new CreateGameHandler();

    public GuiManager() {

        window = new JFrame();
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.lightGray);
        window.getContentPane().setLayout(new BorderLayout());
        window.setLayout(null);

        // TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(130, 80, 300, 100);
        titleNamePanel.setBackground(Color.lightGray);

        titleNameLabel = new JLabel("SWINGY");
        titleNameLabel.setForeground(Color.BLUE);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(200, 250, 150, 250);
        startButtonPanel.setBackground(Color.lightGray);
        startButton = new JButton("START");
        startButton.setBackground(Color.lightGray);
        startButton.setForeground(Color.BLUE);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(start);
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        window.setVisible(true);
    }

    public void startGame() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        newGameJPanel = new JPanel();
        newGameJPanel.setBounds(100, 80, 200, 100);
        newGameJPanel.setBackground(Color.lightGray);
        window.add(newGameJPanel);

        newGame = new JButton("Create Hero");
        newGame.setBackground(Color.lightGray);
        newGame.setForeground(Color.BLUE);
        newGame.setFont(gameFont);
        newGame.setFocusPainted(false);
        newGame.addActionListener(createGame);
        newGameJPanel.add(newGame);

        selectJPanel = new JPanel();
        selectJPanel.setBounds(300, 80, 200, 100);
        selectJPanel.setBackground(Color.lightGray);
        window.add(selectJPanel);

        continueGame = new JButton("Select Hero");
        continueGame.setBackground(Color.lightGray);
        continueGame.setForeground(Color.BLUE);
        continueGame.setFont(gameFont);
        continueGame.setFocusPainted(false);
        continueGame.addActionListener(createGame);
        selectJPanel.add(continueGame);

    }

    public void createGame() {
        newGame.setVisible(false);
        continueGame.setVisible(false);

        newHeroJPanel = new JPanel();
        newHeroJPanel.setBounds(100, 100, 300, 100);
        newHeroJPanel.setBackground(Color.lightGray);
        newHeroJPanel.setLayout(new GridLayout(4, 0));
        window.add(newHeroJPanel);

        enterHeroName = new JTextField(20);
        newHeroJPanel.add(enterHeroName);

        saveButtonPanel = new JPanel();
        saveButtonPanel.setBounds(100, 150, 300, 100);
        saveButtonPanel.setBackground(Color.lightGray);
        window.add(saveButtonPanel);

        saveButton = new JButton("SAVE");
        saveButton.setBackground(Color.lightGray);
        saveButton.setForeground(Color.BLUE);
        saveButton.setFont(gameFont);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = enterHeroName.getText();
                if (!textFieldValue.isEmpty() && !textFieldValue.isBlank()) {
                    System.out.println(textFieldValue);
                    try {
                        controller = new DataController(textFieldValue);
                        controller.getStorage().saveUIData(textFieldValue);

                        enterHeroName.setVisible(false);
                        saveButton.setVisible(false);
                        loadUIGame();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(window, "No input typed", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
                    window.setVisible(false);
                    new GuiManager();
                }
            }
        });
        saveButtonPanel.add(saveButton);
    }

    public void loadUIGame() {
        newGame.setVisible(false);
        continueGame.setVisible(false);

        arenaTextPanel = new JPanel();
        arenaTextPanel.setBounds(100, 100, 300, 300);
        arenaTextPanel.setBackground(Color.lightGray);
        window.add(arenaTextPanel);

        arenaTextLabel = new JLabel("Enter your player name:");
        arenaTextLabel.setFont(normalFont);
        arenaTextPanel.add(arenaTextLabel);

        newHeroJPanel = new JPanel();
        newHeroJPanel.setBounds(100, 150, 300, 100);
        newHeroJPanel.setBackground(Color.lightGray);
        newHeroJPanel.setLayout(new GridLayout(4, 0));
        window.add(newHeroJPanel);

        enterHeroName = new JTextField(20);
        newHeroJPanel.add(enterHeroName);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(100, 200, 300, 100);
        loadButtonPanel.setBackground(Color.lightGray);
        window.add(loadButtonPanel);

        loadButton = new JButton("Load Player");
        loadButton.setBackground(Color.lightGray);
        loadButton.setForeground(Color.BLUE);
        loadButton.setFont(gameFont);
        loadButton.setFocusPainted(false);
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = enterHeroName.getText();
                if (!textFieldValue.isEmpty() && !textFieldValue.isBlank()) {
                 
                        enterHeroName.setVisible(false);
                        loadButton.setVisible(false);
                        arenaTextLabel.setVisible(false);

                        try {
                         controller.getModeUI().navigateUI(window, textFieldValue);   
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(window, "No input typed", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
                    window.setVisible(false);
                    new GuiManager();
                }
            }
        });
        loadButtonPanel.add(loadButton);
    }


    public class ClickStart implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
        }

    }
    public class CreateGameHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == newGame) {
                createGame();
            }else if(e.getSource() == continueGame) {
                loadUIGame();
            }
            
        }

    }


}
