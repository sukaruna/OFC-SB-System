
public class test
{
	public static void main(String[] args)
	{
		String databaseName = "ofcsbinventory";
		String instanceConnectionName = "ofc-sb-system:us-central1:myinstance";
		String jdbcUrl = String.format(
			    "jdbc:mysql://google/%s?cloudSqlInstance=%s"
			        + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
			    databaseName,
			    instanceConnectionName);
		System.out.println(jdbcUrl);
	}
}
