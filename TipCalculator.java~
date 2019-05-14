class TipCalculator 
{
   //data members of TipCalculator class
     private double BillAmount;
     private int TipPercentage;
     private int PartySize;
     TipCalculator() // default constructor
     {
          BillAmount = 0;
          TipPercentage = 20; 
          PartySize = 1;
     }
     
     public void setBillAmount(double BillAmount) //setter method
     {
          this.BillAmount = BillAmount;
     }
     
     public double getBillAmount() //getter method
     {
          return BillAmount;
     }
     
     public void setTipPercentage(int TipPercentage)
     {
          this.TipPercentage = TipPercentage;
     }
     
     public int getTipPercentage()
     {
          return TipPercentage;
     }
     
     public void setPartySize(int PartySize)
     {
          this.PartySize = PartySize;
     }
     
     public int getPartySize()
     {
          return PartySize;
     }
     
     public double getTotalBill() //to calculate total bill 
     {
          double TotalBill;
          TotalBill = BillAmount + (BillAmount*TipPercentage)/100;
          return TotalBill;
     }
     
     public double getIndividualShare(double Bill) //to calculate individual share
     {
          double IndividualShare;
          IndividualShare = Bill/PartySize;
          return IndividualShare;
     }
}

