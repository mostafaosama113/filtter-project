package filterProject;

public class Tools {
	
	public static String emailFiltter(String txt) {
		StringBuilder sb = new StringBuilder();
		for(String x : txt.split("[\\s]"))
		{
			if(x.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
				sb.append(x + "\n");
		}
		if(sb.toString().isEmpty())
			return "No Emails found";
		return sb.toString();
	}
	
	public static String PhoneNumberFiltter(String txt) {
		StringBuilder sb = new StringBuilder();
		for(String x : txt.split("[\\s]"))
		{
			if(x.matches("^[0][1]\\d{9}$"))
				sb.append(x + "\n");
		}
		if(sb.toString().isEmpty())
			return "No Phone numbers found";
		return sb.toString();
	}
	
	public static String idFiltter(String txt) {
		StringBuilder sb = new StringBuilder();
		for(String x : txt.split("[\\s]"))
		{
			if(x.matches("[\\d]{2}[-]?[\\d]{5}"))
				sb.append(x + "\n");
		}
		if(sb.toString().isEmpty())
			return "No IDs found";
		return sb.toString();
	}
}
