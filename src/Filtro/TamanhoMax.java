/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtro;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Bene
 */
public class TamanhoMax extends PlainDocument{
    private int limit;

    public TamanhoMax(int limite) {
    super();
    this.limit = limite;
    }

    public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
        if (str == null) return;
        if ((getLength() + str.length()) <= limit) {
           super.insertString(offset, str, attr);
    }
  }    
}
