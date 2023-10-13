package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartowal");
        run(args);
        System.out.println("system zakonczyl dzialanie");

    }

    public static void run(String[] args){
        System.out.println("Start");
//        String to_print = "";

        for(int i=0 ; i< args.length ; i++){
//            System.out.println(args[i]);
            switch (args[i]){

                case "f": System.out.println("Zwierzak idzie do przodu"); break;
                case "b": System.out.println("Zwierzak idzie do tyłu"); break;
                case "r": System.out.println("Zwierzak skręca w prawo"); break;
                case "l": System.out.println("Zwierzak skręca w lewo,"); break;
                default:
            }

//            to_print += args[i];
//            if (i < args.length-1){ to_print += ", " ;}
        }
        System.out.println("Stop");
    }
}
//krok 16 TODO