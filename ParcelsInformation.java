
public class ParcelsInformation {
	private String trackNum;
	private String senderName;
	private String recipName;
	private String sendAddress;
	private String recipAddress;
	private int sendPostcode;
	private int recipPostcode;
	private double weight;
	private double length;
	private double height;
	private String shipType;
	private String parcelType;
	private String shipCategory;
	private String shipDate;
	private String deliverDate;
	
	
	public ParcelsInformation () {
		this.trackNum = "";
		this.senderName = "";
		this.recipName = "";
		this.sendAddress = "";
		this.recipAddress = "";
		this.sendPostcode = 0;
		this.recipPostcode = 0;
		this.weight = 0.0;
		this.length = 0.0;
		this.height = 0.0;
		this.shipType = "";
		this.parcelType = "";
		this.shipCategory = "";
		this.shipDate = "";
		this.deliverDate = "";
	}
	
	public ParcelsInformation(String trackNum,String senderName, String recipName, String sendAddress, String recipAddress, int recipPostcode, int sendPostcode, double weight, double length, double height, String shipType, String parcelType, String shipCategory, String shipDate, String deliverDate) {
		this.trackNum = trackNum;
		this.senderName = senderName;
		this.recipName = recipName;
		this.sendAddress = sendAddress;
		this.recipAddress = recipAddress;
		this.sendPostcode = sendPostcode;
		this.recipPostcode = recipPostcode;
		this.weight = weight;
		this.length = length;
		this.height = height;
		this.shipType = shipType;
		this.parcelType = parcelType;
		this.shipCategory = shipCategory;
		this.shipDate = shipDate;
		this.deliverDate = deliverDate;
	}
	
	

	public String getTrackNum() {
		return trackNum;
	}

	public void setTrackNum(String trackNum) {
		this.trackNum = trackNum;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getRecipName() {
		return recipName;
	}

	public void setRecipName(String recipName) {
		this.recipName = recipName;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getRecipAddress() {
		return recipAddress;
	}

	public void setRecipAddress(String recipAddress) {
		this.recipAddress = recipAddress;
	}

	public int getSendPostcode() {
		return sendPostcode;
	}

	public void setSendPostcode(int sendPostcode) {
		this.sendPostcode = sendPostcode;
	}

	public int getRecipPostcode() {
		return recipPostcode;
	}

	public void setRecipPostcode(int recipPostcode) {
		this.recipPostcode = recipPostcode;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getParcelType() {
		return parcelType;
	}

	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}

	public String getShipCategory() {
		return shipCategory;
	}

	public void setShipCategory(String shipCategory) {
		this.shipCategory = shipCategory;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	
	double international = 50.0;
	double domestic = 7.0;
	double shipRate = 0.0;

	public double CalculateShippingRate(String shipCategory) {
		
		
		if (shipCategory.equalsIgnoreCase("international")) {
			shipRate = weight*international;
		} else if (shipCategory.equalsIgnoreCase("domestic")) {
			shipRate = weight*domestic;
		}
		
		if (shipType.equalsIgnoreCase("next day delivery")){
			shipRate = shipRate + 10.0;
		}
		 
		return shipRate;
	}
	
	

	public String toString() {
		return "\nTrack Number: " + getTrackNum() + "\nSender Name: " + getSenderName() + "\nRecipient Name: " + getRecipName() + "\nSender Address: " + getSendAddress() + "\nRecipient Address: " + getRecipAddress() + "\nSender Postcode: " + getSendPostcode() + "\nRecipient Postcode: " + getRecipPostcode() + "\nWeight: " + getWeight() + "\nLength: " + getLength() + "\nHeight: " + getHeight() + "\nShipping Type: " + getShipType() + "\nParcel Type: " + getParcelType() + "\nShipping Category: " + getShipCategory() + "\nShipping Date: " + getShipDate() + "\nDelivery Date: " + getDeliverDate() +"\nShipping Rate: RM " + CalculateShippingRate(shipCategory); 
	}

	
}
