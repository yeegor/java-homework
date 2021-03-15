import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout;

class FontNamesDemo {
    JLabel label;
 
    FontNamesDemo() { 
        // Create a new JFrame container. 
        JFrame frame = new JFrame("Fonts!"); 
    
        // Specify FlowLayout for the layout manager. 
        frame.setLayout(new GridLayout(10, 2)); 
    
        // Give the frame an initial size. 
        frame.setSize(500, 350); 
    
        // Terminate the program when the user closes the application. 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
        this.paint(frame);
        
        // Display the frame. 
        frame.setVisible(true); 
    }

    /**
     * paint() is called automatically to paint the JApplet each time it needs it.
     * Note the use of vRef and vGap to space the fonts.
     */
    public void paint(JFrame frame) {
        // Get the font names available in this graphics environment
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = graphicsEnvironment.getAvailableFontFamilyNames();

        JTextField textField = new JTextField();
        textField.setEditable( false );
        textField.setHorizontalAlignment(JTextField.RIGHT);

        for (int i = fonts.length - 1; i > fonts.length - 11; i--) {
            JLabel fontname = new JLabel(fonts[i]);

            JLabel text = new JLabel("Hello world!", null, JLabel.CENTER);
            text.setFont(new Font(fonts[i], Font.PLAIN, 20));

            frame.add(text);
            frame.add(fontname);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FontNamesDemo();
            }
        });
    }
}
