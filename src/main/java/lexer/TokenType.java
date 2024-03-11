/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexer;

/**
 *
 * @author nima
 */
public class TokenType {
    public static String ILLEGAL = "ILLEGAL";
    public static String EOF = "EOF";
    // identifiers + literals
    public static String IDENT = "IDENT";
    public static String INT = "INT";
    public static String STRING = "STRING";
    // Operators
    public static String ASSIGN = "=";
    public static String PLUS = "+";
    public static String MINUS = "-";
    public static String ASTERISK = "*";
    public static String BANG = "!";
    public static String SLASH = "/";
    public static String LT = "<";
    public static String GT = ">";
    public static String EQ = "==";
    public static String NOT_EQ = "!=";
    // Delimiters
    public static String COMMA = ",";
    public static String SEMICOLON = ";";
    public static String COLON = ":";
    public static String LPAREN = "(";
    public static String RPAREN = ")";
    public static String LBRACE = "{";
    public static String RBRACE = "}";
    public static String LBRACKET = "[";
    public static String RBRACKET = "]";
    
    // keywords
    public static String FUNCTION = "func";
    public static String LET = "let";
    public static String TRUE = "true";
    public static String FALSE = "false";
    public static String IF = "if";
    public static String ELSE = "else";
    public static String RETURN = "return";
}
