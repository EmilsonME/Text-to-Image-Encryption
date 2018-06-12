package textfileencryption;

import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import static java.awt.SystemColor.scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * @author Emilson B. Olaño
 */
public class TextFileEncryption extends JFrame {

    private PixelRepresentation objPixel;
    private String fileData, imagePath, filename, filename2;
    private JPanel contentPanel, headPanel, show, show2;
    private JButton minBtn, closeBtn, openBtn, openImage, encryptBtn, decryptBtn, encryptionOption, decryptionOption, backBtn, backBtn2;
    private JLabel headLbl, filenamelbl, filenamelbl2;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private BufferedImage decryptImage;
    public JFrame frame, frame2, frame3;

    public TextFileEncryption() {
        super("Encryption");
        frame = new JFrame();
        frame.setBounds(0, 0, 500, 500);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setVisible(true);
        
        Customize custom = new Customize(500,frame);
        frame.setContentPane(custom.contentPanel);
        
        encryptionOption = new JButton(new ImageIcon("Images/encrypt.png"));
        encryptionOption.setBounds(145, 175, 200, 70);
        encryptionOption.setRolloverIcon(new ImageIcon("Images/encrypt2.png"));
        encryptionOption.setFocusPainted(false);
        encryptionOption.setBorder(null);
        encryptionOption.setContentAreaFilled(false);
        encryptionOption.setCursor(new Cursor(Cursor.HAND_CURSOR));
        custom.contentPanel.add(encryptionOption);

        decryptionOption = new JButton(new ImageIcon("Images/decrypt.png"));
        decryptionOption.setRolloverIcon(new ImageIcon("Images/decrypt2.png"));
        decryptionOption.setBounds(145, 255, 200, 70);
        decryptionOption.setFocusPainted(false);
        decryptionOption.setBorder(null);
        decryptionOption.setContentAreaFilled(false);
        decryptionOption.setCursor(new Cursor(Cursor.HAND_CURSOR));
        custom.contentPanel.add(decryptionOption);

        backBtn = new JButton(new ImageIcon("Images/back.png"));
        backBtn.setRolloverIcon(new ImageIcon("Images/back.png"));
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn.setFocusPainted(false);
        backBtn.setBorder(null);
        backBtn.setContentAreaFilled(false);
        backBtn.setBounds(649, 600, 50, 50);

        backBtn2 = new JButton(new ImageIcon("Images/back.png"));
        backBtn2.setRolloverIcon(new ImageIcon("Images/back.png"));
        backBtn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn2.setFocusPainted(false);
        backBtn2.setBorder(null);
        backBtn2.setContentAreaFilled(false);
        backBtn2.setBounds(649, 600, 50, 50);
        
        
        frame2 = new JFrame("Encrypt a text file");
        Customize custom2 = new Customize(730, frame2);
        frame2.setSize(730, 658);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(null);
        frame2.setLocationRelativeTo(null);
        frame2.setBackground(Color.decode("#B0E2FF"));
        frame2.setVisible(false);
        frame2.setUndecorated(true);
        frame2.setContentPane(custom2.contentPanel);

        filenamelbl = new JLabel("Encrypt a Text File");
        filenamelbl.setFont(new Font("Open Sans", Font.BOLD, 14));
        filenamelbl.setBounds(290, 70, 450, 20);
        frame2.add(filenamelbl);

        show = new JPanel();
        show.setLayout(null);
        show.setBackground(Color.white);
        show.setBounds(5, 110, 720, 480);

        openBtn = new JButton(new ImageIcon("Images/addBtnhover.jpg"));
        openBtn.setBounds(300, 180, 100, 100);
        openBtn.setBorder(null);
        openBtn.setRolloverIcon(new ImageIcon("Images/addBtn.jpg"));
        openBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        openBtn.setFocusPainted(false);
        openBtn.setContentAreaFilled(false);
        show.add(openBtn);

        encryptBtn = new JButton(new ImageIcon("Images/lock.png"));
        encryptBtn.setRolloverIcon(new ImageIcon("Images/unlock.png"));
        encryptBtn.setToolTipText("Encrypt now");
        encryptBtn.setEnabled(false);
        encryptBtn.setFocusPainted(false);
        encryptBtn.setBorder(null);
        encryptBtn.setContentAreaFilled(false);
        encryptBtn.setBounds(555, 597,  50, 50);

        //frame2.add(openBtn);
        frame2.add(encryptBtn);
        frame2.add(backBtn);
        frame2.add(show);
        
        
        frame3 = new JFrame("Decrypt an image file");
        Customize custom3 = new Customize(730,frame3);
        frame3.setSize(730, 658);;
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLayout(null);
        frame3.setLocationRelativeTo(null);
        frame3.setBackground(Color.decode("#B0E2FF"));
        frame3.setVisible(false);
        frame3.setUndecorated(true);
        frame3.setContentPane(custom3.contentPanel);

        filenamelbl2 = new JLabel("Decrypt an image");
        filenamelbl2.setFont(new Font("Open Sans", Font.BOLD, 14));
        filenamelbl2.setBounds(290, 70, 450, 20);
        frame3.add(filenamelbl2);

        show2 = new JPanel();
        show2.setLayout(null);
        show2.setBackground(Color.white);
        show2.setBounds(5, 110, 720, 480);
        
        openImage = new JButton(new ImageIcon("Images/addBtnhover.jpg"));
        openImage.setBounds(300, 180, 100, 100);
        openImage.setBorder(null);
        openImage.setRolloverIcon(new ImageIcon("Images/addBtn.jpg"));
        openImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        openImage.setToolTipText("Open a text file");
        openImage.setContentAreaFilled(false);
        show2.add(openImage);

        decryptBtn = new JButton(new ImageIcon("Images/unlock.png"));
        decryptBtn.setRolloverIcon(new ImageIcon("Images/lock.png"));
        decryptBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        decryptBtn.setToolTipText("Decrypt now");
        decryptBtn.setFocusPainted(false);
        decryptBtn.setBorder(null);
        decryptBtn.setContentAreaFilled(false);
        decryptBtn.setBounds(555, 597,  50, 50);
        decryptBtn.setEnabled(false);

        frame3.add(decryptBtn);
        frame3.add(backBtn2);
        frame3.add(show2);

        encryptionOption.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
//            frame.setContentPane(new JPanel());
//            frame2.setContentPane(contentPanel);
            frame2.setVisible(true);
        });

        decryptionOption.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
            frame3.setVisible(true);
        });

        backBtn.addActionListener((ActionEvent e) -> {
            frame.setVisible(true);
            frame3.dispose();
            frame2.dispose();
        });
        backBtn2.addActionListener((ActionEvent e) -> {
            frame.setVisible(true);
            frame3.dispose();
            frame2.dispose();
        });

        openBtn.addActionListener((ActionEvent e) -> {
            JFileChooser openFile = new JFileChooser();
            LookAndFeel previousLF = UIManager.getLookAndFeel();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                openFile = new JFileChooser();
                UIManager.setLookAndFeel(previousLF);
            } catch (Exception ex) {
            }
            //Add whatever other settings you want to the method

            FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
            openFile.setFileFilter(filter);
            int returnVal = openFile.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
//                   System.out.println("Selected file: " + openFile.getSelectedFile().getAbsolutePath());
                try {
                    getFileData(openFile.getSelectedFile().getAbsolutePath(), openFile.getSelectedFile().getName());
                    filenamelbl.setText(openFile.getSelectedFile().getName());

                    encryptBtn.setEnabled(true);
                    //openBtn.setVisible(false);
                   
                    openBtn.setBounds(553, 597, 50, 50);
                    openBtn.setIcon(new ImageIcon("Images/open.png"));
                    openBtn.setRolloverIcon(new ImageIcon("Images/open.png"));
                    frame2.add(openBtn);
                    encryptBtn.setBounds(446, 597, 50, 50);
                    
                    textArea = new JTextArea();
                    textArea.setText(fileData);
                    textArea.setBounds(0, 0, 720, 630);
                    textArea.setFont(new Font("Open Sans", Font.PLAIN, 12));
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);

                    scrollPane = new JScrollPane(textArea);
                    scrollPane.setBounds(0, 0, 720, 480);
                    scrollPane.getVerticalScrollBar().setOpaque(false);
                    scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
                    show.add(scrollPane);

                    show.repaint();
                    frame2.repaint();
                } catch (IOException exp) {
                    exp.printStackTrace();
                }

            }
        });

        encryptBtn.addActionListener((ActionEvent action) -> {
            System.out.println(fileData.length());
            Image image = createEncryptedImage(fileData);
            encryptBtn.setEnabled(false);
        });

        openImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser openFile = new JFileChooser();
                LookAndFeel previousLF = UIManager.getLookAndFeel();
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    openFile = new JFileChooser();
                    UIManager.setLookAndFeel(previousLF);
                } catch (Exception ex) {
                }
                FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "png");
                openFile.setFileFilter(filter);
                int returnVal = openFile.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
//                   System.out.println("Selected file: " + openFile.getSelectedFile().getAbsolutePath());
                    try {
                        setImage(openFile.getSelectedFile().getAbsolutePath(), openFile.getSelectedFile().getName());
                        filenamelbl2.setText(openFile.getSelectedFile().getName());
                        decryptBtn.setEnabled(true);
                        openImage.setIcon(new ImageIcon("Images/open.png"));
                        openImage.setRolloverIcon(new ImageIcon("Images/open.png"));
                        openImage.setBounds(553, 597, 50, 50);
                        frame3.add(openImage);
                        decryptBtn.setBounds(446, 597, 50, 50);
                        try {
                            BufferedImage img = ImageIO.read(new File(imagePath));
                            ImageIcon icon = new ImageIcon(img);
                            JLabel label = new JLabel("", icon, JLabel.CENTER);
                            label.setBounds(0, 0, 704, 480);
                            show2.add(label);
                        } catch (Exception ex) {
                        }
                        show2.revalidate();
                        show2.repaint();

                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }

                }
            }
        });
        decryptBtn.addActionListener((ActionEvent e) -> {
            decryptImage(imagePath);
            decryptBtn.setEnabled(false);
        });

        frame.revalidate();
        frame.repaint();

        objPixel = new PixelRepresentation();

    }

    public void minimize() {
        frame.setExtendedState(JFrame.ICONIFIED);
    }

    public void close() {
        frame.dispose();
        System.exit(0);
    }

    public void setFile(String docu, String filename) {
        this.fileData = docu;
        this.filename2 = filename;
    }

    public void setImage(String path, String filename) {
        this.imagePath = path;
        this.filename = filename;
    }

    public void getFileData(String filepath, String filename) throws IOException {
        FileReader input = null;
        ArrayList<String> temp = new ArrayList<String>();
        try {
            input = new FileReader(filepath);

            BufferedReader bufferedReader = new BufferedReader(input, 1000 * 8192);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                temp.add(line);
                //System.out.println(line);
            }
            String temp2 = String.join("\n", temp);
            //System.out.println(temp2);
            setFile(temp2, filename);

        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public Image createEncryptedImage(String file) {

        int counter = 0;
        int length = file.length();
        int dimension = (int) Math.ceil(Math.sqrt(length));
        System.out.println("Length: " + length + " dimension " + dimension);
        BufferedImage image = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_ARGB);

        for (int yCoor = 0; yCoor < dimension; yCoor++) {
            for (int xCoor = 0; xCoor < dimension && counter < file.length(); xCoor++, counter++) {
                Color pixel = objPixel.getPixelColor(Character.toString(file.charAt(counter)));
                image.setRGB(xCoor, yCoor, pixel.getRGB());
            }
        }
        saveToFile(image, dimension);
        return image;
    }

    public void decryptImage(String filepath) {
        ArrayList<String> temp = new ArrayList<String>();
        try {
            decryptImage = ImageIO.read(new File(filepath));
            String hex, letter;
            for (int yCoor = 0; yCoor < decryptImage.getHeight(); yCoor++) {
                for (int xCoor = 0; xCoor < decryptImage.getWidth(); xCoor++) {
                    hex = Integer.toHexString(decryptImage.getRGB(xCoor, yCoor) & 0xffffff);
                    if (hex.length() < 6) {
                        if (hex.length() == 5) {
                            hex = "0" + hex;
                        }
                        if (hex.length() == 4) {
                            hex = "00" + hex;
                        }
                        if (hex.length() == 3) {
                            hex = "000" + hex;
                        }
                    }
                    hex = "#" + hex;
                    letter = objPixel.getCharacter(hex.toUpperCase());
                    //System.out.println("Letter " + letter + " hex: " + hex);
                    temp.add(letter);

                }

            }
            String temp2;
            temp2 = String.join("", temp);

            JTextArea txtArea = new JTextArea();
            txtArea.setText(temp2);
            txtArea.setBounds(0, 0, 1000, 1200);
            txtArea.setFont(new Font("Open Sans", Font.PLAIN, 12));
            txtArea.setLineWrap(true);
            txtArea.setWrapStyleWord(true);

            JScrollPane scrollPanel = new JScrollPane(txtArea);
            scrollPanel.setBounds(0, 0, 1000, 1200);
            scrollPanel.getVerticalScrollBar().setOpaque(false);
            scrollPanel.getVerticalScrollBar().setUI(new MyScrollBarUI());

            JFrame pictureFrame = new JFrame(filename);
            pictureFrame.setSize(1000, 1200);
            pictureFrame.setLayout(null);
            pictureFrame.setLocationRelativeTo(null);
            pictureFrame.setResizable(false);
            pictureFrame.setVisible(true);
            pictureFrame.add(scrollPanel);
            pictureFrame.revalidate();
            pictureFrame.repaint();

            filename = filename.replace("(Encrypted)", "(Decrypted)");
            PrintWriter pw = new PrintWriter("DecryptedFiles/" + filename + ".txt", "ASCII");
            pw.write(temp2);
            pw.close();

        } catch (IOException e) {
        }
    }

    public void saveToFile(BufferedImage img, int dimension) {
        try {
            String newFile = "EncryptedImages/" + filename2 + "(Encrypted).png";
            File outputFile = new File(newFile);
            outputFile.createNewFile();
            ImageIO.write(img, "png", outputFile);

            ImageIcon icon = new ImageIcon(newFile);
            JLabel label = new JLabel("", icon, JLabel.CENTER);
            label.setBounds(0, 0, dimension, dimension);

            JFrame pictureFrame = new JFrame(filename2);
            pictureFrame.setLayout(null);
            pictureFrame.setLocationRelativeTo(null);
            pictureFrame.setSize(dimension, dimension);
            pictureFrame.setResizable(false);
            pictureFrame.setVisible(true);
            pictureFrame.add(label);
            pictureFrame.revalidate();
            pictureFrame.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyScrollBarUI extends BasicScrollBarUI {

        private final Dimension d = new Dimension();

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return d;
                }
            };
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return d;
                }
            };
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            Color color = null;
            JScrollBar sb = (JScrollBar) c;
            if (!sb.isEnabled() || r.width > r.height) {
                return;
            } else if (isDragging) {
                color = Color.DARK_GRAY;
            } else if (isThumbRollover()) {
                color = Color.LIGHT_GRAY;
            } else {
                color = Color.GRAY;
            }
            g2.setPaint(color);
            g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
            g2.setPaint(Color.WHITE);
            g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
            g2.dispose();
        }

        @Override
        protected void setThumbBounds(int x, int y, int width, int height) {
            super.setThumbBounds(x, y, width, height);
            scrollbar.repaint();
        }
    }

    public static void main(String[] args) {

        TextFileEncryption objFrame = new TextFileEncryption();

    }

}
