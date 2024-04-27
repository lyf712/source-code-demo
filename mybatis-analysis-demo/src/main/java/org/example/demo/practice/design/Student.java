package org.example.demo.practice.design;

/**
 * @author liyunfei
 **/
public class Student {
    
    private String id;
    
    private String username;
    
    private String email;
    
    public Student(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    
    public static class Builder {
        
        private String id;
        
        private String username;
        
        private String email;
        
        
        public Student build() {
            return new Student(id, username, email);
        }
    }
}
