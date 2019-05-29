/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploxml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Admin
 */
public class EjemploXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
		SAXBuilder builder = new SAXBuilder();
		try {
			Document documento=builder.build(new File("D:\\libros.xml"));
			Element elemento_raiz=documento.getRootElement();
                        
			List<Element> lista_elementos_hijo=elemento_raiz.getChildren();
			for (int i=0; i<lista_elementos_hijo.size(); i++)
			{
				Element elemento_book=lista_elementos_hijo.get(i);
				Element elemento_title=elemento_book.getChild("title");
				String lang=elemento_title.getAttribute("lang").getValue();
                                String titulo=elemento_title.getValue();
				List<Element> lista_elementos_autor=elemento_book.getChildren("author");
				System.out.println("Titulo: "+elemento_title.getValue());
				for (Element element : lista_elementos_autor) {
					System.out.println("Autor: "+element.getValue());
				}
				/*Attribute atributo_category=elemento_book.getAttribute("category");
				Attribute atributo_cover=elemento_book.getAttribute("cover");//Esto puede ser null
				System.out.println("Nombre: "+elemento_book.getName()+" Categoría: "+atributo_category.getValue());
				if (atributo_cover!=null)
				{
				System.out.println("Cover: "+atributo_cover.getValue());
				}*/
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
}
