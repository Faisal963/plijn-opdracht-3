import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) {
		try {
			ReizigerOracleDaolmpl db = new ReizigerOracleDaolmpl();		
			OvChipkaartOracleDaoLmpl dbo = new OvChipkaartOracleDaoLmpl();	
			ProductOracleDaoLmpl dbp = new ProductOracleDaoLmpl();
			
			for (OvChipkaart ov : dbo.findByReiziger(2)) {
				System.out.println(ov.getKaartNummer());
			}
			
			Reiziger r1 = new Reiziger();
			Reiziger r2 = new Reiziger();
			Reiziger r3 = new Reiziger();
			
			Date datum1 = new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2019");
			r1.setNaam("F Alhag");
			r1.setGBdatum(datum1);
			r1 = db.save(r1);
			
			r2.setNaam("M Klaas");
			r2 = db.save(r2);

			r3.setNaam("N Klaas2");
			r3 = db.save(r3);

			for (Reiziger r : db.findAll()) {
				System.out.println(r.getNaam());
			}

			System.out.println("gedaan");
			
			r1.setNaam("X Alhag");
			db.update(r1);

			for (Reiziger r : db.findAllByGBdatum("08-08-1995")) {
				System.out.println(r.getNaam());
			}
			System.out.println("al gedaan ");
			
			db.delete(r3);
			System.out.println("alles gedaan");
			
			OvChipkaart o1 = new OvChipkaart();
			o1.setKaartNummer(1231241);
			o1.setKlasse(1);
			o1.setReizigerId(2);
			o1.setSaldo(11.11);
			dbo.save(o1);
			
			OvChipkaart o2 = new OvChipkaart();
			o2.setKaartNummer(5678142);
			o2.setKlasse(2);
			o2.setReizigerId(2);
			o2.setSaldo(83.11);
			dbo.save(o2);
			
			Product product1 = new Product();
			product1.setProductNaam("12wert");
			product1.setBeschrijving("Dit is de beschrijving 1");
			product1.setPrijs(50.2);
			product1.setProductnummer(14);
			dbp.save(product1);
			
			Product product2 = new Product();
			product2.setProductNaam("12wert");
			product2.setBeschrijving("Dit is de beschrijving 2");
			product2.setPrijs(10.3);
			product2.setProductnummer(15);
			dbp.save(product2);
			
			dbo.linkProduct(o1, product1);
			
			System.out.println("gedaan");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
