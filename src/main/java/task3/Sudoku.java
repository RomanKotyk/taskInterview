package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Sudoku {
    public static boolean validateSudoku(List<List<Integer>> sudoku){
        if(Math.sqrt(sudoku.size())%1!=0 || sudoku.size()<=1) return false;
        if(sudoku.size()%sudoku.get(0).size()!=0) return false;
        if(!checkColumns(sudoku)) return false;
        if(!checkRows(sudoku)) return false;
        if(!checkBoxes(sudoku)) return false;
        return true;
    }

    public static boolean checkRows(List<List<Integer>> sudoku){
        TreeSet<Integer> set = new TreeSet<>();
        for(List list : sudoku){
            set.addAll(list);
            if(list.size()!=set.size()) return false;
        }
        return true;
    }
    public static boolean checkColumns(List<List<Integer>> sudoku){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i<sudoku.size();i++) {
            for (List list : sudoku) {
                set.add((Integer) list.get(i));
            }
            if (set.size() != sudoku.size()) return false;
            set.clear();
        }
        return true;
    }
    public static boolean checkBoxes(List<List<Integer>> sudoku){
        TreeSet<Integer> set = new TreeSet<>();
        int size = sudoku.size();
        int sizeBox = (int) Math.sqrt(sudoku.size());
        int indexColumn = 0;
        int indexRow = 0;
        for(int i = 0;i<size;i++) {
            for(int j = 0; j < sizeBox;j++){
                for(int k = 0; k <sizeBox;k++){
                    set.add(sudoku.get(j+indexRow).get(k+indexColumn));
                }
            }
            if(set.size()!=size) return false;
            indexColumn += 3;
            if(i+1%Math.sqrt(size)==0){
                indexColumn = 0;
                indexRow += 3;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> sudoku = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(7,8,4,1,5,9,3,2,6));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(5,3,9,6,7,2,8,4,1));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(6,1,2,4,3,8,7,5,9));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(9,2,8,7,1,5,4,6,3));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(3,5,7,8,4,6,1,9,2));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(4,6,1,9,2,3,5,8,7));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(8,7,6,3,9,4,2,1,5));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(2,4,3,5,6,1,9,7,8));
        sudoku.add(row);
        row = new ArrayList<>(Arrays.asList(1,9,5,2,8,7,6,3,4));
        sudoku.add(row);
        System.out.println(checkColumns(sudoku));

    }
}
