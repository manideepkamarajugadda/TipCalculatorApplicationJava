class TipCalculator 
{
   
     private double BillAmount;
     private int TipPercentage;
     private int PartySize;
     TipCalculator() 
     {
          BillAmount = 0;
          TipPercentage = 20; 
          PartySize = 1;
     }
     
     public void setBillAmount(double BillAmount) 
     {
          this.BillAmount = BillAmount;
     }
     
     public double getBillAmount() 
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
     
     public double getTotalBill()
     {
          double TotalBill;
          TotalBill = BillAmount + (BillAmount*TipPercentage)/100;
          return TotalBill;
     }
     
     public double getIndividualShare(double Bill) 
     {
          double IndividualShare;
          IndividualShare = Bill/PartySize;
          return IndividualShare;
     }
}

