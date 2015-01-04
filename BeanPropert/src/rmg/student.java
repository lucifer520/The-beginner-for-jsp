package rmg;
public class student {
 private long classNo;
 private String name;
 private int age;
 private boolean sexy;

  public student() {	//构造函数
    classNo=970431;
    name="ZZZl";
    age=34;
    sexy=true;
  }
  public long getClassNo() {
	    return classNo;
	  }
	  public void setClassNo(long no) {
	    this.classNo=no;
	  }
	  public String getName() {
	    return name;
	  }
	  public void setName(String name) {
	    this.name=name;
	  }
	   public int getAge() {
		    return age;
		  }

		  public void setAge(int age) {
		    this.age=age;
		  }
		  
		  public boolean getSexy() {
		    return sexy;
		  }
		  public void setSexy(boolean sexy) {
		    this.sexy=sexy;
		  }
		}

	 
