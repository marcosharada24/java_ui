package br.edu.fatecpg.configUser.view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextArea;
import br.edu.fatecpg.configUser.model.Usuario;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Usuario usuario; // Objeto usuário para armazenar preferências

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        setTitle("Configurações de Preferências");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título - Tema
        JLabel lblTema = new JLabel("Tema:");
        lblTema.setBounds(87, 37, 46, 14);
        contentPane.add(lblTema);

        // JComboBox para escolher tema
        JComboBox<String> cb_tema = new JComboBox<>();
        cb_tema.setModel(new DefaultComboBoxModel<>(new String[] {"Claro", "Escuro"}));
        cb_tema.setBounds(134, 33, 67, 22);
        contentPane.add(cb_tema);

        // Título - Notificações
        JLabel lblNotificacao = new JLabel("Notificações:");
        lblNotificacao.setBounds(41, 85, 76, 14);
        contentPane.add(lblNotificacao);

        // JCheckBox para notificações
        JCheckBox chckbxNotificacoes = new JCheckBox("Habilitar Notificações");
        chckbxNotificacoes.setBounds(123, 81, 134, 23);
        contentPane.add(chckbxNotificacoes);

        // Título - Volume
        JLabel lblVolume = new JLabel("Volume:");
        lblVolume.setBounds(57, 124, 46, 14);
        contentPane.add(lblVolume);

        // JSlider para ajustar o volume
        JSlider slider = new JSlider(0, 100);
        slider.setBounds(97, 124, 228, 40);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        contentPane.add(slider);

        // JButton para salvar as preferências
        JButton btn_salvar = new JButton("Salvar");
        btn_salvar.setBounds(88, 191, 89, 23);
        contentPane.add(btn_salvar);

        // JTextArea para exibir as preferências salvas
        JTextArea txt_PreferenciasSalvas = new JTextArea();
        txt_PreferenciasSalvas.setText("Preferências salvas");
        txt_PreferenciasSalvas.setBounds(57, 225, 350, 40);
        txt_PreferenciasSalvas.setEditable(false);
        contentPane.add(txt_PreferenciasSalvas);

        // Ação do botão Salvar
        btn_salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tema = (String) cb_tema.getSelectedItem();
                boolean notificacoes = chckbxNotificacoes.isSelected();
                int volume = slider.getValue();

                // Cria o usuário com as preferências
                usuario = new Usuario(tema, notificacoes, volume);

                // Exibe as preferências no JTextArea
                txt_PreferenciasSalvas.setText(usuario.toString());

                // Muda a cor do JPanel com base no tema selecionado
                if ("Escuro".equals(tema)) {
                    contentPane.setBackground(Color.DARK_GRAY);
                    txt_PreferenciasSalvas.setBackground(Color.DARK_GRAY);
                    txt_PreferenciasSalvas.setForeground(Color.WHITE);
                } else {
                    contentPane.setBackground(Color.LIGHT_GRAY);
                    txt_PreferenciasSalvas.setBackground(Color.LIGHT_GRAY);
                    txt_PreferenciasSalvas.setForeground(Color.BLACK);
                }
            }
        });
    }
}
