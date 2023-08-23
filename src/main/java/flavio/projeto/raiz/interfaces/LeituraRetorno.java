package flavio.projeto.raiz.interfaces;

import flavio.projeto.raiz.entities.Boleto;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    // No lugar de String pode se usar a String
    public List<Boleto> lerArquivo(URI nomeArquivo);
}
