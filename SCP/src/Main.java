import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.IOException;
import java.util.zip.*;
import java.io.*;
import java.io.File;

public class Main{
    public void main(String[] args) throws Exception{
        //informaçoes do Os
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String osArch = System.getProperty("os.arch");
        System.out.println("Bem vindo!");

        System.out.println("\nOS Name: " + osName);

        System.out.println("\nOS Version: " + osVersion);

        System.out.println("\nOS Architecture: " + osArch);

        Scanner sc = new Scanner(System.in);

        long pid = ProcessHandle.current().pid();
        System.out.println("\nIndentificão do processo: "+pid);
        System.out.println();


        File dir =  new File("C:\\Users\\ketsu\\OneDrive\\Documentos\\Diretorio");
        if (dir.mkdir()){
            System.out.println("Diretorio pronto pra uso");
        }else{
            System.out.println("diretorio ja existente ou algum erro ocorreu.");
        }

                                        //criação la no diretorio(caso fosse um projeto mais bem feito acredito que seria possivel pedir o usuario que informasse a localização do arquivo)
        File a= new File("C:\\Users\\ketsu\\OneDrive\\Documentos\\Diretorio\\Arq_1.txt");

        User b = new User();

        if (a.createNewFile()) {             //verifica se o arquivo ja existe, acredito que se createNewFile estiver true o arquivo nao existe, em seguida a criação pode ser false, pois o arquivo ja existe
            System.out.println("Arquivo criado: " + a.getName());
        } else {
            System.out.println("Arquivo existente.");
        }
        System.out.println("\nEscreva aqui o conteudo do arquivo:"); //dar um trabalhinho pro usuario fazer algo pelo menos
        b.setConteudo_arq(sc.nextLine());
                                         //serve pra não sobrescrever o arquivo ja existente
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Arq_1.txt", true))){
            Files.writeString(Path.of("C:\\Users\\ketsu\\OneDrive\\Documentos\\Diretorio\\Arq_1.txt"),b.getConteudo_arq());
        }catch (IOException e) {
            System.out.println(("Houve um erro."));
        }
        System.out.println("\nTree");
        File[] contentsAsFiles = dir.listFiles();
        if (contentsAsFiles != null) {
            for (File file : contentsAsFiles) {
                if (file.isDirectory()) {
                    System.out.println("DIRETORIO  " + file.getName());
                } else {
                    System.out.println("ARQUIVO " + file.getName());
                }
            }
        }




    }
}
