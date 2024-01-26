package wcd.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//khóa chính tự động tăng
    public int id;
    @Column(nullable = false)
    public  String name;
    @Column(nullable = false,unique = true)
    public  String email;
    @Column(nullable = true)
    public  String address;


}
