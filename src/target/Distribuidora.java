package target;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.ParserException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Distribuidora {
    public static void main(String[] args) {
        JSONObject objetoJson;
        
        JSONParser parser = new JSONParser();
        int contDias = 0;
        double total = 0;
        double media;
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        long[] dias = new long[30];
        double[] valores = new double[30];
        
        try{
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("dados.json"));
            for (int i = 0; i < 30; i++){
                objetoJson = (JSONObject)jsonArray.get(i);
                dias[i] = (long) objetoJson.get("dia");
                valores[i] = (double) objetoJson.get("valor");
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(ParserException e){
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 30; i++) {
            if(valores[i] != 0) {
                contDias++;
            }
        }
        
        for (int i = 0; i < 30; i++) {
            total += valores[i];
        }
        
        for (int i = 0; i < 30; i++) {
            if(valores[i] != 0 && valores[i] < menorFaturamento) {
                menorFaturamento = valores[i];
            }
            
            if(valores[i] > maiorFaturamento) {
                maiorFaturamento = valores[i];
            }
        }
        
        media = total / contDias;
        contDias = 0;
        
        for (int i = 0; i < 30; i++) {
            if(valores[i] > media) {
                contDias++;
            }
        }
        
        System.out.println("Menor faturamento ocorrido: " + menorFaturamento);
        System.out.println("Maior faturamento ocorrido: " + maiorFaturamento);
        System.out.println("Quantidade de dias que o faturamento foi maior que a média mensal: " + contDias);
        
    }
}
