package excelread;



import org.testng.annotations.DataProvider;

public class Dataprovider {

@DataProvider
public static Object[][]login() throws Exception{
	Object[][] readdata =Excelread.getdata(Excelread.path,Excelread.Sheet); 
	return (readdata);
}

@DataProvider
public static Object[][]SearchFlight1() throws Exception{
	Object[][] readdata =Excelread.getdata(Excelread.path,Excelread.Sheet1); 
	return (readdata);
}



}
