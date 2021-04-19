import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class main {
 static String char_list = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
 public static void main(String args[]) {
	play_fair("youssefdanielelwi","MONARCHY");
	play_fair_decrypt("HNXLLIKHNAEIULQUKX","MONARCHY");
	 
 }
 public static void Ceasar_Cipher_encrypt(String data, int Key) {
	 System.out.println("Word to be Encrypted "+ data);
	 data=data.toUpperCase();
	 String newData = "";
	 char [] list1 = char_list;
	 for(int i=0;i<data.length();i++) {
		 int index = Key + (new String(list1).indexOf(data.charAt(i)));
	     if(index>=26)
	    	 index = index%26;
	     else {}
		 newData = newData + list1[index];
	 }

     System.out.println("Key of Encryption : " + Key + "\nCeaser_Cipher_Encrypted ");
     System.out.println(newData);
 }
  public static void play_fair(String data, String Key) {

	 //if the data is not even we add z letter to the end of the word 
	 //checking if there is a repeated char
	 if(data.length()%2!=0) {
		 data = data + "j";
		 for(int i = 0; i<data.length();i=i+2) {
			 if(i<data.length()-1&&data.charAt(i)==data.charAt(i+1)) {
				 data = data.substring(0,i+1) + "X" + data.substring(i+1);
			 }
		 }	 
		 data = data.substring(0, data.length() - 1); 
	 }else {
		 for(int i = 0; i<data.length();i=i+2) {
			 if(i<data.length()-1&&data.charAt(i)==data.charAt(i+1)) {
				 data = data.substring(0,i+1) + "X" + data.substring(i+1);
			 }
		 }	 
	 }
		 
	 if(data.length()%2!=0) {

		 data = data + "Z";
	 }
	 
	 String newdata ="";
	 Key = Key.toUpperCase();
	 data = data.toUpperCase();
	 System.out.println(data);
	 String list = char_list;
	 //removing the letter j from the list
	 list = list.replace("J", "");
	 //searching the list and removing the key
	 for(int i = 0; i < Key.length();i++){
		  Key.charAt(i);
		 list = list.replaceFirst(Character.toString( Key.charAt(i)), "");
	 }
	 list = Key + list;
	 for(int i = 0; i<data.length();i = i+2) {
		 //encrypting the data
		char char1 = data.charAt(i);
		char char2 = data.charAt(i+1);
		int indexchar1 = list.indexOf(char1);
		int indexchar2 = list.indexOf(char2);
		//case 1 
		//getting the row or checking if they are in the same row
		//if they are in the same column we will get the same mod of 5
		//case if they are in the same column
		if((indexchar1%5)==(indexchar2%5)) {
			//if true we will check if they are stick to each other
			int checkstick =Math.abs(indexchar1 - indexchar2);
			if(checkstick == 5) {
	            //checking if they are stick to each other and at the bottom of the matrix
				 if(indexchar1 >19 && indexchar1<25 || indexchar2 > 19 && indexchar2 <25){
					//if indexchar1 is more value than indexchar2 then indexchar1 is at the most bottom
					 if(indexchar1>indexchar2) {
						 newdata = newdata + list.charAt(indexchar1);
						 newdata = newdata + list.charAt((indexchar1%5));
						
					}else if(indexchar2 > indexchar1) {
						//
						newdata = newdata + list.charAt(indexchar2);
						 newdata = newdata + list.charAt((indexchar2%5));
				}
					//System.out.println(list.charAt(indexchar2));
					
					
			}else {
				System.out.println(" i am here in the same and stick column"+char1+ " "+char2);
				newdata = newdata +list.charAt(indexchar1+5);
				newdata = newdata +list.charAt(indexchar2+5);
			}
			
			}else {
				//System.out.println(list.charAt(indexchar2));
				System.out.println(" i am here in the same column"+char1+ " "+char2);
				newdata = newdata +list.charAt(indexchar1+5);
				newdata = newdata +list.charAt(indexchar2+5);
			}
			//if they are stick to each other and ar not at the top or the bottom of the matrix
			//taking the bellow char in the same row 
		}
		//case if the are in the same row
		//if they are in the same row the difference between each 
		//element will be less than five 
		//they will be in the same row
		 if(((indexchar1)-(indexchar1%5)/15)==((indexchar2)-(indexchar2%5)/15)) {
			//checking if they stick to each other in the same row
			//if the difference between the elements is equal to 1 then they are stick to each other
			//in the same row
			if(Math.abs(indexchar1 - indexchar2)==1) {
				//if so true we will check if they are at the right most or the leftmost
				//checking if they are at the right most 
				//if they are at the right most one of them at least will mod 5 will be 4
				if (indexchar1%5==4 || indexchar2%5==4) {
					//if so we will get the left most char in the same row
					//mod 5 the element to get his row minusing this from his index will give us the first element in his row
					if(indexchar1%5==4) {
						newdata = newdata + list.charAt(indexchar2 + 1);
						newdata = newdata + list.charAt(indexchar1 - (indexchar1%5));
				
					}else if(indexchar2%5==4) {
						newdata = newdata + list.charAt(indexchar1 + 1);
						newdata = newdata + list.charAt(indexchar2 - (indexchar2%5));
					}
					
				}
				//checking if they are in the same row at the leftmost 
				if(indexchar1%5==0 || indexchar2%5==0) {
				//if so we will get the rightmost element 
					// by adding the index mod 5 we will get the number row and then 
			   //if char1 is at the leftmost
				if(indexchar1%5==0) {
					newdata = newdata + list.charAt(indexchar1 + 4);
					newdata = newdata + list.charAt(indexchar2 + 1);
				// if char2 is at the leftmost
				}else if(indexchar2%5==0) {
					newdata = newdata + list.charAt(indexchar2 + 4);
					newdata = newdata + list.charAt(indexchar1 + 1);
				}
					
				}else {
					newdata = newdata + list.charAt(indexchar1 +1);
					newdata = newdata + list.charAt(indexchar2 +1);
				}
			}else {
				System.out.println(list);
				System.out.println(char1 + " "+char2 + " here inside the ");
				newdata = newdata + list.charAt(indexchar1 +1);
				newdata = newdata + list.charAt(indexchar2 +1);
			}
				
			
			//if they are not stick to each other we back the element right of each
			//checking if they are not at the edges of their rows 
			
				
		}
		//case if they are in different rows and columns
		// mod the first index with the other if the result is more than 0 then they are in a different row
		else if((indexchar1%5)!=(indexchar2%5)&&((indexchar1)-(indexchar1%5)/15)!=((indexchar2)-(indexchar2%5)/15)) {
			//if so 
			//System.out.println(char1);
			//System.out.println(char2);
			if((indexchar1%5)>(indexchar2%5)){
				int dif = (indexchar1%5)-(indexchar2%5);
			    newdata =  newdata + list.charAt(indexchar1 - dif);
				newdata = newdata + list.charAt(indexchar2 + dif);
			   
				
			}else if((indexchar1%5)<(indexchar2%5)) {
				System.out.println(char1+" "+char2);
				int dif = (indexchar2%5)-(indexchar1%5);
				newdata = newdata + list.charAt(indexchar1 + dif);
			    newdata =  newdata + list.charAt(indexchar2 - dif);
				
			 
			}
		}
		System.out.println(char1+" "+char2);
		System.out.println(newdata);
		
		
	 }
	 System.out.println("Encrypted By PlayFair chiper :");
		System.out.println(newdata);	
	 
 }
 public static void play_fair_decrypt(String data, String Key) {
	 System.out.println("Word to be Encrypted "+ data);
	 String newdata ="";
	 Key = Key.toUpperCase();
	 data = data.toUpperCase();
	 String list = char_list;
	 //removing the letter j from the list
	 list = list.replace("J", "");
	 //searching the list and removing the key
	 for(int i = 0; i < Key.length();i++){
		  Key.charAt(i);
		 list = list.replaceFirst(Character.toString( Key.charAt(i)), "");
	 }
	 list = Key + list;
	 
 System.out.println( " this is the key "+ list);
 for(int i = 0; i<data.length();i = i+2) {
	 //encrypting the data
	char char1 = data.charAt(i);
	char char2 = data.charAt(i+1);
	int indexchar1 = list.indexOf(char1);
	int indexchar2 = list.indexOf(char2);
	// Decrypting Play Fair Cipher 
	// CASE 1 
	//checking if they are at the same column
	if(indexchar1%5==indexchar2%5) {
		System.out.println(char1 + " " + char2 + " same column");
		//checking if one of them at at the top 
		if(indexchar1%5 == 0 || indexchar2%5==0) {
			if(((indexchar1)-(indexchar1%5)/15)==0) {
				// we will get the character column number and it to 20 to get the bottom character 
				newdata = newdata + list.charAt(20 - indexchar1%5);
                newdata = newdata + list.charAt(indexchar1);		
			}else if (((indexchar2)-(indexchar2%5)/15)==0) {
					// we will get the character column number and it to 20 to get the bottom character 
					newdata = newdata + list.charAt(20 - indexchar2%5);
	                newdata = newdata + list.charAt(indexchar2);		
				}else {
					newdata = newdata + list.charAt(indexchar1 - 5);
		            newdata = newdata + list.charAt(indexchar2 - 5);		
				}
				
			// if they are in the same column and they are not at the top we just 
			// minus 5 from each index 
		}
	     
		
	}
	//CASE 2
	// if they are in the same row
	System.out.println(" Entered the same row"+ ((indexchar1)-(indexchar1%5)/15));
	System.out.println(" Entered the same row"+ ((indexchar2)-(indexchar2%5)/15));
	if (((indexchar1)-(indexchar1%5)/15)==((indexchar2)-(indexchar2%5)/15)) {
		//checking if the stick to the left 
		System.out.println(" Entered the same row");
		if(indexchar1%5 == 0 || indexchar2 == 0) {
			if(indexchar1%5== 0) {
				newdata = newdata + list.charAt(indexchar1 + 4);
				newdata = newdata + list.charAt(indexchar2 - 1);
			}if(indexchar2%5== 0) {
				newdata = newdata + list.charAt(indexchar2 + 4);
				newdata = newdata + list.charAt(indexchar1 - 1);
			}
			
			
			
		}else {
			// if they are at the same row but they are not at to the most left 
			newdata = newdata + list.charAt(indexchar1 - 1);
			newdata = newdata + list.charAt(indexchar2 - 1);
		}
		
	}
	// CASE 3
	// checking if they are not at the same column or the same row
	else if((indexchar1%5)!=(indexchar2%5)&&((indexchar1)-(indexchar1%5)/15)!=((indexchar2)-(indexchar2%5)/15)) {
		//if so 
		//System.out.println(char1);
		//System.out.println(char2);
		System.out.println(char1 + " " + char2 + " different column and row");
		if((indexchar1%5)>(indexchar2%5)){
			int dif = (indexchar1%5)-(indexchar2%5);
		    newdata =  newdata + list.charAt(indexchar1 - dif);
			newdata = newdata + list.charAt(indexchar2 + dif);
		   
			
		}else if((indexchar1%5)<(indexchar2%5)) {
			System.out.println(char1+" "+char2);
			int dif = (indexchar2%5)-(indexchar1%5);
			newdata = newdata + list.charAt(indexchar1 + dif);
		    newdata =  newdata + list.charAt(indexchar2 - dif);
			
		 
		}
	}
	System.out.println(char1+" "+char2);
	System.out.println(newdata);
	
	
 }
 System.out.println("Encrypted By PlayFair chiper :");
	System.out.println(newdata);	
	
}
 }

