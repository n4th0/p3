package es.ua.dlsi.prog3.p5.model;
import es.ua.dlsi.prog3.p5.export.*;
 
import java.util.List;

// TODO que cojones hay que hacer aqui


public class Quote extends AbstractComposite implements IBlock {

    public Quote(List<IParagraphContent> paragraphContentList) {
        for (IParagraphContent paragraphContent: paragraphContentList) {
            this.addItem(paragraphContent);
        }
    }

    /**
     * Constructor
     * @param paragraphContents None or several paragraph contents
     */    
    public Quote(IParagraphContent ... paragraphContents) {
        for (IParagraphContent paragraphContent: paragraphContents) {
            this.addItem(paragraphContent);
        }
    }

    @Override
    public String export(IExporter exporter) {
        return exporter.export(this);
    }
}
