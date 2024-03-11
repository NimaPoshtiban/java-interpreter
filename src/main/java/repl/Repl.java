/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repl;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import lexer.Lexer;
import lexer.TokenType;

/**
 *
 * @author nima
 */
public class Repl {

    static String prompt = "-> ";

    public static void Start(InputStream in, PrintStream out) {
        var scanner = new Scanner(in);
        while (true) {
            System.out.printf("%s", prompt);
            var scanned = scanner.hasNext();
            if (!scanned) {
                return;
            }
            var line = scanner.next();
            var lexer = new Lexer(line);
            for (var token = lexer.nextToken(); (token.type == null ? TokenType.EOF != null : !token.type.equals(TokenType.EOF)); token = lexer.nextToken()) {
                System.out.printf("Type: %s, Literal: %s", token.type, token.literal);
            }
        }
    }
}
