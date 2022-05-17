
class NotTenException extends RuntimeException {

}

public class class_15 {
    public static boolean checkTen(int ten){
        try{
            if(ten != 10){
                throw new NotTenException();
            }
        }catch(NotTenException e){
            System.out.println("e = " + e);
            return false;
        }


        return true;
    }

    public static boolean checkTenWithException(int ten){
        try{
            if(ten != 10){
                throw new NotTenException();
            }
        }catch(NotTenException e){
            System.out.println("e = " + e);
            return false;
        }
        return true;
    }

    public static boolean checkTenWithThrows(int ten) throws NotTenException{
        if(ten != 10){
            throw new NotTenException();
        }
        return true;
    }

    public static void main(String[] args) {
        boolean checkresult = class_15.checkTenWithException(5);
        System.out.println("checkresult = " + checkresult);
        try {
            checkresult = checkTenWithException(5);
        }catch (NotTenException e){
            System.out.println("e = " + e);
        }
        System.out.println(checkresult);
    }
}
