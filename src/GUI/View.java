package GUI;

import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View extends JFrame implements ActionListener{
    JButton compressbutton;
    JButton decompressbutton;
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,150);
        this.getContentPane().setBackground(Color.cyan);
        
        compressbutton=new JButton("Compress File");
        compressbutton.setBounds(40,40,150,30);
        compressbutton.addActionListener(this);
        
        decompressbutton=new JButton("Decompress File");
        decompressbutton.setBounds(270,40,150,30);
        decompressbutton.addActionListener(this);
        
        this.add(compressbutton);
        this.add(decompressbutton);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressbutton){
            JFileChooser fileChooser =new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compress.compressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource()==decompressbutton){
            JFileChooser fileChooser =new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompress.decompressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
    }
    public static void main(String[] args){
        View view =new View();
        view.setVisible(true);
        
    }
}
