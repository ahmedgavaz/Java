package Non_Simple_Version;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
import Non_Simple_Version.Management.BoatManager;
import Non_Simple_Version.Management.TouristManager;
import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Tourist;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * User Interface class, it executes how the visual application will look like.
 *
 * @author Daniela Dolenska
 */
public class BoatManagement extends javax.swing.JFrame {

    /**
     * Creates new form NewApplication
     */
    static int infoEditCount=0;
    static String[] settingFields = new String[3];
    static String oldType = "";
    static int oldCapacity = 0;
    static double oldPrice = 0;
    static String oldName = "";
    static boolean oldDrivingLicense = false;
    static String oldDestination = "";
    String titleName=settingFields[0]+ " " +settingFields[1];        

    /**
     * Thee constructor sets the size of the window, the photo background is set
     * and the other dialog windows are set invisible.
     */
    //Проверява за съществуването на файловете за лодките,туристите и настройките
    //Ако има файлове за лодките и туристите, прочита обектите от файловете и ги записва в таблиците
    //Ако има файл за настройките, се зарежда последната версия на полета на менюто за настройки
    //ако няма такъв файл се създава.
    //Взима се най-голямото ИД на елемнтите от съответния списък и при добавяне на елемент, той получава ИД с единица повече
    public BoatManagement() {
        initComponents();
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon(this.getClass().getResource("Spanish-coast-sebastus-1024x683.png"));
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 700, 600);
        add(background); //the picture is added as a backgroud
        addBoatDialog.setVisible(false); //the boat and tourist panels are set invisible, as well as the other dialogs
        deleteBoatDialog.setVisible(false);
        boatPanel.setVisible(false);
        touristPanel.setVisible(false);
        setVisible(true);
        this.setLocationRelativeTo(null); //the window is centered on the screen
        File settingsFile = new File("Settings.txt");
        File boatsFile = new File("boats.txt");
        File touristsFile = new File("tourists.txt");
        if (!settingsFile.exists()){
            creatingSettingFIle();
        }else{
            gettingLastSetting();
        }
        this.titleName = settingFields[0]+ " " +settingFields[1];
        setTitle(titleName);
        if (boatsFile.exists()){
            List<Boat> boats = readingBoats();
            BoatManager.getBoats().addAll(boats);
            Boat.count=BoatManager.getBoats().get(BoatManager.getBoats().size()-1).getBoatID()+1;
           readingBoatFile();
        }
        if (touristsFile.exists()){
            List<Tourist> tourists = readingTourists();
            TouristManager.getTourists().addAll(tourists);
            Tourist.count=TouristManager.getTourists().get(TouristManager.getTourists().size()-1).getTouristID()+1;
            readingTouristFile();
        }
    }

    //Създава се файл за настройките с информация за програмата
    public void creatingSettingFIle(){
        try {
            File file = new File("settings.txt");
            FileWriter fw = new FileWriter(file,true);
            fw.write("Original: ");
            fw.write(System.lineSeparator());
            fw.write("BoatManagement");
            settingFields[0]="BoatManagement";
            fw.write(System.lineSeparator());
            fw.write("1.0");
            settingFields[1]="1.0";
            fw.write(System.lineSeparator());
            fw.write("Daniela Dolenska");
            settingFields[2]="Daniela Dolenska";
            fw.write(System.lineSeparator());
            fw.write(System.lineSeparator());
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    //Чете информацията от файла с настройките и чзима последната информация която е била записана в полетата за настройки 
    //и записва тази информация в менюто за настройки
    public void gettingLastSetting(){
        String[] lastThreeLines = new String[5];
        int counter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("Settings.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lastThreeLines[counter % 5] = line;
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        settingFields[0]=lastThreeLines[1];
        settingFields[1]=lastThreeLines[2];
        settingFields[2]=lastThreeLines[3];
        String[] str = lastThreeLines[0].split("\\s+");
        if (str.length!=1){
                 infoEditCount=Integer.parseInt(str[1]);   
        }
    }
    
    //Прочитат се обектите от файла за лодките и се записват обектите във таблицата с лодки
    public void readingBoatFile(){
        List<Boat> boats = readingBoats();
        for(int i=0;i<boats.size();i++){
        DefaultTableModel model = (DefaultTableModel) boatList.getModel();
        Object[] rowData = new Object[4]; //the characteristics of a boat are saved in an array of type object
        rowData[0] = boats.get(i).getBoatID(); //column 1 is the boat id
        rowData[1] = boats.get(i).getBoatType(); //column 2 is the type
        rowData[2] = boats.get(i).getCapacity(); //column 3 is the capaciyt
        rowData[3] = boats.get(i).getPrice();  //column 4 is the price
        model.addRow(rowData); //a row is added in the table that contains the newly created boat
        }    
    }
    
    //Прочитат се обектите от файла за туристите и се записват обектите във таблицата с туристи
    public void readingTouristFile(){
        List<Tourist> tourists = readingTourists();
        for(int i=0;i<tourists.size();i++){
        DefaultTableModel model = (DefaultTableModel) touristList.getModel();
        Object[] rowData = new Object[4]; //the characteristics of a boat are saved in an array of type object
        rowData[0] = tourists.get(i).getTouristID(); //column 1 is the boat id
        rowData[1] = tourists.get(i).getTouristName(); //column 2 is the type
        rowData[2] = tourists.get(i).getBoatDrivingLicense(); //column 3 is the capaciyt
        rowData[3] = tourists.get(i).getDestination();  //column 4 is the price
        model.addRow(rowData); //a row is added in the table that contains the newly created boat
        }    
    }
    
    //Прочитат се обектите от файла със лодките като се записват във лист и този лист се връща в края на метода
public static List<Boat> readingBoats() {
    List<Boat> boats = new ArrayList<>();
    try (FileInputStream fis = new FileInputStream("boats.txt");
         ObjectInputStream ois = new ObjectInputStream(fis)) {
        while (true) {
            try{
                Boat boat = (Boat) ois.readObject();
                boats.add(boat);
            }catch(EOFException eof){
                break;
            }
        }
    } catch (Exception ex) {
        System.out.println("An error occurred while reading boats from file: " + ex.getMessage());
        ex.printStackTrace();
    }
    return boats;
}
    
//Получава се лист с лодки и тези лодки се записват във файла с лодките. 
//Предишните лодки се изтриват и на тяхно място се записва новия списък
    public static void writingBoats(List<Boat> boats) {
        try (FileOutputStream fos = new FileOutputStream("boats.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Boat boat : boats) {
                oos.writeObject(boat);
                oos.flush();
            }
            fos.close();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Прочитат се обектите от файла със туристите като се записват във лист и този лист се връща в края на метода    
public List<Tourist> readingTourists(){
         List<Tourist> tourists = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("tourists.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Tourist tourist;
            while ((tourist = (Tourist) ois.readObject()) != null) {
                tourists.add(tourist);
            }
        } catch (EOFException eof) {
            // end of file reached, this is expected
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tourists;
    }

//Получава се лист с туристи и тези туристи се записват във файла с туристите. 
//Предишните туристи се изтриват и на тяхно място се записва новия списък
public static void writingTourists(List<Tourist> tourists) {
    String fileName = "tourists.txt";
    try (FileOutputStream fos = new FileOutputStream(fileName);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        for (Tourist tourist : tourists) {
            oos.writeObject(tourist);
            oos.flush();
        }
        fos.close();
        oos.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    
//Този метод взима текстовете от менюто за настройки и ги превръща в текста които трябва да пише в менюто About
    public String informationEdit(){
    StringBuilder info= new StringBuilder();
    info.append(settingFields [0]).append(" ").append(settingFields [1]).append(" (C) 2023 ").append(settingFields [2]).append(" Ltd.");
    return info.toString();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorWindow = new javax.swing.JDialog();
        okErrorWindow = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();
        deleteBoatDialog = new javax.swing.JDialog();
        deleteBoatTitle = new javax.swing.JLabel();
        boatIDDeleteLabel = new javax.swing.JLabel();
        boatIDDeleteTextField = new javax.swing.JTextField();
        deleteBoatDeleteDialog = new javax.swing.JButton();
        cancelBoatDeleteDialog = new javax.swing.JButton();
        addBoatDialog = new javax.swing.JDialog();
        boatCapacityLabel = new javax.swing.JLabel();
        boatPriceLabel = new javax.swing.JLabel();
        saveAddingBoatDialog = new javax.swing.JButton();
        cancelAddingBoatDialog = new javax.swing.JButton();
        boatTypeTextField = new javax.swing.JTextField();
        boatPriceTextField = new javax.swing.JTextField();
        boatTypeLabel = new javax.swing.JLabel();
        boatCapacityTextField = new javax.swing.JTextField();
        addBoatTitle = new javax.swing.JLabel();
        confirmBoatDeleteDialog = new javax.swing.JDialog();
        yesConfirmBoatDelete = new javax.swing.JButton();
        noConfirmBoatDelete = new javax.swing.JButton();
        confirmMessageBoat = new javax.swing.JLabel();
        destinationsButtonGroup = new javax.swing.ButtonGroup();
        addTouristDialog = new javax.swing.JDialog();
        addTouristTitle = new javax.swing.JLabel();
        touristNameTextField = new javax.swing.JTextField();
        touristNameLabel = new javax.swing.JLabel();
        drivingLicenseCheckBox = new javax.swing.JCheckBox();
        destinationLabel = new javax.swing.JLabel();
        thasosRadioButton = new javax.swing.JRadioButton();
        samothrakiRadioButton = new javax.swing.JRadioButton();
        lemnosRadioButton = new javax.swing.JRadioButton();
        lesbosRadioButton = new javax.swing.JRadioButton();
        saveAddingTouristDialog = new javax.swing.JButton();
        cancelAddingTouristDialog = new javax.swing.JButton();
        deleteTouristDialog = new javax.swing.JDialog();
        deleteTouristTitle = new javax.swing.JLabel();
        touristIDDeleteLabel = new javax.swing.JLabel();
        touristIDDeleteTextField = new javax.swing.JTextField();
        deleteTouristDeleteDialog = new javax.swing.JButton();
        cancelTouristDeleteDialog = new javax.swing.JButton();
        confirmTouristDeleteDialog = new javax.swing.JDialog();
        yesConfirmTouristDelete = new javax.swing.JButton();
        noConfirmTouristDelete = new javax.swing.JButton();
        confirmMessageTourist = new javax.swing.JLabel();
        SettingMenu = new javax.swing.JDialog();
        SettingsTitle = new javax.swing.JLabel();
        programName = new javax.swing.JLabel();
        programVersion = new javax.swing.JLabel();
        programLicensee = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        versionTextField = new javax.swing.JTextField();
        licenseeTextField = new javax.swing.JTextField();
        settingsSave = new javax.swing.JButton();
        settingsCancel = new javax.swing.JButton();
        boatPanel = new javax.swing.JPanel();
        boatTable = new javax.swing.JScrollPane();
        boatList = new javax.swing.JTable();
        addBoatButton = new javax.swing.JButton();
        cancelBoatButton = new javax.swing.JButton();
        deleteBoatButton = new javax.swing.JButton();
        titleBoatLabel = new javax.swing.JLabel();
        touristPanel = new javax.swing.JPanel();
        touristTable = new javax.swing.JScrollPane();
        touristList = new javax.swing.JTable();
        addTouristButton = new javax.swing.JButton();
        cancelTouristButton = new javax.swing.JButton();
        deleteTouristButton = new javax.swing.JButton();
        titleTouristLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitProgramMenuItem = new javax.swing.JMenuItem();
        Settings = new javax.swing.JMenuItem();
        basicDataMenu = new javax.swing.JMenu();
        boatMenuItem = new javax.swing.JMenuItem();
        touristMenuItem = new javax.swing.JMenuItem();
        bookingMenuItem = new javax.swing.JMenuItem();
        employeeMenuItem = new javax.swing.JMenuItem();
        extraMenuItem = new javax.swing.JMenuItem();
        voucherMenuItem = new javax.swing.JMenuItem();
        maintenanceMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        errorWindow.setTitle("Error");
        errorWindow.setLocation(new java.awt.Point(150, 200));
        errorWindow.setResizable(false);
        errorWindow.setSize(new java.awt.Dimension(350, 150));

        okErrorWindow.setText("OK");
        okErrorWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okErrorWindowActionPerformed(evt);
            }
        });

        errorMessage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout errorWindowLayout = new javax.swing.GroupLayout(errorWindow.getContentPane());
        errorWindow.getContentPane().setLayout(errorWindowLayout);
        errorWindowLayout.setHorizontalGroup(
            errorWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorWindowLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(errorWindowLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(okErrorWindow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        errorWindowLayout.setVerticalGroup(
            errorWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, errorWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(okErrorWindow)
                .addGap(27, 27, 27))
        );

        deleteBoatDialog.setTitle("Delete boat");
        deleteBoatDialog.setLocation(new java.awt.Point(250, 200));
        deleteBoatDialog.setResizable(false);
        deleteBoatDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                deleteBoatDialogComponentHidden(evt);
            }
        });
        deleteBoatDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                deleteBoatDialogWindowClosing(evt);
            }
        });

        deleteBoatTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteBoatTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteBoatTitle.setText("Delete Boat");

        boatIDDeleteLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boatIDDeleteLabel.setText("Enter the id of the boat:");

        boatIDDeleteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boatIDDeleteTextFieldActionPerformed(evt);
            }
        });

        deleteBoatDeleteDialog.setText("Delete");
        deleteBoatDeleteDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBoatDeleteDialogActionPerformed(evt);
            }
        });

        cancelBoatDeleteDialog.setText("Cancel");
        cancelBoatDeleteDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBoatDeleteDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteBoatDialogLayout = new javax.swing.GroupLayout(deleteBoatDialog.getContentPane());
        deleteBoatDialog.getContentPane().setLayout(deleteBoatDialogLayout);
        deleteBoatDialogLayout.setHorizontalGroup(
            deleteBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBoatDialogLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(deleteBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boatIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBoatTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(deleteBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(deleteBoatDialogLayout.createSequentialGroup()
                            .addComponent(deleteBoatDeleteDialog)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelBoatDeleteDialog))
                        .addComponent(boatIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        deleteBoatDialogLayout.setVerticalGroup(
            deleteBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBoatDialogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(deleteBoatTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boatIDDeleteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boatIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(deleteBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBoatDeleteDialog)
                    .addComponent(cancelBoatDeleteDialog))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        addBoatDialog.setTitle("Add boat");
        addBoatDialog.setLocation(new java.awt.Point(250, 200));
        addBoatDialog.setResizable(false);
        addBoatDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                addBoatDialogWindowClosing(evt);
            }
        });

        boatCapacityLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boatCapacityLabel.setText("Enter boat capacity:");

        boatPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boatPriceLabel.setText("Enter boat price:");

        saveAddingBoatDialog.setText("Save");
        saveAddingBoatDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAddingBoatDialogActionPerformed(evt);
            }
        });

        cancelAddingBoatDialog.setText("Cancel");
        cancelAddingBoatDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddingBoatDialogActionPerformed(evt);
            }
        });

        boatTypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boatTypeTextFieldActionPerformed(evt);
            }
        });

        boatTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boatTypeLabel.setText("Enter boat type:");

        addBoatTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addBoatTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addBoatTitle.setText("Add Boat");

        javax.swing.GroupLayout addBoatDialogLayout = new javax.swing.GroupLayout(addBoatDialog.getContentPane());
        addBoatDialog.getContentPane().setLayout(addBoatDialogLayout);
        addBoatDialogLayout.setHorizontalGroup(
            addBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addBoatDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBoatTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addBoatDialogLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(addBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(addBoatDialogLayout.createSequentialGroup()
                                .addComponent(saveAddingBoatDialog)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                                .addComponent(cancelAddingBoatDialog))
                            .addComponent(boatTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boatCapacityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boatPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boatCapacityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(boatPriceTextField)
                            .addComponent(boatTypeTextField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addBoatDialogLayout.setVerticalGroup(
            addBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addBoatDialogLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(addBoatTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boatTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boatTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boatCapacityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boatCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boatPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boatPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addBoatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAddingBoatDialog)
                    .addComponent(cancelAddingBoatDialog))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        confirmBoatDeleteDialog.setTitle("Confirm boat deletion");
        confirmBoatDeleteDialog.setLocation(new java.awt.Point(250, 200));
        confirmBoatDeleteDialog.setResizable(false);
        confirmBoatDeleteDialog.setSize(new java.awt.Dimension(350, 250));

        yesConfirmBoatDelete.setText("Yes");
        yesConfirmBoatDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesConfirmBoatDeleteActionPerformed(evt);
            }
        });

        noConfirmBoatDelete.setText("No");
        noConfirmBoatDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noConfirmBoatDeleteActionPerformed(evt);
            }
        });

        confirmMessageBoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmMessageBoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmMessageBoat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout confirmBoatDeleteDialogLayout = new javax.swing.GroupLayout(confirmBoatDeleteDialog.getContentPane());
        confirmBoatDeleteDialog.getContentPane().setLayout(confirmBoatDeleteDialogLayout);
        confirmBoatDeleteDialogLayout.setHorizontalGroup(
            confirmBoatDeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmBoatDeleteDialogLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(confirmMessageBoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
            .addGroup(confirmBoatDeleteDialogLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(yesConfirmBoatDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(noConfirmBoatDelete)
                .addGap(32, 32, 32))
        );
        confirmBoatDeleteDialogLayout.setVerticalGroup(
            confirmBoatDeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmBoatDeleteDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(confirmMessageBoat, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(confirmBoatDeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noConfirmBoatDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesConfirmBoatDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        addTouristDialog.setTitle("Add tourist");
        addTouristDialog.setLocation(new java.awt.Point(250, 200));
        addTouristDialog.setResizable(false);
        addTouristDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                addTouristDialogWindowClosing(evt);
            }
        });

        addTouristTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addTouristTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addTouristTitle.setText("Add Tourist");

        touristNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                touristNameTextFieldActionPerformed(evt);
            }
        });

        touristNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        touristNameLabel.setText("Enter tourist name:");

        drivingLicenseCheckBox.setText("Tourist has driving license");

        destinationLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        destinationLabel.setText("Choose destination:");

        destinationsButtonGroup.add(thasosRadioButton);
        thasosRadioButton.setText("Thasos");

        destinationsButtonGroup.add(samothrakiRadioButton);
        samothrakiRadioButton.setText("Samothraki");

        destinationsButtonGroup.add(lemnosRadioButton);
        lemnosRadioButton.setText("Lemnos");
        lemnosRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lemnosRadioButtonActionPerformed(evt);
            }
        });

        destinationsButtonGroup.add(lesbosRadioButton);
        lesbosRadioButton.setText("Lesbos");

        saveAddingTouristDialog.setText("Save");
        saveAddingTouristDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAddingTouristDialogActionPerformed(evt);
            }
        });

        cancelAddingTouristDialog.setText("Cancel");
        cancelAddingTouristDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddingTouristDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addTouristDialogLayout = new javax.swing.GroupLayout(addTouristDialog.getContentPane());
        addTouristDialog.getContentPane().setLayout(addTouristDialogLayout);
        addTouristDialogLayout.setHorizontalGroup(
            addTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTouristDialogLayout.createSequentialGroup()
                .addGroup(addTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTouristDialogLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(addTouristTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addTouristDialogLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(addTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(touristNameTextField)
                            .addGroup(addTouristDialogLayout.createSequentialGroup()
                                .addGroup(addTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(drivingLicenseCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(touristNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(destinationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thasosRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(samothrakiRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lemnosRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lesbosRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 73, Short.MAX_VALUE))
                            .addGroup(addTouristDialogLayout.createSequentialGroup()
                                .addComponent(saveAddingTouristDialog)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelAddingTouristDialog)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        addTouristDialogLayout.setVerticalGroup(
            addTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTouristDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTouristTitle)
                .addGap(18, 18, 18)
                .addComponent(touristNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(touristNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(destinationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thasosRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(samothrakiRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lemnosRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lesbosRadioButton)
                .addGap(18, 18, 18)
                .addComponent(drivingLicenseCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(addTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAddingTouristDialog)
                    .addComponent(cancelAddingTouristDialog))
                .addGap(33, 33, 33))
        );

        deleteTouristDialog.setTitle("Delete tourist");
        deleteTouristDialog.setLocation(new java.awt.Point(250, 200));
        deleteTouristDialog.setResizable(false);
        deleteTouristDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                deleteTouristDialogComponentHidden(evt);
            }
        });
        deleteTouristDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                deleteTouristDialogWindowClosing(evt);
            }
        });

        deleteTouristTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteTouristTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteTouristTitle.setText("Delete Tourist");

        touristIDDeleteLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        touristIDDeleteLabel.setText("Enter the id of the tourist:");

        deleteTouristDeleteDialog.setText("Delete");
        deleteTouristDeleteDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTouristDeleteDialogActionPerformed(evt);
            }
        });

        cancelTouristDeleteDialog.setText("Cancel");
        cancelTouristDeleteDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTouristDeleteDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteTouristDialogLayout = new javax.swing.GroupLayout(deleteTouristDialog.getContentPane());
        deleteTouristDialog.getContentPane().setLayout(deleteTouristDialogLayout);
        deleteTouristDialogLayout.setHorizontalGroup(
            deleteTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteTouristDialogLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(deleteTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(touristIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteTouristTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(deleteTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(deleteTouristDialogLayout.createSequentialGroup()
                            .addComponent(deleteTouristDeleteDialog)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelTouristDeleteDialog))
                        .addComponent(touristIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        deleteTouristDialogLayout.setVerticalGroup(
            deleteTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteTouristDialogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(deleteTouristTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(touristIDDeleteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(touristIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(deleteTouristDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteTouristDeleteDialog)
                    .addComponent(cancelTouristDeleteDialog))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        confirmTouristDeleteDialog.setTitle("Confirm tourist deletion");
        confirmTouristDeleteDialog.setLocation(new java.awt.Point(250, 200));
        confirmTouristDeleteDialog.setResizable(false);
        confirmTouristDeleteDialog.setSize(350,250);

        yesConfirmTouristDelete.setText("Yes");
        yesConfirmTouristDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesConfirmTouristDeleteActionPerformed(evt);
            }
        });

        noConfirmTouristDelete.setText("No");
        noConfirmTouristDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noConfirmTouristDeleteActionPerformed(evt);
            }
        });

        confirmMessageTourist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmMessageTourist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmMessageTourist.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout confirmTouristDeleteDialogLayout = new javax.swing.GroupLayout(confirmTouristDeleteDialog.getContentPane());
        confirmTouristDeleteDialog.getContentPane().setLayout(confirmTouristDeleteDialogLayout);
        confirmTouristDeleteDialogLayout.setHorizontalGroup(
            confirmTouristDeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmTouristDeleteDialogLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(confirmTouristDeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmMessageTourist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(confirmTouristDeleteDialogLayout.createSequentialGroup()
                        .addComponent(yesConfirmTouristDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                        .addComponent(noConfirmTouristDelete)))
                .addGap(23, 23, 23))
        );
        confirmTouristDeleteDialogLayout.setVerticalGroup(
            confirmTouristDeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmTouristDeleteDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(confirmMessageTourist, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(confirmTouristDeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesConfirmTouristDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noConfirmTouristDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        SettingMenu.setTitle("Settings");
        SettingMenu.setResizable(false);
        SettingMenu.setSize(new java.awt.Dimension(500, 350));

        SettingsTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SettingsTitle.setText("Settings");

        programName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programName.setText("Program name:");
        programName.setToolTipText("");

        programVersion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programVersion.setText("Program version:");

        programLicensee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programLicensee.setText("Program licensee:");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        versionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionTextFieldActionPerformed(evt);
            }
        });

        licenseeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenseeTextFieldActionPerformed(evt);
            }
        });

        settingsSave.setText("Save");
        settingsSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsSaveActionPerformed(evt);
            }
        });

        settingsCancel.setText("Cancel");
        settingsCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SettingMenuLayout = new javax.swing.GroupLayout(SettingMenu.getContentPane());
        SettingMenu.getContentPane().setLayout(SettingMenuLayout);
        SettingMenuLayout.setHorizontalGroup(
            SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingMenuLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(SettingsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(SettingMenuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingMenuLayout.createSequentialGroup()
                        .addGroup(SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(programName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(programVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programLicensee, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(versionTextField)
                            .addComponent(licenseeTextField))
                        .addGap(64, 64, 64))
                    .addGroup(SettingMenuLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(settingsSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(settingsCancel)
                        .addGap(114, 114, 114))))
        );
        SettingMenuLayout.setVerticalGroup(
            SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(SettingsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programName)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programVersion)
                    .addComponent(versionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programLicensee)
                    .addComponent(licenseeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(SettingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(settingsSave)
                    .addComponent(settingsCancel))
                .addGap(32, 32, 32))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(titleName);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        boatList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Capacity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        boatList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                boatListPropertyChange(evt);
            }
        });
        boatTable.setViewportView(boatList);
        if (boatList.getColumnModel().getColumnCount() > 0) {
            boatList.getColumnModel().getColumn(0).setResizable(false);
            boatList.getColumnModel().getColumn(1).setResizable(false);
            boatList.getColumnModel().getColumn(2).setResizable(false);
            boatList.getColumnModel().getColumn(3).setResizable(false);
        }

        addBoatButton.setText("New");
        addBoatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBoatButtonActionPerformed(evt);
            }
        });

        cancelBoatButton.setText("Cancel");
        cancelBoatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBoatButtonActionPerformed(evt);
            }
        });

        deleteBoatButton.setText("Delete");
        deleteBoatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBoatButtonActionPerformed(evt);
            }
        });

        titleBoatLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        titleBoatLabel.setText("List of boats:");

        javax.swing.GroupLayout boatPanelLayout = new javax.swing.GroupLayout(boatPanel);
        boatPanel.setLayout(boatPanelLayout);
        boatPanelLayout.setHorizontalGroup(
            boatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boatPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(boatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boatPanelLayout.createSequentialGroup()
                        .addComponent(titleBoatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(527, 527, 527))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boatPanelLayout.createSequentialGroup()
                        .addGroup(boatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(boatPanelLayout.createSequentialGroup()
                                .addComponent(addBoatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(deleteBoatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(346, 346, 346)
                                .addComponent(cancelBoatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boatTable, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(278, 278, 278))))
        );
        boatPanelLayout.setVerticalGroup(
            boatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boatPanelLayout.createSequentialGroup()
                .addComponent(titleBoatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boatTable, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(boatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBoatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBoatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBoatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        touristList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Driving License", "Destination"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        touristList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                touristListPropertyChange(evt);
            }
        });
        touristTable.setViewportView(touristList);
        if (touristList.getColumnModel().getColumnCount() > 0) {
            touristList.getColumnModel().getColumn(0).setResizable(false);
            touristList.getColumnModel().getColumn(1).setResizable(false);
            touristList.getColumnModel().getColumn(2).setResizable(false);
            touristList.getColumnModel().getColumn(3).setResizable(false);
        }

        addTouristButton.setText("New");
        addTouristButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTouristButtonButtonActionPerformed(evt);
            }
        });

        cancelTouristButton.setText("Cancel");
        cancelTouristButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTouristButtonActionPerformed(evt);
            }
        });

        deleteTouristButton.setText("Delete");
        deleteTouristButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTouristButtonActionPerformed(evt);
            }
        });

        titleTouristLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        titleTouristLabel.setText("List of tourists:");

        javax.swing.GroupLayout touristPanelLayout = new javax.swing.GroupLayout(touristPanel);
        touristPanel.setLayout(touristPanelLayout);
        touristPanelLayout.setHorizontalGroup(
            touristPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(touristPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(touristPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(touristPanelLayout.createSequentialGroup()
                        .addComponent(addTouristButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(deleteTouristButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(346, 346, 346)
                        .addComponent(cancelTouristButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titleTouristLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(touristTable))
                .addContainerGap(467, Short.MAX_VALUE))
        );
        touristPanelLayout.setVerticalGroup(
            touristPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(touristPanelLayout.createSequentialGroup()
                .addComponent(titleTouristLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(touristTable, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(touristPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTouristButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteTouristButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelTouristButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(706, 706, 706))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exitProgramMenuItem.setMnemonic('x');
        exitProgramMenuItem.setText("Exit");
        exitProgramMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgramMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitProgramMenuItem);

        Settings.setText("Settings");
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });
        fileMenu.add(Settings);

        menuBar.add(fileMenu);

        basicDataMenu.setText("Basic Data");

        boatMenuItem.setText("Boat");
        boatMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boatMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(boatMenuItem);

        touristMenuItem.setText("Tourist");
        touristMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                touristMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(touristMenuItem);

        bookingMenuItem.setText("Booking");
        bookingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(bookingMenuItem);

        employeeMenuItem.setText("Employee");
        employeeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(employeeMenuItem);

        extraMenuItem.setText("Extra");
        extraMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(extraMenuItem);

        voucherMenuItem.setText("Voucher");
        voucherMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voucherMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(voucherMenuItem);

        maintenanceMenuItem.setText("Maintenance");
        maintenanceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintenanceMenuItemActionPerformed(evt);
            }
        });
        basicDataMenu.add(maintenanceMenuItem);

        menuBar.add(basicDataMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        helpMenuItem.setMnemonic('c');
        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2291, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(579, 579, 579)
                    .addComponent(boatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(770, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(touristPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1160, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(240, 240, 240)
                    .addComponent(boatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(860, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(touristPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("mainFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * The size of the dialog window is set and it is shown to confirm exiting
     * the program.
     *
     * @param evt
     */
    private void exitProgramMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramMenuItemActionPerformed
        exitIfConfirmed();
    }//GEN-LAST:event_exitProgramMenuItemActionPerformed

    private void boatTypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boatTypeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boatTypeTextFieldActionPerformed
    /**
     * The input of the user is checked whether it is correct and if it ok, the
     * new object is added in the table as well as the ArrayList-
     *
     * @param evt
     */
    //Лодката която е добавена в листа се добавя в листа с лодки на BoatManager и този лист се записва във файла с лодките
    private void saveAddingBoatDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAddingBoatDialogActionPerformed

        if (boatTypeTextField.getText().isEmpty() || boatTypeTextField.getText().trim().isBlank()) {
            JOptionPane.showMessageDialog(errorWindow, "You should write boat type!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; // if the type field is empty an error dialog is shown
        }
        String boatType = boatTypeTextField.getText();
        if (!isInteger(boatCapacityTextField.getText()) || boatCapacityTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(errorWindow, "Invalid capacity!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; // if the capacity field is empty or there is invalid inpzt an error dialog is shown
        }
        Integer capacity = Integer.parseInt(boatCapacityTextField.getText());
        if (capacity <= 0) {
            JOptionPane.showMessageDialog(errorWindow, "Capacity should be positive number!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; //if the user enters negative number an error dialog is shown
        }
        if (!isDouble(boatPriceTextField.getText()) || boatPriceTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(errorWindow, "Invalid price!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; // if the price field is empty or there is invalid inpzt an error dialog is shown
        }
        Double price = Double.parseDouble(boatPriceTextField.getText());
        if (price <= 0) {
            JOptionPane.showMessageDialog(errorWindow, "Price should be positive number!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; //if the user enters negative number an error dialog is shown
        }
        BoatManager.addBoat(boatType, capacity, price); //the newly created boat is added to the ArrayList of the BoatManager
        writingBoats(BoatManager.getBoats());
        DefaultTableModel model = (DefaultTableModel) boatList.getModel();
        Object[] rowData = new Object[4]; //the characteristics of a boat are saved in an array of type object
        rowData[0] = BoatManager.getBoats().get(BoatManager.getBoats().size() - 1).getBoatID(); //column 1 is the boat id
        rowData[1] = boatType; //column 2 is the type
        rowData[2] = capacity; //column 3 is the capaciyt
        rowData[3] = price;  //column 4 is the price
        model.addRow(rowData); //a row is added in the table that contains the newly created boat
        addBoatDialog.setVisible(false);
        boatTypeTextField.setText(""); //the type, capacity and price fields are set to be empty again after the inserting of a boat
        boatCapacityTextField.setText("");
        boatPriceTextField.setText("");
    }//GEN-LAST:event_saveAddingBoatDialogActionPerformed
    /**
     * The error window is set invisible.
     *
     * @param evt
     */
    private void okErrorWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okErrorWindowActionPerformed
        errorWindow.setVisible(false);
    }//GEN-LAST:event_okErrorWindowActionPerformed
    /**
     * The window for adding a boat is set invisible.
     *
     * @param evt
     */
    private void cancelAddingBoatDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddingBoatDialogActionPerformed
        addBoatDialog.setVisible(false);
        boatTypeTextField.setText("");
        boatPriceTextField.setText("");
        boatCapacityTextField.setText("");
    }//GEN-LAST:event_cancelAddingBoatDialogActionPerformed
    /**
     * The window for deleting a boat is set invisible.
     *
     * @param evt
     */
    private void cancelBoatDeleteDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBoatDeleteDialogActionPerformed
        deleteBoatDialog.setVisible(false);
        boatIDDeleteTextField.setText("");
    }//GEN-LAST:event_cancelBoatDeleteDialogActionPerformed
    /**
     * The entered ID is checked whether it is correct and if it is, a dialog
     * window for confirmation of the deletion is shown.
     *
     * @param evt
     */
    private void deleteBoatDeleteDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBoatDeleteDialogActionPerformed
        if (boatIDDeleteTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(errorWindow, "You should write id!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; //if the user does not enter anything an error dialog is shown
        } //if the user enters empty input an error dialog is shown
        if (!isInteger(boatIDDeleteTextField.getText())) {
            JOptionPane.showMessageDialog(errorWindow, "Id should be a number!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; //if the user enters string input an error dialog is shown
        }
        int id = Integer.parseInt(boatIDDeleteTextField.getText());
        if (!BoatManager.existingID(id)) {
            JOptionPane.showMessageDialog(errorWindow, "There is no boat with this id!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; //if the user enters an id that does not exist in the list a message is shown
        }
        DefaultTableModel model = (DefaultTableModel) boatList.getModel();
        String type = BoatManager.findBoat(id).getBoatType(); //from the ArrayList in the BoatManager class we get the type of the boat with the corresponding id 
        confirmMessageBoat.setText("Really delete boat ID=" + id + " '" + type + "'?");
        confirmBoatDeleteDialog.setVisible(true);
        confirmBoatDeleteDialog.setLocationRelativeTo(null); //the dialog is centered on the screen
    }//GEN-LAST:event_deleteBoatDeleteDialogActionPerformed
    /**
     * The size of the window with boats is set.
     *
     * @param evt
     */
    private void boatMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boatMenuItemActionPerformed
        boatPanel.setLocation(0, 0);
        boatPanel.setSize(700, 600);
        boatPanel.setVisible(true);
        boatPanel.setLayout(new BorderLayout());
        touristPanel.setVisible(false);
    }//GEN-LAST:event_boatMenuItemActionPerformed
    /**
     * The window for adding new boats is shown, set visible.
     *
     * @param evt
     */
    private void addBoatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBoatButtonActionPerformed
        addBoatDialog.setVisible(true);
        addBoatDialog.setSize(450, 350);
        addBoatDialog.setLocationRelativeTo(null); //the dialog is centered on the screen
    }//GEN-LAST:event_addBoatButtonActionPerformed
    /**
     * The panel with the table is set invisible, not shown anymore.
     *
     * @param evt
     */
    private void cancelBoatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBoatButtonActionPerformed
        boatPanel.setVisible(false);
        boatIDDeleteTextField.setText(""); //the textFiled is set empty again
    }//GEN-LAST:event_cancelBoatButtonActionPerformed
    /**
     * The number of boats in the table is checked - if it is 0, an error dialog
     * is shown, if it is more than 0 the window for deleting a boat is shown,
     *
     * @param evt
     */
    private void deleteBoatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBoatButtonActionPerformed
        if (boatList.getRowCount() == 0) { //chekcs if the number of rows in the table is 0
            JOptionPane.showMessageDialog(errorWindow, "You should add boats before deleting!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; // if the number of rows in the table is 0, then there is no element in the table and nothing will be there to be dleted
        }
        deleteBoatDialog.setVisible(true);
        deleteBoatDialog.setSize(400, 250);
        deleteBoatDialog.setLocationRelativeTo(null); //the dialog window is centered on the screen
    }//GEN-LAST:event_deleteBoatButtonActionPerformed
    /**
     * The changes made by the user are checked for correctness, if they are ok
     * the changes are saved, if they are incorrect an error message is shown
     * and the previous data is kept unchanged.
     *
     * @param evt
     */
    //Промените се запазват в листа с лодки на BoatManager и след това този лист се записва в файла с лодките
    private void boatListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_boatListPropertyChange
        if (evt.getPropertyName().equals("tableCellEditor")) { //  A cell has started/stopped editing
            if (!boatList.isEditing()) {
                DefaultTableModel model = (DefaultTableModel) boatList.getModel();
                int row = boatList.getSelectedRow();
                int id = Integer.parseInt(String.valueOf(model.getValueAt(row, 0)));
                String type = (String) String.valueOf(model.getValueAt(row, 1));
                if (type.isEmpty() || type.trim().isBlank()) { //if when the user edits a field and leaves the field blank then the field is set to its previous value
                    //also an error message is hsown to inform the user
                    JOptionPane.showMessageDialog(errorWindow, "You should write boat type!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldType, row, 1);
                    return;
                }
                if (!isInteger(String.valueOf(model.getValueAt(row, 2))) || String.valueOf(model.getValueAt(row, 2)).isEmpty()) {
                    JOptionPane.showMessageDialog(errorWindow, "Invalid capacity!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    //also an error message is hsown to inform the user
                    boatList.setValueAt(oldCapacity, row, 2);  //the field is set to its previous value
                    return;
                }
                int capacity = Integer.parseInt(String.valueOf(model.getValueAt(row, 2)));
                if (capacity <= 0) {
                    JOptionPane.showMessageDialog(errorWindow, "Capacity should be positive number!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldCapacity, row, 2); //the field is set to its previous value
                    return;
                }
                if (!isDouble(String.valueOf(model.getValueAt(row, 3))) || String.valueOf(model.getValueAt(row, 3)).isEmpty()) {
                    JOptionPane.showMessageDialog(errorWindow, "Invalid price", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldPrice, row, 3); //the field is set to its previous value
                    return;
                }
                double price = Double.parseDouble(String.valueOf(model.getValueAt(row, 3)));
                if (price <= 0) {
                    JOptionPane.showMessageDialog(errorWindow, "Price should be positive number!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldPrice, row, 3); //the field is set to its previous value
                    return;
                }
                BoatManager.updateBoat(row, type, capacity, price);
                writingBoats(BoatManager.getBoats());
            } else {
                DefaultTableModel model = (DefaultTableModel) boatList.getModel();
                int row = boatList.getSelectedRow();
                int id = Integer.parseInt(String.valueOf(model.getValueAt(row, 0)));
                String type = (String) String.valueOf(model.getValueAt(row, 1));
                if (type.isEmpty() || type.trim().isBlank()) { //if when the user edits a field and leaves the field blank then the field is set to its previous value
                    JOptionPane.showMessageDialog(errorWindow, "You should write boat type!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldType, row, 1); //the field is set to its previous value
                    return;
                }
                if (!isInteger(String.valueOf(model.getValueAt(row, 2))) || String.valueOf(model.getValueAt(row, 2)).isEmpty()) {
                    JOptionPane.showMessageDialog(errorWindow, "Invalid capacity!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldCapacity, row, 2); //the field is set to its previous value
                    return;
                }
                int capacity = Integer.parseInt(String.valueOf(model.getValueAt(row, 2)));
                if (capacity <= 0) {
                    JOptionPane.showMessageDialog(errorWindow, "Capacity should be positive number!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldCapacity, row, 2); // the field is set to its previous value
                    return;
                }
                if (!isDouble(String.valueOf(model.getValueAt(row, 3))) || String.valueOf(model.getValueAt(row, 3)).isEmpty()) {
                    JOptionPane.showMessageDialog(errorWindow, "Invalid price!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldPrice, row, 3); //the field is set to its previous value
                    return;
                }
                double price = Double.parseDouble(String.valueOf(model.getValueAt(row, 3)));
                if (price <= 0) {
                    JOptionPane.showMessageDialog(errorWindow, "Price should be positive number!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    boatList.setValueAt(oldPrice, row, 3);  //the field is set to its previous value
                    return;
                }
                oldType = type;
                oldPrice = price;
                oldCapacity = capacity;
            }
        }
    }//GEN-LAST:event_boatListPropertyChange
    /**
     * The boat with the corresponding ID that the user enters is deleted from
     * the tables as well as the ArrayList.
     *
     * @param evt
     */
    //Елемента се изтрива от листа с лодки на BoatManager и след това този лист се записва във файла с лодките
    private void yesConfirmBoatDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesConfirmBoatDeleteActionPerformed
        int id = Integer.parseInt(boatIDDeleteTextField.getText()); //here we parse the input id that the user enters for the boat that should be deleted
        BoatManager.deleteBoat(id); // if this id exist i  the ArrayList it will be removed
        DefaultTableModel model = (DefaultTableModel) boatList.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) { //makes as many iterations as the number of rows in the table
            if (Integer.parseInt(String.valueOf(model.getValueAt(i, 0))) == id) {
                model.removeRow(i); //if the input of the user equals the id of the corresponding row that row will be delted from the table
            }
        }
        writingBoats(BoatManager.getBoats());
        deleteBoatDialog.setVisible(false);
        boatIDDeleteTextField.setText(""); //the textfield is set to be empty again 
        confirmBoatDeleteDialog.setVisible(false); //the dialog  is set invisible
    }//GEN-LAST:event_yesConfirmBoatDeleteActionPerformed
    /**
     * The confirmation dialog for deleting is set invisible.
     *
     * @param evt
     */
    private void noConfirmBoatDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noConfirmBoatDeleteActionPerformed
        confirmBoatDeleteDialog.setVisible(false);
        boatIDDeleteTextField.setText(""); //the textField where the user writes the boat id s set empty
    }//GEN-LAST:event_noConfirmBoatDeleteActionPerformed

    private void deleteBoatDialogComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_deleteBoatDialogComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBoatDialogComponentHidden
    /**
     * A dialog is shown saying that this menu is not yet implemented.
     *
     * @param evt
     */
    private void bookingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingMenuItemActionPerformed
        JOptionPane.showMessageDialog(errorWindow, "not yet implemented!", "Please note", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bookingMenuItemActionPerformed
    /**
     * A dialog is shown saying that this menu is not yet implemented.
     *
     * @param evt
     */
    private void employeeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeMenuItemActionPerformed
        JOptionPane.showMessageDialog(errorWindow, "not yet implemented!", "Please note", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_employeeMenuItemActionPerformed
    /**
     * A dialog is shown saying that this menu is not yet implemented.
     *
     * @param evt
     */
    private void extraMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraMenuItemActionPerformed
        JOptionPane.showMessageDialog(errorWindow, "not yet implemented!", "Please note", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_extraMenuItemActionPerformed
    /**
     * A dialog is shown saying that this menu is not yet implemented.
     *
     * @param evt
     */
    private void voucherMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voucherMenuItemActionPerformed
        JOptionPane.showMessageDialog(errorWindow, "not yet implemented!", "Please note", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_voucherMenuItemActionPerformed
    /**
     * A dialog is shown saying that this menu is not yet implemented.
     *
     * @param evt
     */
    private void maintenanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintenanceMenuItemActionPerformed
        JOptionPane.showMessageDialog(errorWindow, "not yet implemented!", "Please note", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_maintenanceMenuItemActionPerformed
    /**
     * The changes made in the table are checked for correctness, if it is ok,
     * the changes are saved, if it is not correct an error dialog is shown and
     * the previous changes are kept.
     *
     * @param evt
     */
    //Промените се записват в листа с туристи TouristManager след което листът се записва във файла с туристите
    private void touristListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_touristListPropertyChange
        if (evt.getPropertyName().equals("tableCellEditor")) {  //  A cell has started/stopped editing
            if (!touristList.isEditing()) {
                DefaultTableModel model = (DefaultTableModel) touristList.getModel();
                int row = touristList.getSelectedRow();
                int id = Integer.parseInt(String.valueOf(model.getValueAt(row, 0)));
                String name = (String) String.valueOf(model.getValueAt(row, 1));
                if (name.isEmpty() || name.trim().isBlank()) {
                    JOptionPane.showMessageDialog(errorWindow, "You should write tourist name!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    touristList.setValueAt(oldName, row, 1);
                    return; //if when the user edits a field and leaves the field blank then the field is set to its previous value
                }
                boolean drivingLicense = (Boolean) model.getValueAt(row, 2);
                String destination = String.valueOf(model.getValueAt(row, 3));
                if (!destination.equals("Thasos") && !destination.equals("Samothraki") && !destination.equals("Lemnos") && !destination.equals("Lesbos")) {
                    JOptionPane.showMessageDialog(errorWindow, "Invalid destination!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    touristList.setValueAt(oldDestination, row, 3);
                    return; //if the user edits and types something other than the prechosen destinations the value of the cell is set back to its previous 
                }
                TouristManager.updateTourist(row, name, drivingLicense, destination);
                writingTourists(TouristManager.getTourists());
            } else {
                DefaultTableModel model = (DefaultTableModel) touristList.getModel();
                if (touristList.getSelectedRow() != -1) {
                    int row = touristList.getSelectedRow();
                    int id = Integer.parseInt(String.valueOf(model.getValueAt(row, 0)));
                    String name = (String) String.valueOf(model.getValueAt(row, 1));
                    if (name.isEmpty() || name.trim().isBlank()) { //if the user does not write anything in the name field then the previous value is kept and en error window is shown
                        JOptionPane.showMessageDialog(errorWindow, "You should write tourist name!", "Inane error", JOptionPane.ERROR_MESSAGE);
                        touristList.setValueAt(oldName, row, 1);
                        return;
                    }
                    boolean drivingLicense = (Boolean) model.getValueAt(row, 2);
                    String destination = String.valueOf(model.getValueAt(row, 3));
                    if (!destination.equals("Thasos") && !destination.equals("Samothraki") && !destination.equals("Lemnos") && !destination.equals("Lesbos")) {
                        JOptionPane.showMessageDialog(errorWindow, "Invalid destinaation", "Inane error", JOptionPane.ERROR_MESSAGE);
                        touristList.setValueAt(oldDestination, row, 3); //if the user does not choose a destinanntion from the predetermined then the previous value is kept and en error window is shown
                        return;
                    }
                    oldName = name;
                    oldDrivingLicense = drivingLicense;
                    oldDestination = destination;
                }
            }
        }
    }//GEN-LAST:event_touristListPropertyChange
    /**
     * A dialog for adding a tourist is shown.
     *
     * @param evt
     */
    private void addTouristButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTouristButtonButtonActionPerformed
        addTouristDialog.setVisible(true);
        addTouristDialog.setSize(500, 400);
        addTouristDialog.setLocationRelativeTo(null); //the dialof window is centered on the screen
    }//GEN-LAST:event_addTouristButtonButtonActionPerformed
    /**
     * The panel with the tourist table is hidden, set invisible.
     *
     * @param evt
     */
    private void cancelTouristButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTouristButtonActionPerformed
        touristPanel.setVisible(false);
    }//GEN-LAST:event_cancelTouristButtonActionPerformed
    /**
     * The number of tourists is checked, if it is 0 - an error message is
     * shown, if it is more than 0 a window for deleting tourist is shown.
     *
     * @param evt
     */
    private void deleteTouristButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTouristButtonActionPerformed
        if (touristList.getRowCount() == 0) { //chekcs if the number of rows in the table is 0
            JOptionPane.showMessageDialog(errorWindow, "You should add tourist before deleting!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        deleteTouristDialog.setSize(400, 250);
        deleteTouristDialog.setVisible(true);
        deleteTouristDialog.setLocationRelativeTo(null); //the dialof window is centered on the screen
    }//GEN-LAST:event_deleteTouristButtonActionPerformed
    /**
     * The panel with the tourist table is shown and its size is determined.
     *
     * @param evt
     */
    private void touristMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_touristMenuItemActionPerformed
        touristPanel.setLocation(0, 0);
        touristPanel.setSize(700, 600);
        touristPanel.setVisible(true);
        touristPanel.setLayout(new BorderLayout());
        boatPanel.setVisible(false);
    }//GEN-LAST:event_touristMenuItemActionPerformed
    /**
     * The window dor adding tourists is set invisible.
     *
     * @param evt
     */
    private void cancelAddingTouristDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddingTouristDialogActionPerformed
        addTouristDialog.setVisible(false);
        touristNameTextField.setText(""); //when the user presses cancel button the boxes and radio buttons pressed by him will be set empty again
        drivingLicenseCheckBox.setSelected(false);
        destinationsButtonGroup.clearSelection();
    }//GEN-LAST:event_cancelAddingTouristDialogActionPerformed
    /**
     * The input entered by the user is checked for correctness and if it is ok
     * a new tourist is added to the table and in the Array List of the Tourist
     * Manager.
     *
     * @param evt
     */
    //Туристът се добавя към листа с туристи на TouristManager и след това този лист се записва във файла с туристите
    private void saveAddingTouristDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAddingTouristDialogActionPerformed
        String name = touristNameTextField.getText(); //gets the name of the tourist from the text field
        if (name.isBlank()) { //checks if the user does not write anything in the text field
            JOptionPane.showMessageDialog(errorWindow, "You should write tourist name!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean drivingLicense = drivingLicenseCheckBox.isSelected(); //if the user checks the driving license box, the variable is true
        if (!thasosRadioButton.isSelected() && !samothrakiRadioButton.isSelected() && !lemnosRadioButton.isSelected() && !lesbosRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(errorWindow, "You should select destination!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return; //checks if neither of the destinations is selected
        }
        String destination = "";
        if (thasosRadioButton.isSelected()) { //if the button is selected then this is the destination of the tourist
            destination = "Thasos";
        } else if (samothrakiRadioButton.isSelected()) {
            destination = "Samothraki";
        } else if (lemnosRadioButton.isSelected()) {
            destination = "Lemnos";
        } else if (lesbosRadioButton.isSelected()) {
            destination = "Lesbos";
        }
        TouristManager.addTourist(name, drivingLicense, destination); //the newly created tourist is added to the array List in the TouristManager class
        writingTourists(TouristManager.getTourists());
        DefaultTableModel model = (DefaultTableModel) touristList.getModel();
        Object[] rowData = new Object[4]; //an array of type object which includes the characteristics of the tourist
        rowData[0] = TouristManager.getTourists().get(TouristManager.getTourists().size() - 1).getTouristID(); //first column is the tourist id
        rowData[1] = name; //second column is the tourist name
        rowData[2] = drivingLicense; //third column is the possession driving license
        rowData[3] = destination; //forth column is the destination of the tourist
        model.addRow(rowData);  //the row is added to the tourist table
        addTouristDialog.setVisible(false);
        touristNameTextField.setText("");
        destinationsButtonGroup.clearSelection();
        drivingLicenseCheckBox.setSelected(false);
    }//GEN-LAST:event_saveAddingTouristDialogActionPerformed
    /**
     * The ID is checked whether it is correct and if it is not ok an error
     * dialog is shown, if it is correct a window for confirmation is shown.
     *
     * @param evt
     */
    private void deleteTouristDeleteDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTouristDeleteDialogActionPerformed
        if (touristIDDeleteTextField.getText().isBlank()) { //checks whether the user wrote in the text firld an id
            JOptionPane.showMessageDialog(errorWindow, "You should write id!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isInteger(touristIDDeleteTextField.getText())) { //checks whether the input is not integer type
            JOptionPane.showMessageDialog(errorWindow, "Id should be a number!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id = Integer.parseInt(touristIDDeleteTextField.getText()); //the input is parsed to integer type and saved as an id
        if (!TouristManager.existingID(id)) { //checks whether the entered id is not in the array list
            JOptionPane.showMessageDialog(errorWindow, "There is no tourist with this id!", "Inane error", JOptionPane.ERROR_MESSAGE);
            return;
        } //at this point the user has written an id that exist in the arrayList
        DefaultTableModel model = (DefaultTableModel) touristList.getModel();
        String name = TouristManager.findTourist(id).getTouristName();
        confirmMessageTourist.setText("Really delete boat ID=" + id + " '" + name + "'?"); //a confirmation dialog is shown asking the user if he is sure to delete the tourist
        confirmTouristDeleteDialog.setVisible(true);
        confirmTouristDeleteDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_deleteTouristDeleteDialogActionPerformed
    /**
     * The dialog for deletion is set invisible.
     *
     * @param evt
     */
    private void cancelTouristDeleteDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTouristDeleteDialogActionPerformed
        deleteTouristDialog.setVisible(false);
        touristIDDeleteTextField.setText(""); //when the user presses cancel button the boxes will be set empty again
    }//GEN-LAST:event_cancelTouristDeleteDialogActionPerformed

    private void deleteTouristDialogComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_deleteTouristDialogComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteTouristDialogComponentHidden
    /**
     * The tourist with the corresponding ID is removed from the table as well
     * as the ArrayList of the touristManager.
     *
     * @param evt
     */
    //Туристът се премахва от листа с туристи на TouristManager и след това този лист се записва във файла с туристи
    private void yesConfirmTouristDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesConfirmTouristDeleteActionPerformed
        int id = Integer.parseInt(touristIDDeleteTextField.getText()); //if the user has pressed the yes button then the tourist is deleted from the table and the arrayList
        TouristManager.deleteTourist(id);
        DefaultTableModel model = (DefaultTableModel) touristList.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) { //makes as many iterations as the number of rows in the table
            if (Integer.parseInt(String.valueOf(model.getValueAt(i, 0))) == id) { //chekcs for every iteration if the value of the first column is equal to the input of the user
                model.removeRow(i); //if there is an id equal to the input the row will be removed from the table
            }
        }
        writingTourists(TouristManager.getTourists());
        List<Tourist> list = readingTourists();
        System.out.println(list.size());
        list.forEach(e->System.out.println(e));
        deleteTouristDialog.setVisible(false);
        touristIDDeleteTextField.setText(""); //the text field for id is set empty
        confirmTouristDeleteDialog.setVisible(false);
    }//GEN-LAST:event_yesConfirmTouristDeleteActionPerformed
    /**
     * The confirmation window for deleting a tourist is set invisible.
     *
     * @param evt
     */
    private void noConfirmTouristDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noConfirmTouristDeleteActionPerformed
        confirmTouristDeleteDialog.setVisible(false);
        touristIDDeleteTextField.setText(""); //the text field for id is set empty
    }//GEN-LAST:event_noConfirmTouristDeleteActionPerformed

   /**
     * A dialog message is shown saying that this menu is not yet implemented.
     *
     * @param evt
     */
    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        JOptionPane.showMessageDialog(errorWindow, "You can not be assisted with further help for now!", "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpMenuItemActionPerformed
    /**
     * A window is shown showing information about the application.
     *
     * @param evt
     */
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(errorWindow, informationEdit(), "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void boatIDDeleteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boatIDDeleteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boatIDDeleteTextFieldActionPerformed

    private void lemnosRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lemnosRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lemnosRadioButtonActionPerformed

    private void touristNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_touristNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_touristNameTextFieldActionPerformed

    //затваря се прозореца за изтриване на турист
    private void deleteTouristDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_deleteTouristDialogWindowClosing
        //when the user presses the red x, to close the window, the text field for tourist id will be set empty
        touristIDDeleteTextField.setText("");
    }//GEN-LAST:event_deleteTouristDialogWindowClosing

    //затваря се прозореца за добавяне на турист
    private void addTouristDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_addTouristDialogWindowClosing
        //when the user presses the red x, to close the window all the text field and radio buttons will be set empty again
        touristNameTextField.setText("");
        destinationsButtonGroup.clearSelection();
        drivingLicenseCheckBox.setSelected(false);
    }//GEN-LAST:event_addTouristDialogWindowClosing

    //затваря се прозореца за добавяне на лодка
    private void addBoatDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_addBoatDialogWindowClosing
        boatTypeTextField.setText(""); //the type, capacity and price fields are set to be empty again after the user presses the closing button
        boatCapacityTextField.setText("");
        boatPriceTextField.setText("");
    }//GEN-LAST:event_addBoatDialogWindowClosing

    //затваря се прозореца за изтриване на лодка
    private void deleteBoatDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_deleteBoatDialogWindowClosing
        //when the user presses the red x, to close the window, the text field for boat id will be set empty
        boatIDDeleteTextField.setText("");
    }//GEN-LAST:event_deleteBoatDialogWindowClosing

    //показва се прозореца за настройките
    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        SettingMenu.setVisible(true);
        nameTextField.setText(settingFields[0]);
        versionTextField.setText(settingFields[1]);
        licenseeTextField.setText(settingFields[2]);
        SettingMenu.setLocationRelativeTo(null);
    }//GEN-LAST:event_SettingsActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void licenseeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenseeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_licenseeTextFieldActionPerformed

    private void versionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_versionTextFieldActionPerformed
//затваря се прозореца за настройките
    private void settingsCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsCancelActionPerformed
        SettingMenu.setVisible(false);
    }//GEN-LAST:event_settingsCancelActionPerformed

    //Проверява дали едно от трите полета е празно. Ако е празно извежда предупреждение.
    //След като всичко е наред се взима информацията от полетата и се записва във файла с настройките
    //Записва се и брояч за това колко промени в настройките са направени
    private void settingsSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsSaveActionPerformed
        if (nameTextField.getText().isEmpty() || nameTextField.getText().trim().isBlank()) {
                    JOptionPane.showMessageDialog(errorWindow, "Your program should have name!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    nameTextField.setText(settingFields[0]);
                    return; //if when the user edits a field and leaves the field blank then the field is set to its previous value
                }
        if (versionTextField.getText().isEmpty() || versionTextField.getText().trim().isBlank()) {
                    JOptionPane.showMessageDialog(errorWindow, "Your program should have version!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    versionTextField.setText(settingFields[1]);
                    return; //if when the user edits a field and leaves the field blank then the field is set to its previous value
                }
        if (licenseeTextField.getText().isEmpty() || licenseeTextField.getText().trim().isBlank()) {
                    JOptionPane.showMessageDialog(errorWindow, "Your program should have licensee!", "Inane error", JOptionPane.ERROR_MESSAGE);
                    licenseeTextField.setText(settingFields[2]);
                    return; //if when the user edits a field and leaves the field blank then the field is set to its previous value
                }
        infoEditCount++;
            try {
            //Specify the file name and path here
            File file = new File("Settings.txt");
            FileWriter fw = new FileWriter(file,true);
            //Write the text to the file
            fw.write("After "+infoEditCount+" edit:");
            fw.write(System.lineSeparator());
            fw.write(nameTextField.getText());
            fw.write(System.lineSeparator());
            fw.write(versionTextField.getText());
            fw.write(System.lineSeparator());
            fw.write(licenseeTextField.getText());
            fw.write(System.lineSeparator());
            fw.write(System.lineSeparator());
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
         gettingLastSetting();
         this.titleName = settingFields[0]+ " " +settingFields[1];
        setTitle(titleName);
        SettingMenu.setVisible(false);
    }//GEN-LAST:event_settingsSaveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    exitIfConfirmed();
    }//GEN-LAST:event_formWindowClosing

    private void exitIfConfirmed() {
        // exit the app if user confirms this 
        int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the app?", "Please confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    /**
     * Checks whether an input can be converted to integer type, returns true if
     * it can be and false if it can not.
     *
     * @param s
     * @return
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    //Checks whether an input can be converted to double type, returns true if it can be and false if it can not.
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoatManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoatManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoatManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoatManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoatManagement(). setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog SettingMenu;
    private javax.swing.JMenuItem Settings;
    private javax.swing.JLabel SettingsTitle;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addBoatButton;
    private javax.swing.JDialog addBoatDialog;
    private javax.swing.JLabel addBoatTitle;
    private javax.swing.JButton addTouristButton;
    private javax.swing.JDialog addTouristDialog;
    private javax.swing.JLabel addTouristTitle;
    private javax.swing.JMenu basicDataMenu;
    private javax.swing.JLabel boatCapacityLabel;
    private javax.swing.JTextField boatCapacityTextField;
    private javax.swing.JLabel boatIDDeleteLabel;
    private javax.swing.JTextField boatIDDeleteTextField;
    private javax.swing.JTable boatList;
    private javax.swing.JMenuItem boatMenuItem;
    private javax.swing.JPanel boatPanel;
    private javax.swing.JLabel boatPriceLabel;
    private javax.swing.JTextField boatPriceTextField;
    private javax.swing.JScrollPane boatTable;
    private javax.swing.JLabel boatTypeLabel;
    private javax.swing.JTextField boatTypeTextField;
    private javax.swing.JMenuItem bookingMenuItem;
    private javax.swing.JButton cancelAddingBoatDialog;
    private javax.swing.JButton cancelAddingTouristDialog;
    private javax.swing.JButton cancelBoatButton;
    private javax.swing.JButton cancelBoatDeleteDialog;
    private javax.swing.JButton cancelTouristButton;
    private javax.swing.JButton cancelTouristDeleteDialog;
    private javax.swing.JDialog confirmBoatDeleteDialog;
    private javax.swing.JLabel confirmMessageBoat;
    private javax.swing.JLabel confirmMessageTourist;
    private javax.swing.JDialog confirmTouristDeleteDialog;
    private javax.swing.JButton deleteBoatButton;
    private javax.swing.JButton deleteBoatDeleteDialog;
    private javax.swing.JDialog deleteBoatDialog;
    private javax.swing.JLabel deleteBoatTitle;
    private javax.swing.JButton deleteTouristButton;
    private javax.swing.JButton deleteTouristDeleteDialog;
    private javax.swing.JDialog deleteTouristDialog;
    private javax.swing.JLabel deleteTouristTitle;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.ButtonGroup destinationsButtonGroup;
    private javax.swing.JCheckBox drivingLicenseCheckBox;
    private javax.swing.JMenuItem employeeMenuItem;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JDialog errorWindow;
    private javax.swing.JMenuItem exitProgramMenuItem;
    private javax.swing.JMenuItem extraMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JRadioButton lemnosRadioButton;
    private javax.swing.JRadioButton lesbosRadioButton;
    private javax.swing.JTextField licenseeTextField;
    private javax.swing.JMenuItem maintenanceMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton noConfirmBoatDelete;
    private javax.swing.JButton noConfirmTouristDelete;
    private javax.swing.JButton okErrorWindow;
    private javax.swing.JLabel programLicensee;
    private javax.swing.JLabel programName;
    private javax.swing.JLabel programVersion;
    private javax.swing.JRadioButton samothrakiRadioButton;
    private javax.swing.JButton saveAddingBoatDialog;
    private javax.swing.JButton saveAddingTouristDialog;
    private javax.swing.JButton settingsCancel;
    private javax.swing.JButton settingsSave;
    private javax.swing.JRadioButton thasosRadioButton;
    private javax.swing.JLabel titleBoatLabel;
    private javax.swing.JLabel titleTouristLabel;
    private javax.swing.JLabel touristIDDeleteLabel;
    private javax.swing.JTextField touristIDDeleteTextField;
    private javax.swing.JTable touristList;
    private javax.swing.JMenuItem touristMenuItem;
    private javax.swing.JLabel touristNameLabel;
    private javax.swing.JTextField touristNameTextField;
    private javax.swing.JPanel touristPanel;
    private javax.swing.JScrollPane touristTable;
    private javax.swing.JTextField versionTextField;
    private javax.swing.JMenuItem voucherMenuItem;
    private javax.swing.JButton yesConfirmBoatDelete;
    private javax.swing.JButton yesConfirmTouristDelete;
    // End of variables declaration//GEN-END:variables

}
