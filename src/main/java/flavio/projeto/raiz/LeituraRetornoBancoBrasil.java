package flavio.projeto.raiz;

import flavio.projeto.raiz.entities.Boleto;
import flavio.projeto.raiz.interfaces.LeituraRetorno;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno{
    @Override
    public List<Boleto> lerArquivo(URI nomeArquivo) {
        var boletos = new ArrayList<Boleto>();
        try {
            var lista = Files.readAllLines(Paths.get(nomeArquivo));
            var FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println("------------ Banco do Brasil ------------");
            for (var linha : lista) {
            var vetor =     linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                //boleto.setDataPagamento(LocalDateTime.parse(vetor[3], FORMATO_DATA).toLocalDate().atTime(0, 0));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setJuros(Double.parseDouble(vetor[6]));
                boleto.setMulta(Double.parseDouble(vetor[7]));
                boletos.add(boleto);
                System.out.println(boleto.toString());

            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        //throw new UnsupportedOperationException("método imcompleto");
        return boletos;
    }
}
