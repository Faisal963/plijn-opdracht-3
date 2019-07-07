import java.util.ArrayList;
import java.util.List;

public class Product {
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private int productnummer;
	private List<OvChipkaart> ovs = new ArrayList<OvChipkaart>();
	
	public Product() {}
	
	public void setProductnummer(int productnummer) {
		this.productnummer = productnummer;
	}
	
	public int getProductnummer() {
		return this.productnummer;
	}
	
	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}
	
	public String getProductNaam() {
		return this.productNaam;
	}
	
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	
	public String getBescrijving() {
		return this.beschrijving;
	}
	
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public double getPrijs() {
		return this.prijs;
	}
	
	public void voegOvToe(OvChipkaart ov) {
		if (!this.ovs.contains(ov)) {
			this.ovs.add(ov);
		}
	}
}
