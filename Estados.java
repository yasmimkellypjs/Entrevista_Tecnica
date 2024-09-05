import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Estados {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("faturamentoMensal.xml"));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("estado");
            double totalFaturamento = 0.0;
            double[] valores = new double[nodeList.getLength()];
            String[] nomes = new String[nodeList.getLength()];
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element estadoElement = (Element) nodeList.item(i);
                String nome = estadoElement.getElementsByTagName("nome").item(0).getTextContent();
                double valor = Double.parseDouble(estadoElement.getElementsByTagName("valor").item(0).getTextContent().trim());
                nomes[i] = nome;
                valores[i] = valor;
                totalFaturamento += valor;
            }
            for (int i = 0; i < nomes.length; i++) {
                double percentual = (valores[i] / totalFaturamento) * 100;
                System.out.printf("Estado: %s, Valor: %.2f, Percentual: %.2f%%\n", nomes[i], valores[i], percentual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

