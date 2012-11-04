package com.Persistance;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

/**
 * Class: PrintLists
 * Description: This class will print a list of Items.
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/15/12
 */

public class PrintLists implements Printable {
    String strData = "";
    private final int POINTS_PER_INCH = 72;
    private final String NEW_LINE = "\r\n";


    private void getPrintString(List myList) {
        StringBuilder sb = new StringBuilder(strData);
        for (Object i : myList) {
            sb.append(i.toString() + ";");
        }
        strData = sb.toString();
    }

    //constructor
    public PrintLists(List dataToPrint) {
        //create a printer job
        PrinterJob printJob = PrinterJob.getPrinterJob();

        getPrintString(dataToPrint);

        //set the job as printable
        printJob.setPrintable(this);
        printJob.setCopies(1);
        //get printing confirmation in the print dialog box
        if (printJob.printDialog() && strData != null) {
            try {
                printJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

    //print method
    //@Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D g2d;
        Line2D.Double line = new Line2D.Double();
        //create a string array to loop over for printing lines
        String[] lines = strData.split(";");
        int y = 15;
        Font printFont = new Font(Font.SERIF, Font.PLAIN, 12);
        if (pageIndex == 0) {

            g2d = (Graphics2D) graphics;
            g2d.setFont(printFont);
            g2d.setColor(Color.black);
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            //loop over the string array drawing them as new lines

            for (int i = 0; i < lines.length; i++) {
                g2d.drawString(lines[i], 5, y);
                y += 15;
            }
            return (PAGE_EXISTS);
        } else {
            return (NO_SUCH_PAGE);
        }
    }
}
