/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexer;

/**
 *
 * @author nima
 */
public class Lexer {

    public String input;
    public int position;
    public int readPosition;
    public char ch;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.readPosition = 0;
        this.readChar();
    }

    public Token nextToken() {
        Token token;
        this.skipWhitespace();

        switch (this.ch) {
            case '=' -> {
                if (this.peekChar() == '=') {
                    var _ch = this.ch;
                    this.readChar();
                    token = new Token(TokenType.EQ, _ch + "" + this.ch);
                } else {
                    token = new Token(TokenType.ASSIGN, this.ch + "");
                }
            }
            case '-' ->
                token = new Token(TokenType.MINUS, "" + this.ch);
            case '!' -> {
                if (this.peekChar() == '=') {
                    var _ch = this.ch;
                    this.readChar();
                    token = new Token(TokenType.NOT_EQ, _ch + "" + this.ch);
                } else {
                    token = new Token(TokenType.BANG, "" + this.ch);
                }
            }
            case '*' ->
                token = new Token(TokenType.ASTERISK, "" + this.ch);
            case '/' ->
                token = new Token(TokenType.SLASH, "" + this.ch);
            case '<' ->
                token = new Token(TokenType.LT, "" + this.ch);
            case '>' ->
                token = new Token(TokenType.GT, "" + this.ch);
            case ';' ->
                token = new Token(TokenType.SEMICOLON, "" + this.ch);
            case '(' ->
                token = new Token(TokenType.LPAREN, "" + this.ch);
            case ')' ->
                token = new Token(TokenType.RPAREN, "" + this.ch);
            case ',' ->
                token = new Token(TokenType.COMMA, "" + this.ch);
            case '+' ->
                token = new Token(TokenType.PLUS, "" + this.ch);
            case '{' ->
                token = new Token(TokenType.LBRACE, "" + this.ch);
            case '}' ->
                token = new Token(TokenType.RBRACE, "" + this.ch);
            case '[' ->
                token = new Token(TokenType.LBRACKET, "" + this.ch);
            case ']' ->
                token = new Token(TokenType.RBRACKET, "" + this.ch);
            case '"' ->
                token = new Token(TokenType.STRING, this.readString());
            case ':' ->
                token = new Token(TokenType.COLON, "" + this.ch);
            case 0 ->
                token = new Token(TokenType.EOF, "");
            case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_' -> {
                var literal = this.readIdentifier();
                token = new Token(Token.lookUpIdent(literal), literal);
            }
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ->
                token = new Token(TokenType.INT, this.readNumber());
            default ->
                token = new Token(TokenType.ILLEGAL, "" + this.ch);
        }
        this.readChar();
        return token;
    }

    private String readString() {
        var _position = this.position + 1;
        while (true) {
            this.readChar();
            if (this.ch == '"' || this.ch == 0) {
                break;
            }
        }
        return this.input.substring(_position, this.position);
    }

    private String readNumber() {
        var _position = this.position;
        while (this.isDigit(ch)) {
            this.readChar();
        }
        return this.input.substring(_position, this.position);
    }

    private void skipWhitespace() {
        while (this.ch == ' ' || this.ch == '\t' || this.ch == '\n' || this.ch == '\r') {
            this.readChar();
        }
    }

    private String readIdentifier() {
        var _position = this.position;
        while (this.isLetter(ch)) {
            this.readChar();
        }
        return this.input.substring(_position, this.position);
    }

    private char peekChar() {
        if (this.readPosition >= this.input.length()) {
            return 0;
        }
        return this.input.charAt(this.readPosition);
    }

    private void readChar() {
        if (this.readPosition >= this.input.length()) {
            this.ch = 0;
        } else {
            this.ch = this.input.charAt(this.readPosition);
        }
        this.position = this.readPosition++;
    }

    private boolean isLetter(char ch) {
        return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || ch == '_' || ch == '$';
    }

    private boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }
}
