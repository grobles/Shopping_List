package com.Persistance;

import com.Item;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * Class: PrintLists
 * Description: This class will print a list of Items.
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/15/102
 */

public class PrintLists implements Printable {
    private final Item data;

    //TODO should take a List in the constructor
    //constructor
    public PrintLists(Item dataToPrint) {
        data = dataToPrint;
        //create a printer job
        PrinterJob printJob = PrinterJob.getPrinterJob();
        //set the job as printable
        printJob.setPrintable(this);
        //get printing confirmation in the print dialog box
        if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

    //print method
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int index;
        Graphics2D g2d;
        Line2D.Double line = new Line2D.Double();

        String strData = "No Data Received";
        //TODO need a list not an Item
//        for(Item i : data) {
//            strData = i.toString() + "\n";
//        }

        if (pageIndex == 0) {
            g2d = (Graphics2D) graphics;
            g2d.setColor(Color.black);
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g2d.drawString(data.toString(), 100, 100);
            return (PAGE_EXISTS);
        } else {
            return (NO_SUCH_PAGE);
        }
    }
}
