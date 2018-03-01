package myviews.com.views;

/**
 * Created by COLLINSB on 2/26/2018.
 */

public class Update {
    private String name=null;
    private int id=0;

    public Update(){

    }
    public int Get_Id(){
        return this.id;
    }
    public String GetInfo(){
        return  "Name " + this.name + ". Id " + this.id;
    }
    public void Set_Int(int id){
        this.id=id ;
    }
    public void Set_String(String name){
        this.name=name;
    }
}
