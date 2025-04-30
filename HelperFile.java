import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Stack;

public class HelperFile extends JFrame {
    private LinkedList<String> sharedChatHistory;
    private Stack<String> undoStack;          

    private JTextArea chatDisplay;              
    private JTextField inputField;              
    private JButton sendButton, undoButton, searchButton, historyButton, themeButton;

    private boolean isDarkTheme = false;      
    private boolean isFirstFrame;              

    public HelperFile(LinkedList<String> sharedChatHistory, boolean isFirstFrame) {
        this.sharedChatHistory = sharedChatHistory;
        this.undoStack = new Stack<>();
        this.isFirstFrame = isFirstFrame;  
        setTitle("ChatBox GUI");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatDisplay = new JTextArea();
        chatDisplay.setEditable(false);
        chatDisplay.setLineWrap(true);
        chatDisplay.setWrapStyleWord(true);

        if (isFirstFrame) {
            chatDisplay.setMargin(new Insets(10, 100, 10, 10)); 
        } else {
            chatDisplay.setMargin(new Insets(10, 10, 10, 100)); 
        }
        
        chatDisplay.setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(chatDisplay);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        inputField.setMargin(new Insets(10, 20, 10, 10));
        inputField.setFont(new Font("Arial", Font.BOLD, 14));
        
        sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        undoButton = new JButton("Undo");
        searchButton = new JButton("Search");
        historyButton = new JButton("History");
        themeButton = new JButton("Toggle Theme");
        buttonPanel.add(undoButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(themeButton);
        add(buttonPanel, BorderLayout.NORTH);

 
        sendButton.addActionListener(e -> sendMessage());
        undoButton.addActionListener(e -> undoLastMessage());
        searchButton.addActionListener(e -> searchMessages());
        historyButton.addActionListener(e -> displayChatHistory());
        themeButton.addActionListener(e -> toggleTheme());

        applyTheme();
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            synchronized (sharedChatHistory) {
                sharedChatHistory.add(message);
                undoStack.push(message);
            }
            updateChatDisplay();
            inputField.setText("");
        }
    }

    private void undoLastMessage() {
        synchronized (sharedChatHistory) {
            if (!undoStack.isEmpty()) {
                String lastMessage = undoStack.pop();
                sharedChatHistory.remove(lastMessage);

                updateChatDisplay();
                chatDisplay.append("This message was deleted\n");
            } else {
                JOptionPane.showMessageDialog(this, "No your text to Undo.", "Undo Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void searchMessages() {
        String keyword = JOptionPane.showInputDialog(this, "Enter keyword to search:");

        if (keyword != null && !keyword.isEmpty()) {
            JTextArea searchResult = new JTextArea();
            searchResult.append("Search results for \"" + keyword + "\":\n");
            boolean found = false;

            synchronized (sharedChatHistory) {
                for (String message : sharedChatHistory) {
                    if (message.contains(keyword)) {
                        searchResult.append(message + "\n");
                        found = true;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No messages found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JScrollPane scrollPane = new JScrollPane(searchResult);
                searchResult.setEditable(false);
                JOptionPane.showMessageDialog(this, scrollPane, "Search Results", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No keyword entered.", "Search Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void displayChatHistory() {
        JTextArea historyDisplay = new JTextArea();
        historyDisplay.append("Chat History:\n");

        synchronized (sharedChatHistory) {
            for (String message : sharedChatHistory) {
                historyDisplay.append(message + "\n");
            }
        }

        JScrollPane scrollPane = new JScrollPane(historyDisplay);
        historyDisplay.setEditable(false);
        JOptionPane.showMessageDialog(this, scrollPane, "History", JOptionPane.INFORMATION_MESSAGE);
    }

    private void toggleTheme() {
        isDarkTheme = !isDarkTheme;
        applyTheme();
    }

    private void applyTheme() {
        if (isDarkTheme) {
            chatDisplay.setBackground(Color.DARK_GRAY);  
            chatDisplay.setForeground(Color.WHITE);      
            inputField.setBackground(Color.GRAY);
            inputField.setForeground(Color.WHITE);
        } else {
            chatDisplay.setBackground(Color.WHITE);     
            chatDisplay.setForeground(Color.BLACK);      
            inputField.setBackground(Color.WHITE);
            inputField.setForeground(Color.BLACK);
        }
    }
    
    public void updateChatDisplay() {
        synchronized (sharedChatHistory) {
            chatDisplay.setText("");
            for (String message : sharedChatHistory) {
                chatDisplay.append(message + "\n\n");
            }
        }
    }
}