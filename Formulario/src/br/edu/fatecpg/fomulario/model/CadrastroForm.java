package br.edu.fatecpg.fomulario.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadrastroForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCadastro;

    public CadrastroForm() {
        setTitle("Cadastro de Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 10, 70, 15);
        contentPane.add(lblNome);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(50, 60, 70, 15);
        contentPane.add(lblIdade);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 110, 70, 15);
        contentPane.add(lblSexo);

        // TextField para o nome
        txtCadastro = new JTextField();
        txtCadastro.setBounds(120, 10, 150, 20);
        contentPane.add(txtCadastro);
        txtCadastro.setColumns(10);

        // Spinner para idade
        JSpinner spnIdade = new JSpinner();
        spnIdade.setBounds(120, 60, 50, 20);
        contentPane.add(spnIdade);

        // RadioButton para sexo
        JRadioButton radioMasculino = new JRadioButton("Masculino");
        radioMasculino.setBounds(120, 110, 90, 20);
        contentPane.add(radioMasculino);

        JRadioButton radioFeminino = new JRadioButton("Feminino");
        radioFeminino.setBounds(220, 110, 90, 20);
        contentPane.add(radioFeminino);

        // ButtonGroup para garantir que apenas um dos RadioButtons seja selecionado
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(radioMasculino);
        grupoSexo.add(radioFeminino);

        // Botão enviar
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(120, 170, 100, 25);
        contentPane.add(btnEnviar);

        // Ação do botão enviar
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coleta de dados
                String nome = txtCadastro.getText();
                int idade = (Integer) spnIdade.getValue();
                String sexo = radioMasculino.isSelected() ? "Masculino" : "Feminino";

                // Criação de um novo objeto Cliente
                Cliente cliente = new Cliente(nome, idade, sexo);

                // Exibe as informações coletadas
                JOptionPane.showMessageDialog(null, cliente.toString(), "Resumo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
