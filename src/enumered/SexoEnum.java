package enumered;

public enum SexoEnum {

    MASCULINO("Masculino"),
    FEMININO("Feminino");
    
    private final String label;

    private SexoEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
