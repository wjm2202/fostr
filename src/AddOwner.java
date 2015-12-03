
import java.util.Scanner;
public class AddOwner {

	private String username;
	private String email;
	private String first;
	private String last;
	private String dogName;
	private String breed;
	private String location;
	private String password;
	private String medical;
	private int age;
	private int phone;
	private String test;
	Scanner scan = new Scanner(System.in);
	
	public AddOwner()
	{
		
	}
	
	public String toString()
	{
		return "u: "+username+" e: "+email+" f: "+first+" l: "+last+" d: "+" b: "+breed+" l: "+location;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMedical() {
		return medical;
	}
	public void setMedical(String medical) {
		this.medical = medical;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}
