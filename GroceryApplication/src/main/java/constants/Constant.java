package constants;

public class Constant {
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\GroceryAppExcel.xlsx";
	
	public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR="user is able to login with invalid credentials";
	public static final String INVALIDUSERNAMEVALIDPSWERROR="user is able to login with invalid credentials";
	public static final String VALIDUSERNAMEINVALIDPSWERROR="user is able to login with invalid credentials";
	
	public static final String LOGOUT="User not logged out";
	
	public static final String ADMINUSERCREATE="admin user is not created";
	public static final String ADMINUSERSEARCH="Search result not found";
	public static final String ADMINUSERRESET="Page not resetted";
	
	public static final String NEWSCREATE="News not created";
	public static final String NEWSSEARCH="News can't be searched";
	public static final String NEWSRESET="Reset is not done";


}
