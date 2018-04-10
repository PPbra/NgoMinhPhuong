
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.util.*;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class DrawPanel {
    private JFrame frame;
    private JMenuBar bar;
    private readFolder projectFolder;
   /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable(){

            public void run() {

                try {
                    DrawPanel window = new DrawPanel();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * Create the application.
     */
    public DrawPanel() {
        initUI();
    }
    
    private void initUI(){
        frame = new JFrame();
        bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu menu = new JMenu("File");
        ImageIcon openIcon = new ImageIcon("D:\\load.gif");
        ImageIcon exitIcon = new ImageIcon("D:\\load.gif");
        JMenuItem open_item = new JMenuItem("Open",openIcon);
        JMenuItem exit_item = new JMenuItem("Exit",exitIcon);

        exit_item.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               System.exit(0);
            }
        });
        open_item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                switch (fileChooser.showOpenDialog(frame)){
                case JFileChooser.APPROVE_OPTION:
                    frame.remove(frame);
                    projectFolder =  new readFolder();
                    dataClass data = projectFolder.readFolderNow(fileChooser.getSelectedFile().toString().replace("\\","\\\\"));
                    File[] ListFiles = fileChooser.getSelectedFile().listFiles();
                  
                    
                    JScrollPane jsp = new JScrollPane(drawUML(data));
                    JScrollPane jspJTree = creatJTree(fileChooser.getSelectedFile(),ListFiles);
                    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    frame.setLocationRelativeTo(frame);
                    frame.getContentPane().add(jsp,BorderLayout.CENTER);
                    frame.getContentPane().add(jspJTree,BorderLayout.WEST);
                    frame.revalidate();
                    frame.pack();
                    frame.repaint();
                }
            }

            private void createJTree(File selectedFile, File[] ListFiles) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        menu.add(open_item);
        menu.add(exit_item);
        bar.add(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(5000,5000));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        

    }

    /**
     * Initialize the contents of the frame.
     */

    private  DrawByGraphics drawUML(dataClass data) {
        //frame.setSize(new Dimension(5000,5000));
        final DrawByGraphics container = new DrawByGraphics();
        // container.addLine(0, 0,1000,1000 );
        // container.addLine(10,10 ,1000,1000);
        //container.DrawLineX(0,0,500,500);

        //container.DrawLineX(0,0,200,200);
        // if(tmp!=null)
        //     tmp.drawLine(0, 0, 500, 500);
        container.setLayout(null);
        
        
        container.setPreferredSize(new Dimension(5000,5000));
        ArrayList<classObject> noExtendsClassTest = this.noExtendsClass(data.getList());
        int y = 0;
        ArrayList<classObject> tmpGradeChild = this.ExtendsClass(data.getList());
        ArrayList<classObject> tmpGrade = this.noExtendsClass(data.getList());
        ArrayList<vector> linesExtends = new ArrayList<vector>();
        ArrayList<vector> linesImplements = new ArrayList<vector>();
        int countClass = data.getList().size();

        for(int grade = 0 ; countClass >0 ;){

            if(grade == 0){

                grade++;
                int  x = 200;
                countClass = countClass - noExtendsClassTest.size();

                for(classObject test:noExtendsClassTest){

                    if(!test.getIsInterface()){
                        int s = test.print().size();
                        JList list = new JList<String>(test.print());
                        list.setBorder(BorderFactory.createLineBorder(Color.RED));
                        list.setCellRenderer(getRenderer());
                        list.setBounds(x,y,300,s*18);
                        int[] inta = new int[]{x,y+s*9};
                        test.setLocation(inta);
                        container.add(list);
                        x +=500;
                    }

//                    if(test.getIsInterface()){
//                        int s = test.print().size();
//                        JList list = new JList<String>(test.print());
//                        list.setBorder(BorderFactory.createLineBorder(Color.RED));
//                        list.setCellRenderer(getRenderer());
//                        list.setBounds(x,y,300,s*18);
//                        int[] inta = new int[]{x,y+s*9};
//                        test.setLocation(inta);
//                        container.add(list);
//                        x +=500;
//                    }

                }
                
                for(classObject test:noExtendsClassTest){
                    if(test.getIsInterface()){
                        int s = test.print().size();
                        JList list = new JList<String>(test.print());
                        list.setBorder(BorderFactory.createLineBorder(Color.RED));
                        list.setCellRenderer(getRenderer());
                        list.setBounds(x,y,300,s*18);
                        int[] inta = new int[]{x,y+s*9};
                        test.setLocation(inta);
                        container.add(list);
                        x +=500;
                    }
                }


            }else{
//                    int  x = 200;
//                    ArrayList<classObject> currentGrade = new ArrayList<classObject>();
//
//                       for(int i = 0 ; i < tmpGrade.size(); i++){
//
//                            classObject father = tmpGrade.get(i);
//                            for(int j = 0 ; j < tmpGradeChild.size() ; j++){
//
//                                classObject child = tmpGradeChild.get(j);
//
//                                if(child.getFatherName()!=null)
//                                    if(child.getFatherName().equals(father.getClassName())){
//                                        
//                                        linesExtends.add(new vector(200+500*i+150,
//                                                                    y-getMaxHeight(data)*18 - 150+father.print().size()*18,
//                                                                    x+150,y));
//
//                                        currentGrade.add(child);
//                                        int s = child.print().size();
//                                        JList list = new JList<String>(child.print());
//                                        list.setBorder(BorderFactory.createLineBorder(Color.RED));
//                                        list.setCellRenderer(getRenderer());
//                                        list.setBounds(x,y,300,s*18);
//                                        int[] inta = new int[]{x,y+s*9};
//                                        child.setLocation(inta);
//                                        container.add(list);
//
//                                        for(int k = 0 ; k < noExtendsClassTest.size() ; k++){
//                                            classObject interfaceClass = noExtendsClassTest.get(k);
//                                            if(child.getImplementsName()!=null)
//                                            if(child.getImplementsName().contains(interfaceClass.getClassName())){
//                                                   
//                                                linesImplements.add(new vector(200 + 500*k + 300,
//                                                                                interfaceClass.print().size()*9,
//                                                                                x+300,
//                                                                                y+child.print().size()*9));
//
//                                    }
//                                        }
//                                        x +=500;
//
//                                    }
//
//                                
//
//                            }
//                       }
//
//                    countClass = countClass - currentGrade.size();
//                    tmpGradeChild = this.ExtendsClass(data.getList());
//                    tmpGrade = currentGrade;

                    int  x = 200;
                    ArrayList<classObject> currentGrade = new ArrayList<classObject>();

                       for(int i = 0 ; i < tmpGrade.size(); i++){

                            classObject father = tmpGrade.get(i);
                            for(int j = 0 ; j < tmpGradeChild.size() ; j++){

                                classObject child = tmpGradeChild.get(j);

                                if(child.getFatherName()!=null)
                                    if(child.getFatherName().equals(father.getClassName())){
                                        int[] fint = father.getLocation();
                                        linesExtends.add(new vector(fint[0]+150,
                                                                    fint[1]+father.print().size()*9,
                                                                    x+150,y));

                                        currentGrade.add(child);
                                        int s = child.print().size();
                                        JList list = new JList<String>(child.print());
                                        list.setBorder(BorderFactory.createLineBorder(Color.RED));
                                        list.setCellRenderer(getRenderer());
                                        list.setBounds(x,y,300,s*18);
                                        int[] inta = new int[]{x,y+s*9};
                                        child.setLocation(inta);
                                        container.add(list);

                                        for(int k = 0 ; k < noExtendsClassTest.size() ; k++){
                                            classObject interfaceClass = noExtendsClassTest.get(k);
                                            if(child.getImplementsName()!=null)
                                            if(child.getImplementsName().contains(interfaceClass.getClassName())){
                                                   
                                                linesImplements.add(new vector(200 + 500*k + 300,
                                                                                interfaceClass.print().size()*9,
                                                                                x+300,
                                                                                y+child.print().size()*9));

                                    }
                                        }
                                        x +=500;

                                    }

                                

                            }
                       }

                    countClass = countClass - currentGrade.size();
                    tmpGradeChild = this.ExtendsClass(data.getList());
                    tmpGrade = currentGrade;
            }
            y += getMaxHeight(data)*18 + 150;
        }
        ArrayList<vector> linesHas = new ArrayList<vector>();
        ArrayList<vector> linesIs = new ArrayList<vector>();
        for(int i = 0 ; i < data.getList().size() ; i++){
            
            
            classObject ContainerClass = data.getList().get(i);
            for( String type: ContainerClass.getNameClassHas_is()){
                
                
                for(int j = 0 ; j < data.getList().size() ;j++){
                    
                    
                    classObject componentClass = data.getList().get(j);
                    if(i!=j){
                        if(type!=null&&componentClass.getClassName()!=null)
                        if(type.contains(componentClass.getClassName())){
                            
                            if(type.contains("HasA")){
                                int [] inta = ContainerClass.getLocation();
                                int [] intb = componentClass.getLocation();
                                linesHas.add(new vector(inta[0],inta[1],intb[0],intb[1]));
                            }
                            else{
                                int [] inta = ContainerClass.getLocation();
                                int [] intb = componentClass.getLocation();
                                linesIs.add(new vector(inta[0],inta[1],intb[0],intb[1]));
                            }
                        }
                    }        
            }
            }
            
        }
        container.setLinesToDraw(linesExtends,linesImplements,linesHas,linesIs,getMaxHeight(data)*18,y);
        
        
        return container;
    }
    public int getMaxHeight(dataClass data){
        int height = 0;
        for(classObject test: data.getList()){
            if(test.print().size() >= height)
                height = test.print().size();

        }
        return height;
    }
    public ArrayList<classObject> noExtendsClass(ArrayList<classObject> data){
        ArrayList<classObject> list = new ArrayList<classObject>();
        for(classObject a:data){
            if((!a.getIsExtends())&&(!a.isIsImplementsed())){
                list.add(a);
            }
        }
        return list;
    }
    public ArrayList<classObject> ExtendsClass(ArrayList<classObject> data){

        ArrayList<classObject> list = new ArrayList<classObject>();
        for(classObject a:data){
            if(a.getIsExtends()){
                list.add(a);
            }
        }
        return list;
    }
    public ArrayList<classObject> GetChildClass(ArrayList<classObject> father,dataClass data){

        ArrayList<classObject> list = new ArrayList<classObject>();
        for(classObject a:father){
            for(classObject b:data.getList()){
                if(a.getClassName().equals(b.getFatherName())){
                    list.add(b);
                }
            }
        }
        return list;
    }
    private ListCellRenderer<? super String> getRenderer() {
        
    return new DefaultListCellRenderer() {

      @Override
      public Component getListCellRendererComponent(JList<?> list,Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
        listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0,0, 1, 0, Color.BLACK));
        return listCellRendererComponent;

      }
    };
  }
    
    
    private JScrollPane creatJTree(File root , File[] Child){
        DefaultMutableTreeNode rootTree = new DefaultMutableTreeNode(root.getName());
        ArrayList<DefaultMutableTreeNode> chidren = new ArrayList<DefaultMutableTreeNode>() ;
        for(File child : Child){
            chidren.add(new DefaultMutableTreeNode (child.getName()));
        }
        for(DefaultMutableTreeNode childTmp:chidren){
            rootTree.add(childTmp);
        }
        JTree tree = new JTree(rootTree);
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setViewportView(tree);
        scrollpane.setPreferredSize(new Dimension(180,5000));
        return scrollpane;
    }
}