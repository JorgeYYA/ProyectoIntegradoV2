package Modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class importarCuentaPDF {
	
	public importarCuentaPDF() {
		
	}
	
	public void creaCuenta(String rutaPdf , JTable jtable) {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaPdf));
			document.open();
			
			Paragraph paragraph = new Paragraph("FACTURA",FontFactory.getFont(FontFactory.TIMES, 14));
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			Image img = Image.getInstance("bin/img/restaurante.png");
			document.add(img);
			PdfPTable table = new PdfPTable(2);
			
			for(int i=0; i<jtable.getRowCount(); i++) {
				for(int i2=0; i2<jtable.getColumnCount(); i2++) {
					table.addCell(jtable.getModel().getValueAt(i, i2).toString());
				}
			}
			document.add(table);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		document.close();
		
	}
}