/***********************************
  *      Name : Sai Kiran Vunnam   *
  *      Name : Sahithi Damineni   *
  *                                *
  *       Z-Id: Z1840993           *
  *       Z-Id: Z1840906           * 
  *                                *
  *     Course: CSCI 502           *
  *                                *
  * Assignment: 5                  *
  *                                *
  *   Due Date: 03-29-2019         *
  * ********************************/
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class TipApp extends JFrame implements ActionListener, ChangeListener {

    /**
     * TipApp data members
     * billAmount textfield
     * tipPercentageSlider Jslider
     * partySizeSpinner JSpinner
     * calculateButton JButton
     * clearButton JButton
     * totalBillLabel JLabel
     * individualShareLablel Jlabel
     * **/
    private static final long serialVersionUID = 1L;
    //variable for Tipcalculator class
    TipCalculator tc = new TipCalculator();
    private JTextField billAmountField = new JTextField(10);
    private JSlider tipPercentageSlider=new JSlider(0,50,20);
    private JSpinner partySizeSpinner=new JSpinner(new SpinnerNumberModel(1,1,20,1));
    private JButton calculateButton = new JButton("Calculate");
    private JButton clearButton = new JButton("Clear Numbers");
    private JLabel totalBillLabel = new JLabel();
    private JLabel individualShareLabel=new JLabel();
    /**
     * Declate Title for GUI
     * */
    private TipApp(String title) {
        super(title);
    }
    /**
     * createAndShowGUI method which which calls initComponents method and initializes change and action listners
     * **/
    private void createAndShowGUI() {
        initComponents();
        addListners();
        // Display the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    // Add listeners for the buttons and changelistner for buttons
    private void addListners(){
        tipPercentageSlider.addChangeListener(this);
        partySizeSpinner.addChangeListener(this);
        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);

    }
    private void initComponents(){
        //main Jpanel griglayout 6x2
        JPanel mainPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //add bill amount label
        mainPanel.add(new JLabel("Bill amount"));
        //add bill amt text field
        mainPanel.add(billAmountField);
        //add tip percent label
        mainPanel.add(new JLabel("Tip Percentage"));
        //add tippercentage slider label
        mainPanel.add(tipPercentageSlider);
        tipPercentageSlider.setMinorTickSpacing(1);
        tipPercentageSlider.setMajorTickSpacing(10);
        tipPercentageSlider.setPaintTicks(true);
        tipPercentageSlider.setPaintLabels(true);
        //add party size label
        mainPanel.add(new JLabel("Party Size:"));
        //add partysize spinner
        mainPanel.add(partySizeSpinner);
        // disable text field
        ((JSpinner.DefaultEditor) partySizeSpinner.getEditor()).getTextField().setEditable(false);
        //add calculate button
        mainPanel.add(calculateButton);
        //addclear button
        mainPanel.add(clearButton);
        //add total bill wit tip label
        mainPanel.add(new JLabel("Total bill(with tip)"));
        ////element for displayinng total bill
        mainPanel.add(totalBillLabel);
        //add individual share label
        mainPanel.add(new JLabel("Individual Share:"));
        totalBillLabel.setText("$ 0.00");
        individualShareLabel.setText("$ 0.00");
        mainPanel.add(individualShareLabel);
        //add(mainPanel,BorderLayout.CENTER);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        add(mainPanel);
    }
    @Override
    public void stateChanged(ChangeEvent ce) {
        //fetch from changeevent setvalue for TipCalculator class
        tc.setTipPercentage(tipPercentageSlider.getValue());
        tc.setPartySize((int)partySizeSpinner.getValue());

    }
    /***
     * Action llistner to calculate and error checking
     * **/
    @Override
    public void actionPerformed(ActionEvent ae) {
        double billamttodouble=0;
        //calculate button when clicked
        if(ae.getSource()==calculateButton){
            try{
                billamttodouble=Double.parseDouble(billAmountField.getText());
                if(billamttodouble>0) {
                    tc.setBillAmount(billamttodouble);
                    totalBillLabel.setText("$"+String.format("%.2f",tc.getTotalBill()));
                    individualShareLabel.setText("$"+String.format("%.2f",tc.getIndividualShare(tc.getTotalBill())));
                }
                else if(billamttodouble<=0){
                    //dialogbox if bill amoount is less than or equal to zero
                    JOptionPane.showMessageDialog(null, "Bill amount must be greater than 0");
                }

            }
            catch(NumberFormatException nfe){

                JOptionPane.showMessageDialog(null, "Bill amount must be numeric");
            }

        }
        //clear button clicked
        if(ae.getSource()==clearButton){
            System.out.println("working");
            billAmountField.setText("");
            partySizeSpinner.setValue(1);
            tipPercentageSlider.setValue(20);
            totalBillLabel.setText("$ 0.00");
            individualShareLabel.setText("$ 0.00");
        }
    }
    public static void main(String[] args) {
        //invoke later lamda expression
        EventQueue.invokeLater(() -> {
            //TipApp class local variable
            TipApp mainFrame = new TipApp("Tip Calculator");
            mainFrame.createAndShowGUI();
        });

    }

}
