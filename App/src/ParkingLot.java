import java.util.*;

public class ParkingLot {

    String[] spots=new String[10];

    int hash(String plate){
        return Math.abs(plate.hashCode())%spots.length;
    }

    public void parkVehicle(String plate){

        int index=hash(plate);

        while(spots[index]!=null){
            index=(index+1)%spots.length;
        }

        spots[index]=plate;
        System.out.println("Vehicle "+plate+" parked at "+index);
    }

    public void exitVehicle(String plate){

        for(int i=0;i<spots.length;i++){
            if(plate.equals(spots[i])){
                spots[i]=null;
                System.out.println("Vehicle exited from "+i);
            }
        }
    }

    public static void main(String[] args){

        ParkingLot p=new ParkingLot();

        p.parkVehicle("ABC1234");
        p.parkVehicle("XYZ9999");

        p.exitVehicle("ABC1234");
    }
}