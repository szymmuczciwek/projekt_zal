import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class TypingPractice extends JFrame {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> sentences = new ArrayList<>();
    private JTextArea displayArea;
    private JTextField inputField;
    private JLabel resultLabel;
    private JLabel timeLabel;
    private long startTime;
    private String currentSentence;
    private boolean isFirstKey = true;

    public TypingPractice() {
        setTitle("Ćwiczenie pisania na klawiaturze.");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane);

        inputField = new JPasswordField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });
        inputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (isFirstKey) {
                    startTime = System.currentTimeMillis();
                    isFirstKey = false;
                }
            }
        });
        add(inputField);

        resultLabel = new JLabel("");
        add(resultLabel);

        timeLabel = new JLabel("");
        add(timeLabel);

        loadSentences("sentences.txt");
        showSentences();
        selectRandomSentence();
    }

    private void loadSentences(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sentences.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSentences() {
        for (String sentence : sentences) {
            displayArea.append(sentence + "\n");
        }
    }

    private void selectRandomSentence() {
        Random rand = new Random();
        int index = rand.nextInt(sentences.size());
        currentSentence = sentences.get(index);
        highlightSentence(index);
        JOptionPane.showMessageDialog(this, "Proszę wpisać wyróżnione zdanie: ");
    }

    private void highlightSentence(int index) {
        Highlighter highlighter = displayArea.getHighlighter();
        highlighter.removeAllHighlights();
        int start = 0;
        for (int i = 0; i < index; i++) {
            start += sentences.get(i).length() + 1;
        }
        int end = start + sentences.get(index).length();
        try {
            highlighter.addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void processInput() {
        String userInput = inputField.getText();
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        resultLabel.setText("");
        timeLabel.setText("");

        if (userInput.equals(currentSentence)) {
            resultLabel.setText("Prawidłowo!");
            timeLabel.setText("Czas: " + timeElapsed / 1000.0 + " sekdund");
        } else {
            highlightErrors(userInput);
        }

        int retry = JOptionPane.showConfirmDialog(this, "Chcesz spróbować ponownie?", "Powtórz", JOptionPane.YES_NO_OPTION);
        if (retry == JOptionPane.YES_OPTION) {
            isFirstKey = true;
            inputField.setText("");
            selectRandomSentence();
        } else {
            System.exit(0);
        }
    }

    private void highlightErrors(String userInput) {
        StringBuilder result = new StringBuilder("<html>");
        int length = Math.min(currentSentence.length(), userInput.length());
        int errors = 0;

        for (int i = 0; i < length; i++) {
            if (currentSentence.charAt(i) == userInput.charAt(i)) {
                result.append(userInput.charAt(i));
            } else {
                result.append("<font color='red'>").append(userInput.charAt(i)).append("</font>");
                errors++;
            }
        }

        if (userInput.length() > length) {
            result.append("<font color='red'>").append(userInput.substring(length)).append("</font>");
            errors += userInput.length() - length;
        }

        result.append("</html>");
        resultLabel.setText(result.toString());

        double errorPercentage = (double) errors / currentSentence.length() * 100;
        timeLabel.setText("Errors: " + errors + " (" + String.format("%.2f", errorPercentage) + "%)");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TypingPractice().setVisible(true);
            }
        });
    }
}
