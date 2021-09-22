package Week3;

public class Friend {
public static void main(String[] args) {
    MyFriends connie = new MyFriends("Constantine Vrachas Matthaios", "Connie", "he/him", 2, "Bayview Glen School");
    MyFriends luchi = new MyFriends("Luchi Remu", "Luchi", "they/them", 2, "Bayview Glen School");
    MyFriends ellaG = new MyFriends("Ella Gladman", "Ella", "she/her", 16, "Gymboree");
    MyFriends everett = new MyFriends("Everett Tang", "Everett", "they/them", 5, "Crescent School");
    MyFriends stefano = new MyFriends("Stefano Esposto", "Stefano", "he/him", 2, "Bayview Glen School");
    MyFriends michael = new MyFriends("Michael Gee", "Michael", "he/him", 2, "Bayview Glen School");
    MyFriends ellaR = new MyFriends("Isabella Rhee", "Ella", "she/her", 7, "St. Clement's School");

    System.out.print("\n");

    int a = (int)(Math.random()*7)+1;
    if(a==1){
        connie.displayAttributes();
        connie.randomInfo();
    }else if(a==2){
        luchi.displayAttributes();
        luchi.randomInfo();
    }else if(a==3){
        ellaG.displayAttributes();
        ellaG.randomInfo();
    }else if(a==4){
        everett.displayAttributes();
        everett.randomInfo();
    }else if(a==5){
        stefano.displayAttributes();
        stefano.randomInfo();
    }else if(a==6){
        michael.displayAttributes();
        michael.randomInfo();
    }else if(a==7){
        ellaR.displayAttributes();
        ellaR.randomInfo();
    }

    System.out.print("\n");

    int b = (int)(Math.random()*7)+1;
    if(b==1){
        connie.displayAttributes();
        connie.randomInfo();
    }else if(b==2){
        luchi.displayAttributes();
        luchi.randomInfo();
    }else if(b==3){
        ellaG.displayAttributes();
        ellaG.randomInfo();
    }else if(b==4){
        everett.displayAttributes();
        everett.randomInfo();
    }else if(b==5){
        stefano.displayAttributes();
        stefano.randomInfo();
    }else if(b==6){
        michael.displayAttributes();
        michael.randomInfo();
    }else if(b==7){
        ellaR.displayAttributes();
        ellaR.randomInfo();
    }

    
}
}

