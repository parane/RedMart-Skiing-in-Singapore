package parane;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parani on 15/02/2018.
 */
public class RedMartChallenge {

    static int height;
    static int width;

    public static void main(String[] a){


        Map[][] maps= readInput();
        int maxLength =1;
        int maxDrop =0;
        for(int i=0;i<height;i++){
            for (int j=0; j< width;j++){

                DFSVisit(maps, maps[i][j]);



                if(maxLength<=maps[i][j].getMaxLength() ){
                    maxLength =maps[i][j].getMaxLength();
                    maxDrop =maps[i][j].getDrop();

                }
            }


        }


        System.out.println("maxLength "+maxLength);
        System.out.println("maxDrop "+maxDrop);
    }


    public static void DFSVisit(Map[][] maps, Map s){

        List<Map> adajenceMap = getAdjMap(maps, s);


        for(Map map:adajenceMap){


            if(!map.getCalculated()){
                map.setParentMap(s);
                DFSVisit(maps, map);

            }

            setMax(s, map.getLength() + 1, map.getDrop() + (s.getValue() - map.getValue()));


        }

        Map parent = s.getParentMap();

        if (parent != null) {
            setMax(parent, s.getLength() + 1, s.getDrop() + (parent.getValue() - s.getValue()));

        }
        s.setCalculated(Boolean.TRUE);

    }


    public static void setMax(Map s, Integer newLength,Integer drop){

        if(newLength >= s.getMaxLength()){
            s.setLength(newLength);

            s.setMaxLength(newLength);
            if(drop> s.getDrop()){
                s.setDrop(drop);
            }

        }
    }


    public static List<Map> getAdjMap( Map[][] maps,Map s){
        int i=s.getI();
        int j = s.getJ();
        List<Map> mapsList=new ArrayList<>();
        if((i-1)>=0 && maps[i-1][j].getValue() < s.getValue()){
            mapsList.add(maps[i-1][j]);
        }
        if((j-1)>=0 && maps[i][j-1].getValue() < s.getValue()){
            mapsList.add(maps[i][j-1]);
        }
        if((i+1)<height && maps[i+1][j].getValue() < s.getValue()){
            mapsList.add(maps[i+1][j]);
        }
        if((j+1)<width && maps[i][j+1].getValue() < s.getValue()){
            mapsList.add(maps[i][j+1]);
        }

        return mapsList;
    }



    public static Map[][] readInput(){


        try {
            FileInputStream fstream = new FileInputStream("map.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            String firstLine = reader.readLine();
            String[] size = firstLine.split(" ");
            int m = Integer.parseInt(size[0]);
            int n = Integer.parseInt(size[1]);
            height=m;
            width=n;
            Map[][] spaces = new  Map[m][n];
            String line = null;

            int row = 0;
            while ((line = reader.readLine()) != null)
            {

                String[] array = line.split(" ");
                if(array.length == n) {
                    for (int i = 0; i < array.length; i++) {
                        int value =Integer.parseInt(array[i]);
                        Map map=new Map(value,1,0,false,row,i,1);

                        spaces[row][i] = map;
                    }
                }else{
                    break;
                }
                row++;

            }
            return spaces;
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
