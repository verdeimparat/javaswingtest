import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

class AppLib extends JPanel {

    AppLib() {
        super();

        String[] afiseazaCarti  = {"Toate", "Istorie", "Beletristica"};
        String[] tipCarti       = {"Istorie", "Beletristica"};
        String[] motivSters     = {"Autor", "ISBN"};
        String[][] dataCarti    = {};
        String[] coloanaCarti   = {"TITLU", "AUTOR", "ISBN", "PRET", "TAG", "TYPE"};

        JPanel myPanel = new JPanel();
        //myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        DefaultTableModel listTableModel = new DefaultTableModel(dataCarti, coloanaCarti);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(listTableModel);
        JTable listTable = new JTable(listTableModel);
        listTable.setRowSorter(sorter);

        listTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //listTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        listTable.setFillsViewportHeight(true);
        listTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(listTable);
        scrollPane.setBounds(40, 50, 520, 200);

        //Add the scroll pane to this panel.
        add(scrollPane);

        // Buttons
        JButton btnAfiseaza = new JButton("Afiseaza");
        btnAfiseaza.setBounds(700, 50, 90, 30);

        JButton btnSterge = new JButton("Sterge");
        btnSterge.setBounds(700, 90, 90, 30);

        JButton btnAdauga = new JButton("Adauga");
        btnAdauga.setBounds(700, 10, 90, 30);

        // Combo Boxes
        JComboBox<String> cmbSters = new JComboBox<>(motivSters);
        cmbSters.setBounds(600, 90, 90, 30);

        JComboBox<String> cmbAfiseaza = new JComboBox<>(afiseazaCarti);
        cmbAfiseaza.setBounds(600, 50, 90, 30);

        JComboBox<String> cmbCarti = new JComboBox<>(tipCarti);
        cmbCarti.setBounds(600, 10, 90, 30);

        //Text Label
        ImageIcon image = new ImageIcon("D:\\Users\\t0236968\\Desktop\\Librarie\\index.png");

        JLabel lblTerminal = new JLabel();
        lblTerminal.setBounds(600, 160, 200, 30);
        lblTerminal.setText("Java done");

        JLabel lblICon = new JLabel();
        lblICon.setBounds(650, 170, 200, 100);
        lblICon.setIcon(null);

        //Text Field
        JTextField fldSterge = new JTextField();
        fldSterge.setBounds(600, 130, 190, 30);
        fldSterge.setText("<sterge>");
        JTextField fldAutor = new JTextField();
        fldAutor.setBounds(150, 10, 100, 30);
        fldAutor.setText("Autor");
        JTextField fldTitlu = new JTextField();
        fldTitlu.setBounds(50, 10, 100, 30);
        fldTitlu.setText("Titlu");
        JTextField fldISBN = new JTextField();
        fldISBN.setBounds(250, 10, 100, 30);
        fldISBN.setText("ISBN");
        JTextField fldPret = new JTextField();
        fldPret.setBounds(350, 10, 100, 30);
        fldPret.setText("Pret");
        JTextField fldTag = new JTextField();
        fldTag.setBounds(450, 10, 100, 30);
        fldTag.setText("Tag");

        btnAdauga.addActionListener(e -> {
            boolean flag = false;
            if (cmbCarti.getSelectedIndex() == 0) {
                for (int d = 0; d < listTable.getRowCount(); d++) {
                    if (listTable.getValueAt(d, 2).equals(fldISBN.getText())) {
                        lblTerminal.setText("Cartea exista deja in librarie!");
                        lblICon.setIcon(image);
                        flag = true;
                        break;
                    }
                }
                if (listTable.getRowCount() >= 100) {
                    lblTerminal.setText("Pragul maxim de o 100 de carti a fost atins!");
                    lblICon.setIcon(image);
                } else if (!flag) {
                    lblTerminal.setText("Am adaugat o carte de Istorie.");
                    listTableModel.addRow(new Object[]{fldTitlu.getText(), fldAutor.getText(), fldISBN.getText(), fldPret.getText(), fldTag.getText(), "Istorie"});
                    fldAutor.setText("Autor");
                    fldTitlu.setText("Titlu");
                    fldISBN.setText("ISBN");
                    fldPret.setText("Pret");
                    fldTag.setText("Tag");
                    lblICon.setIcon(null);
                }
            } else if (cmbCarti.getSelectedIndex() == 1) {
                for (int d = 0; d < listTable.getRowCount(); d++) {
                    if (listTable.getValueAt(d, 2).equals(fldISBN.getText())) {
                        lblTerminal.setText("Cartea exista deja in librarie!");
                        flag = true;
                        lblICon.setIcon(image);
                        break;
                    }
                }
                if (listTable.getRowCount() >= 100) {
                    lblTerminal.setText("Pragul maxim de o 100 de carti a fost atins!");
                    lblICon.setIcon(image);
                } else if (!flag) {
                    lblTerminal.setText("Am adaugat o carte de Beletristica.");
                    listTableModel.addRow(new Object[]{fldTitlu.getText(), fldAutor.getText(), fldISBN.getText(), fldPret.getText(), fldTag.getText(), "Beletristica"});
                    fldAutor.setText("Autor");
                    fldTitlu.setText("Titlu");
                    fldISBN.setText("ISBN");
                    fldPret.setText("Pret");
                    fldTag.setText("Tag");
                    lblICon.setIcon(null);
                }
            }
        });

        btnSterge.addActionListener(e -> {
            if (cmbSters.getSelectedIndex() == 0) {
                lblTerminal.setText("Sterge Autor");
                for (int d = listTable.getRowCount() - 1; d >= 0; d--) {
                    if (listTable.getValueAt(d, 1).equals(fldSterge.getText())) {
                        listTableModel.removeRow(d);
                        listTableModel.getDataVector();
                    }
                }
                fldSterge.setText("<sterge>");
            } else if (cmbSters.getSelectedIndex() == 1) {
                lblTerminal.setText("Sterge ISBN");
                for (int d = 0; d < listTable.getRowCount(); d++) {
                    if (listTable.getValueAt(d, 2).equals(fldSterge.getText())) {
                        listTableModel.removeRow(d);
                        break;
                    }
                }
                fldSterge.setText("<sterge>");
            }
        });

        btnAfiseaza.addActionListener(e -> {
            lblICon.setIcon(null);
            if (cmbAfiseaza.getSelectedIndex() == 1) {
                lblTerminal.setText("Afiseaza cartile de Istorie.");
                sorter.setRowFilter(RowFilter.regexFilter(".*Istorie.*"));
                listTable.setRowSorter(sorter);
            } else if (cmbAfiseaza.getSelectedIndex() == 2) {
                lblTerminal.setText("Afiseaza cartile de Beletristica.");
                sorter.setRowFilter(RowFilter.regexFilter(".*Beletristica.*"));
                listTable.setRowSorter(sorter);
            } else {
                lblTerminal.setText("Afiseaza toate cartile.");
                sorter.setRowFilter(null);
            }
        });

        JFrame appLib = new JFrame("AppLib");
        appLib.setSize(850, 350);
        appLib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        appLib.add(cmbAfiseaza);
        appLib.add(cmbCarti);
        appLib.add(cmbSters);

        appLib.add(btnAdauga);
        appLib.add(btnAfiseaza);
        appLib.add(btnSterge);

        appLib.add(fldTitlu);
        appLib.add(fldAutor);
        appLib.add(fldISBN);
        appLib.add(fldPret);
        appLib.add(fldTag);
        appLib.add(lblICon);

        appLib.add(lblTerminal);
        appLib.add(fldSterge);

        appLib.add(scrollPane);
        appLib.add(myPanel);

        appLib.setVisible(true);
    }

    public static void main(String[] args) {
        new AppLib();
    }
}
