package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Logica.Calculadora;
import javax.swing.JLabel;

public class VentanaCalculadora extends JFrame implements ActionListener {

    // Atributos
    JTextField pantalla;
    JButton teclado[];
    String cadena = "";
    String num1;
    String num2;
    char op = 'a';
    Calculadora operator;
    String memoria;
    JLabel m;

    public VentanaCalculadora() {
        this.setBounds(0, 0, 400, 400);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaCaluladora();
    }

    private void VentanaCaluladora() {
        
             
        //pantalla
        JPanel panelPantalla = new JPanel();
        panelPantalla.setBounds(15, 10, 375, 70);
        pantalla = new JTextField(8);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("arial", Font.BOLD, 50));
        pantalla.setEditable(false);
        pantalla.setForeground(Color.BLACK);
        panelPantalla.add(pantalla);
        this.add(panelPantalla);
        // memoria
         m = new JLabel("M");
             
             m.setBounds(20,10,10,10);
             m.setFont(new Font("arial",Font.BOLD,10));
             m.setVisible(false);
             panelPantalla.add(m);   
        // BOTONES
        JPanel panelTeclado = new JPanel();
        panelTeclado.setBounds(15, 100, 370, 250);
        panelTeclado.setLayout(new GridLayout(2, 4));
        teclado = new JButton[8];
        String etiquetas[] = {"0", "1", "+", "*", "C", "=", "-", "M"};

        for (int i = 0; i < teclado.length; i++) {
            teclado[i] = new JButton(etiquetas[i]);
            teclado[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
            teclado[i].addActionListener(this);
            panelTeclado.add(teclado[i]);
        }
        this.add(panelTeclado);
    }

    private void AccionarTecla(char tecla) {
        operator = new Calculadora();
        switch (tecla) {
            case ('1'):
                cadena = operator.sumar(num1, num2);
                break;
            case ('2'):
                cadena = operator.restar(num1, num2);
                break;
            case ('3'):
                cadena = operator.multiplicar(num1, num2);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 0
        if (e.getSource().equals(teclado[0])) {
            cadena += "0";
            pantalla.setText(cadena);
        }
        //1
        if (e.getSource().equals(teclado[1])) {
            cadena += "1";
            pantalla.setText(cadena);
        }
        // +
        if (e.getSource().equals(teclado[2])) {
            num1 = pantalla.getText();
            op = '1';
            cadena = "";
            pantalla.setText(cadena);
            System.out.println(num1);
        }
        //*
        if (e.getSource().equals(teclado[3])) {
            num1 = pantalla.getText();
            op = '3';
            cadena = "";
            pantalla.setText(cadena);
            System.out.println(num1);
        }
        //C
        if (e.getSource().equals(teclado[4])) {
            cadena = "";
            pantalla.setText(cadena);
            

        }
        // =
        if (e.getSource().equals(teclado[5])) {
            System.out.println(cadena);
            num2 = pantalla.getText();
            AccionarTecla(op);
            pantalla.setText(cadena);
            
        }
        // -
        if (e.getSource().equals(teclado[6])) {
            
            num1 = pantalla.getText();
            op = '2';
            cadena = "";
            System.out.println(num1); 
        }
        // M
         if (e.getSource().equals(teclado[7])) {
             if (cadena == ""){
                pantalla.setText(memoria);
            }else{
            memoria = pantalla.getText();
            cadena = "";
            pantalla.setText(cadena);
            System.out.println("memoria");
            m.setVisible(true);
            System.out.println(pantalla.getText());
             }
             }
         
        
    }

    public static void main(String[] args) {
        VentanaCalculadora a = new VentanaCalculadora();
        a.setVisible(true);
    }

}
