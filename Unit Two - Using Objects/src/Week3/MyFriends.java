package Week3;

public class MyFriends {
    private String name;
    private String nickname;
    private String pronouns;
    private int lengthOfFriendship;
    private String meetingPlace;

    public MyFriends(String name, String nickname, String pronouns, int length, String place) {
        this.name = name;
        this.nickname = nickname;
        this.pronouns = pronouns;
        this.lengthOfFriendship = length;
        this.meetingPlace = place;
      } 

    public void displayAttributes(){
        System.out.println("My friend's name is "+name+", but I call "+pronouns.substring(pronouns.indexOf("/")+1)+" "+nickname+". I met "+nickname+" at "+meetingPlace+", "+lengthOfFriendship+" years ago.");
    }

    public void randomInfo(){
        int x = (int)(Math.random()*4)+1;

        if(x==1){
            System.out.println(nickname+"'s name is "+name+".");
        }else if(x==2){
            System.out.println(nickname+"'s personal pronouns are "+pronouns+".");
        }else if(x==3){
            System.out.println("I have known "+nickname+" for "+lengthOfFriendship+" years.");
        }else if(x==4){
            System.out.println("I met "+nickname+" at "+meetingPlace+".");
        }
    }

    
}

