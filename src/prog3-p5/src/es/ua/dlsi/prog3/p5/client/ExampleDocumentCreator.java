package es.ua.dlsi.prog3.p5.client;

import es.ua.dlsi.prog3.p5.model.*;
import java.util.*;

/**
 * This class is used for the evaluation of the assignment
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 31/10/22
 */
public class ExampleDocumentCreator  {
    /**
     * --- IMPLEMENT this method ---
     * 
     * @return Document object
     */
    public Document createExample() {
        Document document = new Document();
        try{
            document.add(new Heading("Heading", 1));
        }catch(EditorException e){
            System.out.println(e.getStackTrace());
            throw new RuntimeException();
        }
        document.add(new Paragraph(new Text("Some text to introduce the article")));

        ArrayList<IParagraphContent> paragraphContentList = new ArrayList<IParagraphContent>();
        paragraphContentList.add(new Text("Something someone said:"));
        paragraphContentList.add(new LinkParagraphContentDecorator(new Text( "original cite site"), "https://www.somesite.edu"));
        document.add(new Quote(paragraphContentList));

        try{
            document.add(new Heading("First section", 2));
        }catch(EditorException e){
            System.out.println(e.getStackTrace());
            throw new RuntimeException();
        }

        document.add(new Paragraph(new Text("Example of text decorators:")));

        List<IBlock> n = new ArrayList<>();
        n.add(new Text("Raw text"));
        n.add(new ItalicsTextDecorator(new Text("Italics")));
        n.add(new BoldTextDecorator(new Text("Bold")));
        n.add(new StrikeThroughDecorator(new Text("Strike through")));
        n.add(new ItalicsTextDecorator(new BoldTextDecorator(new StrikeThroughDecorator(new Text("The three above")))));
        n.add(new Paragraph(new Text("Raw text inside a paragraph")));
        document.add(new OrderedListBlock(n));

        try{
            document.add(new Heading("Code block", 3));
        }catch(EditorException e){
            System.out.println(e.getStackTrace());
            throw new RuntimeException();
        }
        document.add(new CodeBlock("class PROG3 {}", "java"));
        document.add(new HorizontalRule());
        document.add(new Paragraph(new Image("https://web.ua.es/secciones-ua/images/layout/logo-ua.jpg", "UA logo")));

        return document;
    }
}
