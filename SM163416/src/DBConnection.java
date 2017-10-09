
public interface DBConnection {
	static final String ICSI518_SERVER=System.getenv("ICSI518_SERVER");
	static final int ICSI518_PORT=Integer.parseInt(System.getenv("ICSI518_PORT"));
	static final String ICSI518_DB=System.getenv("ICSI518_DB");
	static final String ICSI518_USER=System.getenv("ICSI518_USER");
	static final String ICSI518_PASSWORD=System.getenv("ICSI518_PASSWORD");
	
}
