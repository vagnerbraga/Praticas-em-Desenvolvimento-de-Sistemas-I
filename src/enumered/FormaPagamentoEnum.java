package enumered;

public enum FormaPagamentoEnum {

    A_VISTA("á vista"), A_PRAZO("á prazo");
    
    private String label;

    private FormaPagamentoEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
}
