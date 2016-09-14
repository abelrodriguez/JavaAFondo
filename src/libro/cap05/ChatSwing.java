/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap05;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

/**
 *
 * @author Abel Rodríguez
 */
public class ChatSwing extends JFrame {
    private JTextField tfNick;
    private JTextField tfMensaje;
    private JButton bLogin;
    private JButton bLogout;
    private JButton bEnviar;
    private JList lstLog;
    
    private Border border;
    
    public ChatSwing() {
        super("Chat");
        
        Container content = getContentPane();
        
        content.setLayout(new BorderLayout());
        
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        JPanel pNorth = _crearPNorte();
        content.add(pNorth, BorderLayout.NORTH);
        
        JPanel pCenter = _crearPCenter();
        content.add(pCenter, BorderLayout.CENTER);
        
        JPanel pSouth = _crearPSur();
        content.add(pSouth, BorderLayout.SOUTH);
        
        setSize(400,300);
        setVisible(true);
    }
    
    private JPanel _crearPNorte() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        TitledBorder titleBoder = BorderFactory.createTitledBorder(border, "Nick");
        
        p.setBorder(titleBoder);
        
        tfNick = new JTextField(10);
        p.add(tfNick);
        
        bLogin = new JButton("Login");
        p.add(bLogin);
        
        bLogout = new JButton("Logout");
        p.add(bLogout);
        
        return p;
    }
    
    private JPanel _crearPCenter() {
        JPanel p = new JPanel(new BorderLayout());
        
        TitledBorder titleBoder = BorderFactory.createTitledBorder(border, "Conversacion");
        
        p.setBorder(titleBoder);
        
        lstLog = new JList();
        JScrollPane scroll = new JScrollPane(lstLog);
        p.add(scroll, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel _crearPSur() {
        JPanel p = new JPanel(new BorderLayout());
        
        TitledBorder titleBoder = BorderFactory.createTitledBorder(border, "Mensaje");
        
        p.setBorder(titleBoder);
        
        tfMensaje = new JTextField();
        p.add(tfMensaje, BorderLayout.CENTER);
        
        bEnviar = new JButton("Enviar");
        p.add(bEnviar, BorderLayout.EAST);
        
        return p;
    }
    
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel(new WindowsLookAndFeel());
        ChatSwing c = new ChatSwing();
    }
}
