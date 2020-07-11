package com.example.geoquiz;

public class pregunta {
    private int textoId;
    private boolean repuesta;

    public pregunta(int textoId, boolean repuesta) {
        this.textoId = textoId;
        this.repuesta = repuesta;
    }

    public int getTextoId() {
        return textoId;
    }

    public void setTextoId(int textoId) {
        this.textoId = textoId;
    }

    public boolean isRepuesta() {
        return repuesta;
    }

    public void setRepuesta(boolean repuesta) {
        this.repuesta = repuesta;
    }
}
