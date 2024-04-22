import groovy.lang.GroovyShell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroovyEx {

    private JPanel main;
    private JTextField txtCodigo;
    private JButton btnCalcular;
    private JTextField txtRes;

    public GroovyEx() {
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarCodigo();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GroovyEx");
        frame.setContentPane(new GroovyEx().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void ejecutarCodigo() {
        // Obtener el código ingresado por el usuario
        String codigoGroovy = txtCodigo.getText();

        // Valores para a y b
        int a = 10;
        int b = 5;

        // Formatear el código Groovy para pasar los valores de a y b
        //String codigoConValores = codigoGroovy + "\ncalculo(" + a + ", " + b + ")";

        try {
            // Ejecutar el código Groovy con valores de a y b
            Object res = ejecutarCodigoGroovy(codigoGroovy);
            txtRes.setText(res.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(main, "Error al ejecutar el código: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Object ejecutarCodigoGroovy(String codigo) throws Exception {
        // Crear un shell de Groovy
        GroovyShell shell = new GroovyShell();

        // Evaluar el código Groovy
        Object resultado = shell.evaluate(codigo);

        return resultado;
    }
}
