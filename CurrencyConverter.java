import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("CoinVersion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Initialize UI panel
        UI uiPanel = new UI();

        // Add the UI panel to the frame
        frame.add(uiPanel);

        // Make the frame visible
        frame.setVisible(true);

        // Set action listener for the convert button
        uiPanel.getConvertButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the amount from input field
                String inputText = uiPanel.getInputField().getText();
                try {
                    double amount = Double.parseDouble(inputText);

                    // Get the selected currencies
                    String fromCurrency = uiPanel.getChoiceFrom().getSelectedItem().toString();
                    String toCurrency = uiPanel.getChoiceTo().getSelectedItem().toString();

                    // Perform currency conversion (Example rates, you can replace this with actual conversion logic)
                    double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

                    // Display the result in output label
                    uiPanel.getOutputLabel().setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency));
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    uiPanel.getOutputLabel().setText("Invalid amount. Please enter a valid number.");
                }
            }
        });
    }

    // Dummy conversion logic for demonstration purposes
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double conversionRate = 1.0;

        // Add basic conversion rates here for demonstration
        if (fromCurrency.equals("USD") && toCurrency.equals("INR")) {
            conversionRate = 82.0;  // Example rate
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("INR")) {
            conversionRate = 90.0;  // Example rate
        } else if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
            conversionRate = 0.012;  // Example rate
        }

        return amount * conversionRate;
    }
}
