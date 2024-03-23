package criptografia;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        try {
            // Cria um gerador de chaves AES
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            // Inicializa o gerador com um tamanho de chave de 256 bits
            keyGen.init(256);
            // Gera a chave secreta
            SecretKey secretKey = keyGen.generateKey();
            // Converte a chave secreta para bytes
            byte[] keyBytes = secretKey.getEncoded();
            // Converte os bytes da chave para uma representação hexadecimal
            StringBuilder hexKey = new StringBuilder();
            for (byte b : keyBytes) {
                hexKey.append(String.format("%02x", b));
            }
            // Imprime a chave secreta em hexadecimal
            System.out.println("Chave Secreta (Hexadecimal): " + hexKey.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}