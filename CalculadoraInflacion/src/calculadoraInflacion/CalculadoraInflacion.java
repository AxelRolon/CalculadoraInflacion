package calculadoraInflacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculadoraInflacion extends JFrame implements ActionListener {
    private JTextField montoOriginalField, tasaInflacionField, anosField, resultadoField;
    private JComboBox<String> monedaComboBox;

    public CalculadoraInflacion() {
        setTitle("Calculadora de Inflación");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel montoOriginalLabel = new JLabel("Monto Original:");
        montoOriginalField = new JTextField(10);

        JLabel tasaInflacionLabel = new JLabel("Tasa de Inflación (%):");
        tasaInflacionField = new JTextField(10);

        JLabel anosLabel = new JLabel("Número de Años:");
        anosField = new JTextField(10);

        JLabel monedaLabel = new JLabel("Moneda:");
        String[] monedas = {"Dólares", "Euros"};
        monedaComboBox = new JComboBox<>(monedas);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);

        JLabel resultadoLabel = new JLabel("Valor Futuro:");
        resultadoField = new JTextField(10);
        resultadoField.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(montoOriginalLabel, gbc);

        gbc.gridx = 1;
        panel.add(montoOriginalField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(tasaInflacionLabel, gbc);

        gbc.gridx = 1;
        panel.add(tasaInflacionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(anosLabel, gbc);

        gbc.gridx = 1;
        panel.add(anosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(monedaLabel, gbc);

        gbc.gridx = 1;
        panel.add(monedaComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(calcularButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(resultadoLabel, gbc);

        gbc.gridx = 1;
        panel.add(resultadoField, gbc);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double montoOriginal = Double.parseDouble(montoOriginalField.getText());
            double tasaInflacion = Double.parseDouble(tasaInflacionField.getText()) / 100.0;
            int anos = Integer.parseInt(anosField.getText());

            double valorFuturo = montoOriginal * Math.pow(1 + tasaInflacion, anos);
            DecimalFormat df = new DecimalFormat("#.##");
            String resultado = df.format(valorFuturo);

            if (monedaComboBox.getSelectedItem().equals("Euros")) {
                resultado = resultado + " Euros";
            } else {
                resultado = resultado + " Dólares";
            }

            resultadoField.setText(resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos.");
        }
    }
}