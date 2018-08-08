package DAO;

import entity.User;

import java.util.Set;

public  abstract class  AbstractUserDAO <T extends User>{

    public boolean create(T user){
    boolean result=true;
    return result;
        }

     public boolean update(T user){
         boolean result=false;
         T temp=findEmeil(user.getEmeil());
         result=(temp==null)?false:true;

         return result;
     }
     public  boolean delete(T user){
         boolean result=true;
         return result;

     }
     public abstract T  find(int key);
    public abstract T  findEmeil(String emeil);
    public abstract T  findLogin(String login);
    public abstract  Set<T> findAll();

}
