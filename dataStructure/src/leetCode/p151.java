package leetCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class p151 {
	/*
	 * 	Input: "the sky is blue",
		Output: "blue is sky the".
	 */
	public static void main(String[] args) {
		
		System.out.println(reverseWords(" 1"));
	}
    public static String reverseWords(String str) {
        if(str.length() == 0) return "";
        if(str.trim().length() == 0) return "";
        if(str.length() == 1) return str;
		StringBuilder sb = new StringBuilder("");
		ArrayList<String> ar = new ArrayList<String>();
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==' '){
				ar.add(sb.toString());
				sb = new StringBuilder("");
			}else{
				sb.append(str.charAt(i));
				if(i == str.length()-1){
					ar.add(sb.toString());
				}
			}
		}
		sb = new StringBuilder("");
		for(int i=ar.size()-1; i>=0; i--){
			if(i != 0){
				sb.append(ar.get(i)+" ");
			}else{
				sb.append(ar.get(i));
			}
		}        
        return sb.toString();
    }
}
