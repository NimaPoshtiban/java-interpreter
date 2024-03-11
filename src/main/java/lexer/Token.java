/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexer;

import java.util.HashMap;

/**
 *
 * @author nima
 */
public class Token {
    public String type;
    public String literal;
    public static HashMap keywords = Token.initKeywords();
    public Token(String type,String literal){
        this.type = type;
        this.literal = literal;
    }
    private static HashMap initKeywords(){
        var map = new HashMap();
        map.put("func", TokenType.FUNCTION);
        map.put("let", TokenType.LET);
        map.put("true", TokenType.TRUE);
        map.put("false", TokenType.FALSE);
        map.put("if", TokenType.IF);
        map.put("else", TokenType.ELSE);
        map.put("return", TokenType.RETURN);
        return map;
    }
    public static String lookUpIdent(String ident){
        if(keywords.containsKey(ident)){
            return (String)keywords.get(ident);
        }
        return TokenType.IDENT;
    }
}
