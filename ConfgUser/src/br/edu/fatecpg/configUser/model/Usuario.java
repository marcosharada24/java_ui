package br.edu.fatecpg.configUser.model;

public class Usuario {
    private String tema;
    private boolean notificacoes;
    private int volume;

    public Usuario(String tema, boolean notificacoes, int volume) {
        this.tema = tema;
        this.notificacoes = notificacoes;
        this.volume = volume;
    }

    // Getters e Setters
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public boolean isNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(boolean notificacoes) {
        this.notificacoes = notificacoes;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Tema: " + tema + ", Notificações: " + (notificacoes ? "Ativadas" : "Desativadas") + ", Volume: " + volume;
    }
}