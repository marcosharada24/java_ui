package br.edu.fatecpg.fomulario.view; // Corrigido de "fomulario" para "formulario"

import java.awt.EventQueue;

import br.edu.fatecpg.fomulario.model.CadrastroForm;

public class Main {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Inicia a tela de cadastro
                CadrastroForm frame = new CadrastroForm();
                frame.setVisible(true);
            }
        });
    }
}
