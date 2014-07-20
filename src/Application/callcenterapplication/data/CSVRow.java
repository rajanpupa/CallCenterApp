package callcenterapplication.data;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class CSVRow {
    String [] row;
    
    public CSVRow(String [] row){
        this.row = row;
    }
    
    public String toString(){
        String ans = "invalid";
        if(row!=null){
            ans = row[0];
        }
        return ans;
    }
    
    public String getFullRow(){
        String str = "";
        int i = 0;
        for(; i<row.length-1; i++){
            str += row[i]+", ";
        }
        str+=row[i];
        return str;
    }

    public String getIndex(int index){
        String ans = "";
        if(row!=null){
            try{
                ans = row[index];
            }catch(Exception e){
                
            }
        }
        return ans;
        
    }
    
    public void setIndex(int index, String value){
        if(row != null){
            try{
                row[index] = value;
            }catch(Exception e){
                System.out.println("CSVRow: Exception occured in setIndex(int, String)");
            }
        }else{
            row = new String[5];
            row[index] = value;
        }
    }
}
