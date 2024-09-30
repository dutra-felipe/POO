package newFile;

import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args){
        try(FileWriter fw = new FileWriter("newFile/teste.c")) {
            fw.write("#include <stdio.h> \n\n int main(){\n\n   printf(\"Hello world!\"); \n\n   return 0; \n }");
            fw.close();
            System.out.println("Escrita realizada com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
