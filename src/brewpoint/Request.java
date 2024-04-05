package brewpoint;

public class Request {
	
	public static String prodName;
	public static int prod_ID;
	public static int unit_price;
	public static String unit_size;
	public static String powder;
	public static String addons;
	public static int quantity;
	
	public static void addItem() {
		if (unit_size == "small") {
			unit_price = 29;
		} else if (unit_size == "medium") {
			unit_price = 39;
		} else if (unit_size == "large") {
			unit_price = 49;
		}
		
		System.out.println(prodName);
		System.out.println(unit_size);
		System.out.println(unit_price);
		System.out.println(powder);
		System.out.println(addons);
		
		
		if (Main.step1 && Main.step2 && Main.step3) {
			Main.orderListModel.addElement(prodName + " " + unit_size + " " + addons + " " + " QTY: " + quantity + " - P" + (unit_price*quantity)+"");
		}
		
		Main.slider.setValue(1);
		Main.step1 = false;
		Main.step2 = false;
		Main.step3 = false;
		
	}
}
