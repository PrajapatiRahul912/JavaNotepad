import com.ozten.font.JFontChooser;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Notepad_Java implements ActionListener, UndoableEditListener {

    JMenu file,edit,format,view,zoom;

    JMenuItem item1, item2 ,item3, item4, item5,item6,item7,item8,item9,item10,item11,item12,
            item13,item14,item15,item16,item17,item18;
    JFrame frame;
    JPanel panel;
    JMenuBar MBar;
    JTextArea ta;
    JScrollPane scroll;
    JFileChooser jfc;
    JFontChooser fc;
    UndoManager um;

    Notepad_Java(){

        frame =new JFrame("Java-Notepad");
        panel = new JPanel();
        MBar =new JMenuBar();
        ta = new JTextArea();
        scroll = new JScrollPane(ta);
        jfc = new JFileChooser();
        fc = new JFontChooser();

        ImageIcon img2 = new ImageIcon("src/images.png");
        frame.setIconImage(img2.getImage());


         um = new UndoManager();

        frame.setSize(1365,685);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel.setLayout(null);
        panel.setSize(1365,685);

        scroll.setSize(1275,620);
//        ta.setSize(1200,600);


        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//__________________________________________File Menu_______________________________________________________

        file=new JMenu("File");

//  ___________________________________File Menu Items_______________________________________________________

        item1=new JMenuItem("New...                               Ctrl+N");
        item1.addActionListener(this);


        item2=new JMenuItem("Open...                              Ctrl+o");
        item2.addActionListener(this);

        item3=new JMenuItem("Save...                              Ctrl+S");
        item3.addActionListener(this);


        item4=new JMenuItem("Save As...                                 ");

        item5=new JMenuItem("Print...                             Ctrl+P");
        item5.addActionListener(this);

        item6=new JMenuItem("Exit...                                    ");
        item6.addActionListener(this);

        file.add(item1);
        file.add(item2);
        file.add(item3);
        file.add(item4);
        file.add(item5);
        file.add(item6);

//-------------------------------------------------x-----------------------------------------------------------
// __________________________________________Edit Menu_________________________________________________________

        edit=new JMenu("Edit");

        item7=new JMenuItem("Undo...                             Ctrl+Z");
        item7.addActionListener(this);

        ta.getDocument().addUndoableEditListener(this);

        item8 = new JMenuItem("Cut...                               Ctrl+X");
        item8.addActionListener(this);

        item9=new JMenuItem("Copy...                             Ctrl+C");
        item9.addActionListener(this);
        item10=new JMenuItem("Paste...                           Ctrl+V");
        item10.addActionListener(this);
        item11=new JMenuItem("Delete...                              Del");
        item11.addActionListener(this);

        item12=new JMenuItem("Select All...                      Ctrl+A");
        item12.addActionListener(this);

        edit.add(item7);
        edit.add(item8);
        edit.add(item9);
        edit.add(item10);
        edit.add(item11);
        edit.add(item12);

//---------------------------------------------------x----------------------------------------------------------

//-----------------------------------------------Format Menu----------------------------------------------------

        format=new JMenu("Format");

        item13=new JMenuItem("Word Wrap");
        item13.addActionListener(this);
        item14=new JMenuItem("Font.....");
        item14.addActionListener(this);

        format.add(item13);
        format.add(item14);

        view =new JMenu("View");
        zoom =new JMenu("Zoom");
        item15=new JMenuItem("Zoom");
        item16=new JMenuItem("Zoom In                                       Ctrl+Plus");
        item17=new JMenuItem("Zoom out                                     Ctrl+Minus");

        zoom.add(item15);
        zoom.add(item16);
        zoom.add(item17);

// -----------------------------------------------x-------------------------------------------------------------

// ----------------------------------------------View Menu------------------------------------------------------

        item18=new JMenuItem("About Notepad");
        view.add(item18);

//------------------------------------------------x--------------------------------------------------------------

        MBar.add(file);
        MBar.add(edit);
        MBar.add(format);
        MBar.add(view);
        view.add(zoom);


        frame.setJMenuBar(MBar);
//        scroll.add(ta);
        panel.add(scroll);

        frame.add(panel);
        frame.setVisible(true);


    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==item1){
            frame.setTitle("untitled-txt");
            ta.setText("");
        }

        if(e.getSource()==item2){
            jfc.showDialog(frame,JFileChooser.APPROVE_SELECTION);
            try{
                File f1 = jfc.getSelectedFile();
                frame.setTitle(f1.getName()+" | Notepad");
                Scanner sc = new Scanner(f1);
                ta.setText("");
                while(sc.hasNextLine()){
                    ta.append(sc.nextLine()+"\n");
                }
            }
            catch(Exception e1){
                System.out.println("Error in open");
            }
        }

        if(e.getSource()==item3){
            int option1 = jfc.showSaveDialog(frame);
            if (option1 == JFileChooser.APPROVE_OPTION){
                try{
                    File f1 = jfc.getSelectedFile();
                    String txt = ta.getText();
                    FileWriter fw = new FileWriter(f1);
                    fw.write(txt);
                    fw.close();
                }
                catch(Exception e1){
                    System.out.println("error in save");
                }
             }
        }
        if(e.getSource()==item5){
            try {
                ta.print();
            } catch (Exception e1) {
                System.out.println("error in print");
            }
        }

        if(e.getSource()==item6){
            System.exit(0);
        }

        if(e.getSource()==item7){
            try {
                um.undo();
            } catch (Exception e1) {
                System.out.println("Error in undo");
            }
        }

        if(e.getSource()==item8){
            ta.cut();
        }
        if(e.getSource()==item9){
            ta.copy();
        }
        if(e.getSource()==item10){
            ta.paste();
        }

        if(e.getSource()==item11){
            ta.replaceSelection("");
        }

        if(e.getSource()==item12){
            ta.selectAll();
        }

        if(e.getSource()==item13){
            ta.setLineWrap(true);
        }

        if(e.getSource()==item14){
            JOptionPane.showMessageDialog(null,fc,"Select a Font",JOptionPane.PLAIN_MESSAGE);
            ta.setFont(fc.getPreviewFont());
        }
    }

    public void undoableEditHappened(UndoableEditEvent e) {
        um.addEdit(e.getEdit());
    }

    public static void main(String[] args) {
        new Notepad_Java();
    }

}
