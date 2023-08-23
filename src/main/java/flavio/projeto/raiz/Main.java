package flavio.projeto.raiz;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        var leituraRetornoBB = new LeituraRetornoBancoBrasil();
        var processadorBB = new ProcessarBoletos(leituraRetornoBB);
        var leituraRetornoBD = new LeituraRetornoBradesco();
        var processadorBD = new ProcessarBoletos(leituraRetornoBD);
        processadorBB.processar(new URI("file://///home/flavio/Documentos/Padroes/Implementacao_Banco_do_Brasil_e_do_Bradesco/Projeto1/banco-brasil-1.csv"));
        processadorBD.processar(new URI("file://///home/flavio/Documentos/Padroes/Implementacao_Banco_do_Brasil_e_do_Bradesco/Projeto1/bradesco-1.csv"));
    }
}