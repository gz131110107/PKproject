package Control;


import java.util.List;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.io.OutputStreamWriter;  
import java.io.PrintWriter;  
import java.io.UnsupportedEncodingException;  

import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import Factory.HibernateSessionFactory;
public class DateControl {  
	/** MySQL安装目录的Bin目录的绝对路径 */  
private static String mysqlBinPath;  
   public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
/** 访问MySQL数据库的用户名 */  
private static String username;  
    /** 访问MySQL数据库的密码 */  
    private static String password;   
    public String getMysqlBinPath() {  
        return mysqlBinPath;  
    }  
    public void setMysqlBinPath(String mysqlBinPath) {  
        this.mysqlBinPath = mysqlBinPath;  
    }  
   
    public DateControl(String mysqlBinPath,String username,String password) {  
      /* if (!mysqlBinPath.endsWith(File.separator)) {  
            mysqlBinPath = mysqlBinPath + File.separator;  
       }  */
        this.mysqlBinPath = mysqlBinPath;  
        this.username = username;  
        this.password = password;  
    }  

    public static void backup(OutputStream output, String dbname) {  
        String command = "cmd /D:/mysql-5.6.24-winx64/bin "  + "mysqldump -root"  
                + " -123456"  + " --set-charset=utf8 " + dbname;  
        PrintWriter p = null;  
        BufferedReader reader = null;  
        try {  
            p = new PrintWriter(new OutputStreamWriter(output, "utf8"));  
            Process process = Runtime.getRuntime().exec("mysqldump --default-character-set=utf8 -u root -p123456 hotel_13");  
            InputStreamReader inputStreamReader = new InputStreamReader(process  
                   .getInputStream(),"utf8");  
            reader = new BufferedReader(inputStreamReader);  
            String line = null;  
           while ((line = reader.readLine()) != null) {  
               p.println(line);  
            }  
            p.flush();  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
       } catch (IOException e) {  
           e.printStackTrace();  
        } finally {  
            try {  
               if (reader != null) {  
                    reader.close();  
                }  
                if (p != null) {  
                    p.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  

    public static int backup(String dest, String dbname) {  
        try {  
            OutputStream out = new FileOutputStream(dest);  
            backup(out, dbname);  
        } catch (FileNotFoundException e) {  
           e.printStackTrace();  
        }
		return 0;  
   }
	
	 /*public static void main(String[] args) {  
	        Configuration config = HibernateSessionFactory.getConfiguration();  
	        String binPath = config.getProperty("C:/Program Files/mysql-5.6.24-win32/bin");  
	        String userName = config.getProperty("root");  
	        String pwd = config.getProperty("1234");  
	        Backup bak = new Backup(binPath, userName, pwd);  
	        bak.backup("D:/DATA/hotel.sql", "host_13");  
	    } */
	public static int backup(JTextField textField, String dbname) {
		// TODO Auto-generated method stub
		return 0;
	} 

	
}