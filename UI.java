import java.awt.*;
import javax.swing.*;

public class UI extends JPanel {
    // Declare all your components here
    JLabel title, jLabel1, jLabel2, jLabel3, output, boldText;
    JButton jButton1;
    JTextField input;
    JComboBox<String> choiceFrom, choiceTo;

    private Image backgroundImage;

    public UI() {
        // Initialize components
        title = new JLabel("CoinVersion");
        jButton1 = new JButton("CONVERT");
        jLabel1 = new JLabel("Drop your Money Here");
        jLabel2 = new JLabel("Convert From");
        jLabel3 = new JLabel("Convert To");
        input = new JTextField();
        choiceFrom = new JComboBox<>(new String[] { "INR", "USD", "EUR", "CAD", "JPY", "CNY", "BTC" });
        choiceTo = new JComboBox<>(new String[] { "INR", "USD", "EUR", "CAD", "JPY", "CNY", "BTC" });
        output = new JLabel("", SwingConstants.CENTER);
        boldText = new JLabel("Welcome to the CoinVersion", SwingConstants.CENTER);

        // Load background image
        backgroundImage = new ImageIcon("curr1.jpg").getImage();

        // Frame settings
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);  // Add padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Set fonts for better readability and modern look
        title.setFont(new Font("Poppins", Font.BOLD, 36));
        jLabel1.setFont(new Font("Poppins", Font.PLAIN, 18));
        jLabel2.setFont(new Font("Poppins", Font.PLAIN, 18));
        jLabel3.setFont(new Font("Poppins", Font.PLAIN, 18));
        input.setFont(new Font("Poppins", Font.PLAIN, 18));
        choiceFrom.setFont(new Font("Poppins", Font.PLAIN, 18));
        choiceTo.setFont(new Font("Poppins", Font.PLAIN, 18));
        jButton1.setFont(new Font("Poppins", Font.BOLD, 18));
        output.setFont(new Font("Poppins", Font.BOLD, 24));
        boldText.setFont(new Font("Poppins", Font.BOLD, 32));  // Bold and larger font for welcome text

        // Set colors for the components
        boldText.setForeground(new Color(70, 130, 180));  // Steel blue for a strong yet elegant tone


        // Tooltips for better user interaction
        input.setToolTipText("Enter the amount you want to convert");
        choiceFrom.setToolTipText("Select the currency to convert from");
        choiceTo.setToolTipText("Select the currency to convert to");
        jButton1.setToolTipText("Click to perform the conversion");

        // Title (Centered)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Span across 2 columns
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, gbc);

        // Add the bold text label at the top
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(boldText, gbc);  // Add the bold text label

        // Enter Amount Label and Input Field
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(jLabel1, gbc);
        gbc.gridx = 1;
        input.setPreferredSize(new Dimension(250, 35)); // Make input field bigger
        add(input, gbc);

        // Convert From Label and Dropdown
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(jLabel2, gbc);
        gbc.gridx = 1;
        add(choiceFrom, gbc);

        // Convert To Label and Dropdown
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(jLabel3, gbc);
        gbc.gridx = 1;
        add(choiceTo, gbc);

        // Convert Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(jButton1, gbc);

        // Output Label (Centered)
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        output.setHorizontalAlignment(SwingConstants.CENTER);
        add(output, gbc);

        // Set Background Color and Border for better visibility
        setBackground(new Color(248, 250, 252)); // Light pastel gray for a fresh look
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));  // Padding around the panel

        // Style the button with rounded corners and hover effect
        jButton1.setBackground(new Color(78, 169, 235));  // Soft blue color
        jButton1.setForeground(Color.WHITE);
        jButton1.setFocusPainted(false);
        jButton1.setBorder(BorderFactory.createCompoundBorder(
            jButton1.getBorder(),
            BorderFactory.createLineBorder(new Color(60, 140, 210), 2)
        ));
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Style the input field and combo boxes
        input.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        choiceFrom.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        choiceTo.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));

        // Add some padding for a cleaner look
        input.setPreferredSize(new Dimension(250, 35)); // Adjust the size of the input field
        choiceFrom.setPreferredSize(new Dimension(250, 35));
        choiceTo.setPreferredSize(new Dimension(250, 35));
    }

    // Override paintComponent to draw the background image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Scale the background image to fit the panel size
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Getter methods for components to interact with them from CurrencyConverter
    public JButton getConvertButton() {
        return jButton1;
    }

    public JTextField getInputField() {
        return input;
    }

    public JComboBox<String> getChoiceFrom() {
        return choiceFrom;
    }

    public JComboBox<String> getChoiceTo() {
        return choiceTo;
    }

    public JLabel getOutputLabel() {
        return output;
    }
}
