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
  
    private static final long serialVersionUID = 1L;
    TipCalculator tc = new TipCalculator();
    private JTextField billAmountField = new JTextField(10);
    private JSlider tipPercentageSlider=new JSlider(0,50,20);
    private JSpinner partySizeSpinner=new JSpinner(new SpinnerNumberModel(1,1,20,1));
    private JButton calculateButton = new JButton("Calculate");
    private JButton clearButton = new JButton("Clear Numbers");
    private JLabel totalBillLabel = new JLabel();
    private JLabel individualShareLabel=new JLabel();

    private TipApp(String title) {
        super(title);
    }
  
    private void createAndShowGUI() {
        initComponents();
        addListners();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    private void addListners(){
        tipPercentageSlider.addChangeListener(this);
        partySizeSpinner.addChangeListener(this);
        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);

    }
    private void initComponents(){
       
        JPanel mainPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(new JLabel("Bill amount"));       
        mainPanel.add(billAmountField);
        mainPanel.add(new JLabel("Tip Percentage"));
        mainPanel.add(tipPercentageSlider);
        tipPercentageSlider.setMinorTickSpacing(1);
        tipPercentageSlider.setMajorTickSpacing(10);
        tipPercentageSlider.setPaintTicks(true);
        tipPercentageSlider.setPaintLabels(true);
        mainPanel.add(new JLabel("Party Size:"));
        mainPanel.add(partySizeSpinner);
        ((JSpinner.DefaultEditor) partySizeSpinner.getEditor()).getTextField().setEditable(false);
        mainPanel.add(calculateButton);
        mainPanel.add(clearButton);
        mainPanel.add(new JLabel("Total bill(with tip)"));
        mainPanel.add(totalBillLabel);
        mainPanel.add(new JLabel("Individual Share:"));
        totalBillLabel.setText("$ 0.00");
        individualShareLabel.setText("$ 0.00");
        mainPanel.add(individualShareLabel);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        add(mainPanel);
    }
    @Override
    public void stateChanged(ChangeEvent ce) {
        tc.setTipPercentage(tipPercentageSlider.getValue());
        tc.setPartySize((int)partySizeSpinner.getValue());

    }
    @Override
    
    public void actionPerformed(ActionEvent ae) {
        double billamttodouble=0;
        
        if(ae.getSource()==calculateButton){
            try{
                billamttodouble=Double.parseDouble(billAmountField.getText());
                if(billamttodouble>0) {
                    tc.setBillAmount(billamttodouble);
                    totalBillLabel.setText("$"+String.format("%.2f",tc.getTotalBill()));
                    individualShareLabel.setText("$"+String.format("%.2f",tc.getIndividualShare(tc.getTotalBill())));
                }
                else if(billamttodouble<=0){
                    JOptionPane.showMessageDialog(null, "Bill amount must be greater than 0");
                }

            }
            catch(NumberFormatException nfe){

                JOptionPane.showMessageDialog(null, "Bill amount must be numeric");
            }

        }
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
        EventQueue.invokeLater(() -> {
            TipApp mainFrame = new TipApp("Tip Calculator");
            mainFrame.createAndShowGUI();
        });

    }

}
