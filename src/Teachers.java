public class Teachers {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String field;
    public int salary;
    public Teachers( String firstName,String lastName,String email,String field, int salary,int id){
        this.email =email;
        this.lastName = lastName;
        this.id = id;
        this.field = field;
        this.firstName = firstName;
        this.salary = salary;
    }
}
