package br.com.moraes.View;

import javax.swing.JOptionPane;


public class ConversorFrameView {

    private String selectedValueConversor;
    // 0 == OK and 2 == Cancel
    private Integer selectedValueConfirmacao;
    private Double valueSelected;
    private Object selectedMoedaValue;

    Object[] moedas = { "De Real para Dolar",
            "De Dolar para Real",
            "De Real para Peso Argentino",
            "De Peso Argentino para Real",
            "De Real para Euro",
            "De Euro para Real",
            "De Real para Libra Esterlina",
            "De Libra Esterlina para Real",
            "De Real para Peso Chileno",
            "De Peso Chileno para Real" };

    public String escolhaConversorView() {
        Object[] opcoes = { "Conversor de Moedas", "Convesor de Temperaturas" };

        String selectedValue = (String) JOptionPane.showInputDialog(null, "Escolha um Conversor!", "Escolha o Conversor",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
        return selectedValue;
    }

    public int escolhaConfirmacaoView() {
        if (selectedValueConversor == "Conversor de Moedas" || selectedValueConversor == "Convesor de Temperaturas") {
            int i = JOptionPane.showConfirmDialog(null,
                    "Voce escolheu o " + selectedValueConversor + " deseja Continuar?", "Confirmaçao",
                    JOptionPane.OK_CANCEL_OPTION);
            this.selectedValueConfirmacao = i;
        }
        return selectedValueConfirmacao;
    }

    public Double escolhaValorView() {
        if (selectedValueConfirmacao == 0) { // OK >> preciso de um input para o valor!

            double valueMoedaInput = 0;
            String inputValue = JOptionPane.showInputDialog(null, "Digite o valor para a conversao",
                    JOptionPane.OK_OPTION);
            inputValue = inputValue.replace(',', '.');
            try {
                valueMoedaInput = Double.parseDouble(inputValue);
                if (valueMoedaInput == 0.0) {
                    throw new NumberFormatException();
                }
                this.valueSelected = valueMoedaInput;
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Número Invalido!");
                viewTotal();
            }
        }

        if (selectedValueConfirmacao == 2) {
            viewTotal();
        }
        return valueSelected;
    }

    public String opcoesConversaoView() {

        String selectedOpcao = (String) JOptionPane.showInputDialog(
                null,
                "Escolha o tipo da conversao!",
                "Escolha a moeda desejada",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                moedas,
                moedas[0]);

        return selectedOpcao;
    }

    public void viewTotal() {
        escolhaConversorView();
        escolhaConfirmacaoView();
        escolhaValorView();
        System.out.println(valueSelected);
        opcoesConversaoView();
        System.out.println(selectedMoedaValue);
    }

    public Object getSelectedMoeda() {
        return selectedMoedaValue;
    }

    public Double getValueToConv() {
        return valueSelected;
    }

    public static void main(String[] args) {
        ConversorFrameView caixa = new ConversorFrameView();
        caixa.viewTotal();
        
    }
}
