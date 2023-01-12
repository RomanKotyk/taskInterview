package task1;

import java.util.Arrays;

public class RailFenceCipher {

    public static String encode(String input, int rails) {
        if(input.equals("")) return "";
        char[][] textMatrix = new char[rails][input.length()];
        for(int i = 0;i < rails; i++){
            for(int j = 0; j<input.length();j++){
                textMatrix[i][j] = '\n';
            }
        }
        int j = 0;
        boolean direction = false; //if true - go up, false - go down
        for(int i = 0;i<input.length();i++){
            if(j>=rails){
                j-=2;
                direction = true;
            }
            if(j<0){
                j+=2;
                direction = false;
            }
            textMatrix[j][i] = input.charAt(i);
            if(!direction){
                ++j;
            }else{
                --j;
            }
        }

        StringBuilder encodedString = new StringBuilder();
        for(int i = 0;i<rails;i++){
           for(j = 0;j<input.length();j++){
               if(textMatrix[i][j]!='\n') {
                   encodedString.append(textMatrix[i][j]);
               }
           }
        }

        return encodedString.toString();
    }

    public static String decode(String encoded, int rails) {
        char[][] textMatrix = new char[rails][encoded.length()];
        for(int i = 0;i < rails; i++){
            for(int j = 0; j<encoded.length();j++){
                textMatrix[i][j] = '\n';
            }
        }
        int j = 0;
        boolean direction = false; //if true - go up, false - go down
        for(int i = 0;i<encoded.length();i++){
            if(j>=rails){
                j-=2;
                direction = true;
            }
            if(j<0){
                j+=2;
                direction = false;
            }
            textMatrix[j][i] = '*';
            if(!direction){
                ++j;
            }else{
                --j;
            }
        }

        int index = 0;
        for (int i=0; i<rails; i++) {
            for (j = 0; j < encoded.length(); j++) {
                if (textMatrix[i][j] == '*' && index < encoded.length()) {
                    textMatrix[i][j] = encoded.charAt(index++);
                }
            }
        }

        StringBuilder decodedString = new StringBuilder();
        direction = false;
        j=0;
        for(int i = 0;i<encoded.length();i++){
            if(j>=rails){
                j-=2;
                direction = true;
            }
            if(j<0){
                j+=2;
                direction = false;
            }
            decodedString.append(textMatrix[j][i]);
            if(!direction){
                ++j;
            }else{
                --j;
            }
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("WEAREDISCOVEREDFLEEATONCE", 3));
        System.out.println(decode("WECRLTEERDSOEEFEAOCAIVDEN",3));
    }
}
