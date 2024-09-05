import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Valor{
    public static void main(String[] args) {
        try{
            File entrada = new File("faturamento.xml");
            DocumentBuilderFactory consDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder cDoc = consDoc.newDocumentBuilder();
            Document doc = cDoc.parse(entrada);
            doc.getDocumentElement().normalize();
            NodeList listaDias = doc.getElementsByTagName("dia");

            double meFat = Double.MAX_VALUE;
            double maFat = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;
            int acima = 0;
            for (int i = 0; i < listaDias.getLength(); i++) {
                Node node = listaDias.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;
                    double valor = Double.parseDouble(elemento.getElementsByTagName("valor").item(0).getTextContent());

                    if (valor > 0) { // Ignorar dias sem faturamento
                        if (valor < meFat) {
                            meFat = valor;
                        }
                        if (valor > maFat) {
                            maFat = valor;
                        }
                        somaFaturamento += valor;
                        diasComFaturamento++;
                    }
                }
            }
            double media = somaFaturamento / diasComFaturamento;
            for (int i = 0; i < listaDias.getLength(); i++) {
                Node node = listaDias.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;
                    double valor = Double.parseDouble(elemento.getElementsByTagName("valor").item(0).getTextContent());

                    if (valor > media) {
                        acima++;
                    }
                }
            }
            System.out.println("Menor valor de faturamento ocorrido: " + meFat);
            System.out.println("Maior valor de faturamento ocorrido: " + maFat);
            System.out.println("Dias com faturamento acima da média: " + acima);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
