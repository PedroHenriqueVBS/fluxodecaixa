package Caixa;

public class Produto {
    private static int nextCode = 1; //variavel onde vai definir o codigo ao adicionar o item
    private int code;
    private String name;
    private float value;


    public Produto(String name, float value) {
        this.code = nextCode++; //incrementa o valor do codigo ao variavel code
        this.name = name;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
