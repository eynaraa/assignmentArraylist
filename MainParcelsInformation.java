import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.lang.IndexOutOfBoundsException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Formatter;  


public class MainParcelsInformation {
	
	public static void main (String [] args) throws IndexOutOfBoundsException  {
		try {
			
			//create reader
			ArrayList<ParcelsInformation> ParcelsList = new ArrayList<ParcelsInformation>();
			BufferedReader in = new BufferedReader(new FileReader("courier.txt"));
			
			
			
			
			//create an array of object
			
			String indata = null;
            int index = 0;
            
            while((indata = in.readLine()) != null) {
				StringTokenizer st = new StringTokenizer (indata, ";");
				String trackNum = st.nextToken();
				String senderName = st.nextToken();
				String recipName = st.nextToken();
				String sendAddress = st.nextToken();
				String recipAddress = st.nextToken();
				int sendPostcode = Integer.parseInt(st.nextToken());
				int recipPostcode = Integer.parseInt(st.nextToken());
				double weight = Double.parseDouble(st.nextToken());
				double length = Double.parseDouble(st.nextToken());
				double height = Double.parseDouble(st.nextToken());
				String shipType = st.nextToken();
				String parcelType = st.nextToken();
				String shipCategory = st.nextToken();
				String shipDate = st.nextToken();
				String deliverDate = st.nextToken();
				
				//create object
				ParcelsInformation p1 = new ParcelsInformation(trackNum,senderName,recipName,sendAddress,recipAddress,recipPostcode,sendPostcode,weight, length, height, shipType, parcelType, shipCategory, shipDate, deliverDate);
				ParcelsList.add(p1);

			}
			
		    String trackN;
			String sendN;
			String recipientN;
			String sendAdd;
			String recipientAdd;
			int sendP;
			int recipientP;
			double w;
			double l;
			double h;
			String shipT;
			String parcelT;
			String shipC;
			String shipD;
			String deliverD;
			
			int menu;
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
			
			do {
				//ask use to input choice of menu
				menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Please choose menu" + "\n1 - add parcel" + "\n2 - remove parcel" + "\n3 - update delivery date for parcel" + "\n4 - Display parcel information" + "\n5 - Exit"));
				
				if(menu == 1) {
					trackN = null;
					sendN = JOptionPane.showInputDialog(null, "Enter sender name");
					recipientN = JOptionPane.showInputDialog(null, "Enter recipient name");
					sendAdd = JOptionPane.showInputDialog(null, "Enter sender address");
					recipientAdd = JOptionPane.showInputDialog(null, "Enter recipient address");
					sendP = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter sender postcode"));
					recipientP = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter recipient postcode"));
					
					w = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter parcel's weight"));
					
					
					while(w < 0) {
						
						JOptionPane.showMessageDialog(null, "Weight cannot be in negative form");
						w = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter parcel's weight"));
						if(w > 0) {
							break;
					    }
					
					
					}
					
					
					l = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter parcel's length"));
                    while(l < 0) {
						
						JOptionPane.showMessageDialog(null, "Length cannot be in negative form");
						l = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter parcel's length"));
						if(l > 0) {
							break;
					    }
					
					
					}
					h = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter parcel's height"));
                    while(h < 0) {
						
						JOptionPane.showMessageDialog(null, "Weight cannot be in negative form");
						h = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter parcel's height"));
						if(h > 0) {
							break;
					    }
					
					
					}
					shipT = JOptionPane.showInputDialog(null, "Enter shipping type");
					parcelT = JOptionPane.showInputDialog(null, "Enter parcel type");
					shipC = JOptionPane.showInputDialog(null, "Enter shipping category");
					shipD = JOptionPane.showInputDialog(null, "Enter shipping date" + "\n*eg: 04-06-2002");
					deliverD = JOptionPane.showInputDialog(null, "Enter delivery date" + "\n*eg: 04-06-2002");
					
					JOptionPane.showConfirmDialog(null, "Please Confirm Your Parcel Information below\n\n" + "Sender:" + sendN + "\nRecipient:" + recipientN + "\nSender Address:" + sendAdd + "\nRecipient Address:" + recipientAdd + "\nSender Postcode:" + sendP + "\nRecipient Postcode:" + recipientP + "\nWeight:" + w + "\nLength:" + l + "\nHeight:" + h + "\nShipping Type:" + shipT + "\nParcel Type:" + parcelT + "\nShipping Category:" + shipC + "\nShipping Date:" + shipD + "\nDelivery Date:" + deliverD, "Parcel Confirmation", dialogButton ); 
					
					if(dialogButton == JOptionPane.YES_OPTION && w > 0 && l > 0 && h > 0) {
						ParcelsInformation p2 = new ParcelsInformation(trackN, sendN, recipientN, sendAdd, recipientAdd, sendP, recipientP, w, l, h, shipT, parcelT, shipC, shipD, deliverD);
					    ParcelsList.add(p2);
					}
				} else if (menu == 2) {
					
					ParcelsInformation parc;
					
					String trackNumDel = JOptionPane.showInputDialog(null, "Enter parcel's tracking number you want to remove");
					
					JOptionPane.showMessageDialog(null, "Your " + trackNumDel + " parcel tracking number has been removed");
					
					//remove parcel
					for(int i = 0; i<ParcelsList.size(); i++) {
						parc = ParcelsList.get(i);
						if(parc.getTrackNum().equalsIgnoreCase(trackNumDel)) {
							ParcelsList.remove(parc);
						}
					}

					
				} else if (menu == 3) {
					
					//ask user to input tracking number they want to update
					String trackNumUp = JOptionPane.showInputDialog("Enter parcel's tracking number you want to update");
					for(int i = 0; i < ParcelsList.size(); i++) {
						ParcelsInformation parc;
						parc = ParcelsList.get(i);
						if(parc.getTrackNum().equalsIgnoreCase(trackNumUp)) {
							
							String deliverDUp = JOptionPane.showInputDialog("Enter your new parcel delivery date");
							
							parc.setDeliverDate(deliverDUp);
							ParcelsList.set(i, parc);
						}
						
						
					}
					
					

					
					
				} else if (menu == 4) {
					//all parcel information
					System.out.println("**ALL PARCELS INFORMATION**\n");
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s %20s", "TRACKING NUMBER", "SENDER NAME", "RECIPIENT NAME", "SENDER ADDRESS", "RECIPIENT ADDRESS", "SENDER POSTCODE", "RECIPIENT POSTCODE", "WEIGHT", "LENGTH", "HEIGHT", "SHIPPING TYPE", "PARCEL TYPE", "SHIPPING CATEGORY", "SHIPPING DATE", "DELIVERY DATE", "SHIPPING RATE");  
					System.out.println();  
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					for(ParcelsInformation PI: ParcelsList)  
					{
					
					System.out.format("%20s %20s %20s %20s %20s %19s %19s %10s %10s %10s %20s %20s %20s %20s %20s %20s", PI.getTrackNum(), PI.getSenderName(), PI.getRecipName(), PI.getSendAddress(), PI.getRecipAddress(), PI.getSendPostcode(), PI.getRecipPostcode(), PI.getWeight(), PI.getLength(), PI.getHeight(), PI.getShipType(), PI.getParcelType(), PI.getShipCategory(), PI.getShipDate(), PI.getDeliverDate(), PI.CalculateShippingRate(PI.getShipCategory()));
					System.out.println();  
					}  
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");  
					
					
					//domestic shipping type parcel information
					System.out.println("**ALL DOMESTIC SHIPPING TYPE PARCELS INFORMATION**\n");
			        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s %20s", "TRACKING NUMBER", "SENDER NAME", "RECIPIENT NAME", "SENDER ADDRESS", "RECIPIENT ADDRESS", "SENDER POSTCODE", "RECIPIENT POSTCODE", "WEIGHT", "LENGTH", "HEIGHT", "SHIPPING TYPE", "PARCEL TYPE", "SHIPPING CATEGORY", "SHIPPING DATE", "DELIVERY DATE", "SHIPPING RATE (RM)");  
     				System.out.println();  
     				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
							          
					for (ParcelsInformation dom: ParcelsList)
					{
			        if(dom.getShipCategory().equalsIgnoreCase("domestic")){
			        	
					    System.out.format("%20s %20s %20s %20s %20s %19s %19s %10s %10s %10s %20s %20s %20s %20s %20s %10s", dom.getTrackNum(), dom.getSenderName(), dom.getRecipName(),dom.getSendAddress(), dom.getRecipAddress(), dom.getSendPostcode(), dom.getRecipPostcode(), dom.getWeight(), dom.getLength(), dom.getHeight(), dom.getShipType(), dom.getParcelType(), dom.getShipCategory(), dom.getShipDate(), dom.getDeliverDate(), dom.CalculateShippingRate(dom.getShipCategory()));
					    System.out.println();  
					}  
					}
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");  
			                  
					
					//international shipping type parcel information
					System.out.println("**ALL INTERNATIONAL SHIPPING TYPE PARCELS INFORMATION**\n");
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s %20s", "TRACKING NUMBER", "SENDER NAME", "RECIPIENT NAME", "SENDER ADDRESS", "RECIPIENT ADDRESS", "SENDER POSTCODE", "RECIPIENT POSTCODE", "WEIGHT", "LENGTH", "HEIGHT", "SHIPPING TYPE", "PARCEL TYPE", "SHIPPING CATEGORY", "SHIPPING DATE", "DELIVERY DATE", "SHIPPING RATE (RM)");  
					System.out.println();  
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  

					for (ParcelsInformation dom: ParcelsList)
					{
			        if(dom.getShipCategory().equalsIgnoreCase("international")){
			        	
					    System.out.format("%20s %20s %20s %20s %20s %19s %19s %10s %10s %10s %20s %20s %20s %20s %20s %10s", dom.getTrackNum(), dom.getSenderName(), dom.getRecipName(),dom.getSendAddress(), dom.getRecipAddress(), dom.getSendPostcode(), dom.getRecipPostcode(), dom.getWeight(), dom.getLength(), dom.getHeight(), dom.getShipType(), dom.getParcelType(), dom.getShipCategory(), dom.getShipDate(), dom.getDeliverDate(), dom.CalculateShippingRate(dom.getShipCategory()));
					    System.out.println();  
					}  
					}
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");  
			              
			        
			       
			        System.out.println("**ALL FRAGILE PARCEL TYPE PARCELS INFORMATION**\n");
			        //count fragile parcel type
					int fragcount = 0;
			        for (int i=0; i<ParcelsList.size(); i++){
			            ParcelsInformation frag = ParcelsList.get(i);
			            if(frag.getParcelType().equalsIgnoreCase("fragile")){
			                fragcount++;
			            }
			        }
			        System.out.println("Parcel with fragile parcel type : " + fragcount);//display count for fragile parcel type
			        
			        //display fragile parcel type parcel
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s", "TRACKING NUMBER", "SENDER NAME", "RECIPIENT NAME", "SENDER ADDRESS", "RECIPIENT ADDRESS", "SENDER POSTCODE", "RECIPIENT POSTCODE", "WEIGHT", "LENGTH", "HEIGHT", "SHIPPING TYPE", "PARCEL TYPE", "SHIPPING CATEGORY", "SHIPPING DATE", "DELIVERY DATE");  
					System.out.println();  
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  

					for (ParcelsInformation frag: ParcelsList)
					{
			        if(frag.getParcelType().equalsIgnoreCase("fragile")){
			        	
					    System.out.format("%20s %20s %20s %20s %20s %19s %19s %10s %10s %10s %20s %20s %20s %20s %20s", frag.getTrackNum(), frag.getSenderName(), frag.getRecipName(),frag.getSendAddress(), frag.getRecipAddress(), frag.getSendPostcode(), frag.getRecipPostcode(), frag.getWeight(), frag.getLength(), frag.getHeight(), frag.getShipType(), frag.getParcelType(), frag.getShipCategory(), frag.getShipDate(), frag.getDeliverDate());
					    System.out.println();  
					}  
					}
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
			       
			        
			       
			        System.out.println("**ALL NON-FRAGILE PARCEL TYPE PARCELS INFORMATION**\n");
			        
			        //count non-fragile parcel type
					int nonfragcount = 0;
			        for (int i=0; i<ParcelsList.size(); i++){
			            ParcelsInformation nonfrag = ParcelsList.get(i);
			            if(nonfrag.getParcelType().equalsIgnoreCase("non-fragile")){
			                nonfragcount++;
			            }
			        }
			        System.out.println("Parcel with fragile parcel type : " + nonfragcount);//display count for fragile parcel type
			        
			        //display non-fragile parcel type parcel
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s", "TRACKING NUMBER", "SENDER NAME", "RECIPIENT NAME", "SENDER ADDRESS", "RECIPIENT ADDRESS", "SENDER POSTCODE", "RECIPIENT POSTCODE", "WEIGHT", "LENGTH", "HEIGHT", "SHIPPING TYPE", "PARCEL TYPE", "SHIPPING CATEGORY", "SHIPPING DATE", "DELIVERY DATE");  
					System.out.println();  
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  

					for (ParcelsInformation nonfrag: ParcelsList)
					{
			        if(nonfrag.getParcelType().equalsIgnoreCase("non-fragile")){
			        	
					    System.out.format("%20s %20s %20s %20s %20s %19s %19s %10s %10s %10s %20s %20s %20s %20s %20s", nonfrag.getTrackNum(), nonfrag.getSenderName(), nonfrag.getRecipName(),nonfrag.getSendAddress(), nonfrag.getRecipAddress(), nonfrag.getSendPostcode(), nonfrag.getRecipPostcode(), nonfrag.getWeight(), nonfrag.getLength(), nonfrag.getHeight(), nonfrag.getShipType(), nonfrag.getParcelType(), nonfrag.getShipCategory(), nonfrag.getShipDate(), nonfrag.getDeliverDate());
					    System.out.println();  
					}  
					}
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
			        
	
			        //list and display large parcels 
			        System.out.println("**ALL LARGE PARCELS INFORMATION**\n");
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s", "TRACKING NUMBER", "SENDER NAME", "RECIPIENT NAME", "SENDER ADDRESS", "RECIPIENT ADDRESS", "SENDER POSTCODE", "RECIPIENT POSTCODE", "WEIGHT", "LENGTH", "HEIGHT", "SHIPPING TYPE", "PARCEL TYPE", "SHIPPING CATEGORY", "SHIPPING DATE", "DELIVERY DATE");  
					System.out.println();  
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  

					for (ParcelsInformation weight: ParcelsList)
					{
			        if(weight.getWeight() > 5){
			        	
					    System.out.format("%20s %20s %20s %20s %20s %19s %19s %10s %10s %10s %20s %20s %20s %20s %20s", weight.getTrackNum(), weight.getSenderName(), weight.getRecipName(),weight.getSendAddress(), weight.getRecipAddress(), weight.getSendPostcode(), weight.getRecipPostcode(), weight.getWeight(), weight.getLength(), weight.getHeight(), weight.getShipType(), weight.getParcelType(), weight.getShipCategory(), weight.getShipDate(), weight.getDeliverDate());
					    System.out.println();  
					}  
					}
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
			                 
					
			        //list and display all the next day delivery shipping type parcel
					System.out.println("**ALL THE NEXT DAY DELIVERY SHIPPING TYPE PARCELS INFORMATION**\n");
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
					System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s %20s", "TRACKING NUMBER", "SENDER NAME", "RECIPIENT NAME", "SENDER ADDRESS", "RECIPIENT ADDRESS", "SENDER POSTCODE", "RECIPIENT POSTCODE", "WEIGHT", "LENGTH", "HEIGHT", "SHIPPING TYPE", "PARCEL TYPE", "SHIPPING CATEGORY", "SHIPPING DATE", "DELIVERY DATE", "SHIPPING RATE (RM)");  
					System.out.println();  
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  

					for (ParcelsInformation nextD: ParcelsList)
					{
			        if(nextD.getShipType().equalsIgnoreCase("next day delivery")){
			        	
					    System.out.format("%20s %20s %20s %20s %20s %20s %20s %10s %10s %10s %20s %20s %20s %20s %20s %20s", nextD.getTrackNum(), nextD.getSenderName(), nextD.getRecipName(),nextD.getSendAddress(), nextD.getRecipAddress(), nextD.getSendPostcode(), nextD.getRecipPostcode(), nextD.getWeight(), nextD.getLength(), nextD.getHeight(), nextD.getShipType(), nextD.getParcelType(), nextD.getShipCategory(), nextD.getShipDate(), nextD.getDeliverDate(), nextD.CalculateShippingRate(nextD.getShipCategory()));
					    System.out.println();  
					}  
					}
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
			                 
					
			        
			        
			        
				} else if (menu == 5) {
					System.exit(0);
				}
				
				
				
	       } while(menu < 6);
			
			
			
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
