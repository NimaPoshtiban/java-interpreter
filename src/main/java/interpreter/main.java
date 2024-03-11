/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package interpreter;

import static java.lang.System.getenv;
import repl.Repl;

/**
 *
 * @author nima
 */
public class main {

    public static void main(String[] args) {
        var username = getenv("USERNAME");
        System.out.printf("Hello %s! This is the C-- programming language!\n", username);
        System.out.println("Feel free to type in commands");
        Repl.Start(System.in, System.out);
    }
}
