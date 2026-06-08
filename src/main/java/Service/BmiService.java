package Service;

public class BmiService {

	public double calcBmi(String height, String weight) {
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		double result = w / (h * h);
		return result;
	}

	public String getRank(double bmi) {
		String result;
		if(bmi < 18.5) {
			result = "やせ気味";
		}else if(bmi < 25){
			result = "標準";
		}else {
			result = "肥満気味";
		}
		return result;
	}
}
