package mypack;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Student {

	String name;
	int age;
	int roll;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", roll=" + roll + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getRoll()=" + getRoll() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
