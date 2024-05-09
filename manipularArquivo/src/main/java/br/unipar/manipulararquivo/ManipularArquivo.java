/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.manipulararquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Beatr
 */
public class ManipularArquivo {

    public static void main(String[] args) {
        
        File arquivo = new File("arquivo.txt");
        
        if(arquivo.exists()) {
            System.out.println("Arquivo existe!");
        }else{
            System.out.println("Arquivo não existe!");
            
            try{
                arquivo.createNewFile();
                System.out.println("Arquivo criado com sucesso!");

            }catch(IOException e) {
                System.out.println("Erro ao criar um arquivo: " + e.getMessage());
            }  
        }
        
        try(FileWriter escritor = new FileWriter(arquivo);
            BufferedWriter buffer = new BufferedWriter(escritor)) {
            
            for (int i = 1; i <= 10; i++) {
                buffer.write(i + " x 9 = " + (i * 9) + "\n");
            }

        }catch(IOException e){
             e.printStackTrace();
        }   
        
        try(FileReader leitor = new FileReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor)){
                 String linha;
                 while((linha = buffer.readLine()) != null) {
                     System.out.println(linha);
                 }
        }catch(IOException e) {
            e.printStackTrace();
        }

        arquivo.delete();
        System.out.println("Arquivo excluído!");

    }
}
