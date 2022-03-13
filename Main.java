
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Arthur
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Stack<Character> stack;
        InputStream inputstream = new FileInputStream("entradaDados.txt");
        InputStreamReader reader = new InputStreamReader(inputstream);
        BufferedReader br = new BufferedReader(reader);

        Boolean validador = true;
        String linha = br.readLine();
        List<String> listaParaRetornar = new ArrayList<>();
        while (linha != null) {
            stack = new Stack<Character>();
            validador = true;
            for (char letra : linha.toCharArray()) {

               
                if (letra == '{'
                        || letra == '('
                        || letra == '['
                        || letra == '<') {

                    stack.push(letra);
                } else {
                    if (stack.empty()) {
                        validador = false;
                       
                    } else {
                        if (letra == ')' && stack.peek() != '(') {
                            validador = false;
                        } else if (letra == '}' && stack.peek() != '{') {
                            validador = false;
                        } else if (letra == ']' && stack.peek() != '[') {
                            validador = false;
                        } else if (letra == '>' && stack.peek() != '<') {
                            validador = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
            }
           
            if (validador) {
                listaParaRetornar.add(linha + " válido");
            } else {
                listaParaRetornar.add(linha + " inválido");
            }
            linha = br.readLine();
        }
        OutputStreamWriter bufferOut = new OutputStreamWriter(
                new FileOutputStream("Resultado"), "UTF-8");

        for (String palavra : listaParaRetornar) {
            bufferOut.write(palavra + "\n");
        }
        bufferOut.close();
    }
}
