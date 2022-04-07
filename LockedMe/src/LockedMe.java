

	import java.io.File;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.Scanner;

	public class LockedMe {
		static String DIRECTORY;
	    File folder_name;
		public LockedMe() {
	        DIRECTORY = System.getProperty("user.dir");
	        folder_name = new File(DIRECTORY+"/files");
	        if (!folder_name.exists())
	            folder_name.mkdirs();
	        System.out.println("DIRECTORY : "+ folder_name.getAbsolutePath());
	    }
		// **********Creating Welcome Screen*************
		//  Welcome Screen Starts Here
		public static void welcomeScreen() {
			 int n =100 ;
		 	    for(int i=0;i<3;i++)
		 	    {
		 	        
		 	        for(int j=0;j<n;j++)
		 	        {
		 	            
		 	            System.out.print("*");
		 	        }
		 	        System.out.println();
		 	    }
		 	    System.out.println("                       Welcome To Lock Me ");
		 	    System.out.println(" ");
		 	    System.out.println(" ");
		 	    System.out.println("Company Name: Lockers Pvt. Ltd. ");
		 	    System.out.println("Developed By: Lal Chand  ");
		 	    System.out.println("Email: ashugahlot664@gmail.com ");
		 	    System.out.println(" ");
		 	    System.out.println(" ");
		 	    
		 	    int m = 100;
		 	    //Outer Loop for number of Rows
		 	    for(int i=0;i<3;i++)
		 	    {
		 	        // Inner loop for printing '*' in each column.
		 	        for(int j=0;j<m;j++)
		 	        {
		 	            
		 	            System.out.print("*");
		 	        }
		 	        System.out.println();
		 	        
		 	    }
		}
		// ***************Welcome Screen Ends here*****************
		
	  	// Creating Menu For Options
	    private static final String main_Menu =
	            "\n  Select any of the following Option : \n" +
	                    "1 -> List files in directory\n"+
	                    "2 -> Add Files\n"+
	                    "3 -> Search Files\n"+
	                    "4 -> Delete Files\n"+
	                    
	                    "5.-> Exit Program";
	    
	    void showMenu() {
	    	System.out.println(main_Menu);
	       
	        try{
	            Scanner scanner = new Scanner(System.in);
	            int option = scanner.nextInt();
	            switch (option){
	                case 1 : {
	                    showFiles();
	                    showMenu();
	                }
	                case 2 : {
	                	System.out.println("Please Enter a File Name You Want to add : ");
	                    String filename = scanner.next().trim().toLowerCase();
	                    addFile(filename);
	                    break;
	                }
	                case 3 : {
	                	System.out.println("Please Enter a File Name You want Search : ");
	                    String filename = scanner.next().trim();
	                    searchFile(filename);
	                    break;
	                }
	                case 4 : {
	                	System.out.println("Please Enter a File Name Which You Want to Delete : ");
	                    String filename = scanner.next().trim();
	                    deleteFile(filename);
	                    break;
	                }
	                
	                case 5 : {
	                    System.out.println("Thank You");
	                    System.exit(0);
	                }
	                default: System.out.println("Please Enter 1, 2, 3, 4, 5");
	            }
	        }
	        catch (Exception e){
	           System.out.println("Enter Valid option");
	        }}
	    
	    private void showFiles() {
			
			 if (folder_name.list().length==0)
		            System.out.println("The folder is empty");
		        else {
		            String[] list = folder_name.list();
		            System.out.println("The files in "+ folder_name +" are :");
		            Arrays.sort(list);
		            for (String str:list) {
		                System.out.println(str);
		            }
		        }
		}
	    
	    private void addFile(String filename) 
		throws IOException {
	        File filepath = new File(folder_name +"/"+filename);
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equalsIgnoreCase(file)) {
	                System.out.println("File " + filename + " already exists at " + folder_name);
	                return;
	            }
	        }
	        filepath.createNewFile();
	        System.out.println("File "+filename+" added to "+ folder_name);
	    }
	    
	    private void searchFile(String filename) {
			
			  String[] list = folder_name.list();
		        for (String file: list) {
		            if (filename.equals(file)) {
		                System.out.println("FOUND : File " + filename + " exists at " + folder_name);
		                return;
		            }
		        }
		        System.out.println("File NOT found ");
		}
		
	    private void deleteFile(String filename) {
		
			File filepath = new File(folder_name +"/"+filename);
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equals(file) && filepath.delete()) {
	                System.out.println("File " + filename + " deleted from " + folder_name);
	                return;
	            }
	        }
	        System.out.println("Delete Operation failed. FILE NOT FOUND");
		}
		
		
		
		public static void main(String[] args) {
			
	 	    welcomeScreen();
	 	    LockedMe obj = new LockedMe();
	 	    obj.showMenu();
		}

	}


