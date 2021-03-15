import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
  
class ButtonDemo implements ActionListener {  
  JLabel jlab;
  ImageIcon thumbUp, thumbDown;
 
  ButtonDemo() { 
    thumbUp = new ImageIcon("assets/thumbs-up-icon.png");
    thumbDown = new ImageIcon("assets/thumbs-down-icon.png");

    // Create a new JFrame container. 
    JFrame jfrm = new JFrame("A Button Example"); 
 
    // Specify FlowLayout for the layout manager. 
    jfrm.setLayout(new FlowLayout()); 
 
    // Give the frame an initial size. 
    jfrm.setSize(500, 350); 
 
    // Terminate the program when the user closes the application. 
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
    // Make two buttons. 
    JButton jbtnUp = new JButton("Up"); 
    JButton jbtnDown = new JButton("Down"); 
 
    // Add action listeners. 
    jbtnUp.addActionListener(this); 
    jbtnDown.addActionListener(this); 
 
    // Add the buttons to the content pane. 
    jfrm.add(jbtnUp);  
    jfrm.add(jbtnDown);  
 
    // Create a label. 
    jlab = new JLabel("Press a button."); 
 
    // Add the label to the frame. 
    jfrm.add(jlab); 
 
    // Display the frame. 
    jfrm.setVisible(true); 
  } 
 
  // Handle button events. 
  public void actionPerformed(ActionEvent ae) { 
    if(ae.getActionCommand().equals("Up"))  
      jlab.setIcon(thumbUp);
    else 
      jlab.setIcon(thumbDown);
  } 
 
  public static void main(String args[]) { 
    // Create the frame on the event dispatching thread. 
    SwingUtilities.invokeLater(new Runnable() { 
      public void run() { 
        new ButtonDemo(); 
      } 
    }); 
  } 
}