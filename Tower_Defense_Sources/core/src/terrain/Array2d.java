package terrain;
import java.util.ArrayList;



public class Array2d<T> {
    private ArrayList<ArrayList <T>> datas;
     
    public Array2d() {
      datas = new ArrayList<ArrayList <T>>();
      
    }
    public T get(int row, int col) {
      return datas.get(row).get(col);
    }
    
    public void addRow() {
      datas.add(new ArrayList<T>());
    }
    
    public void addRow(int row) {
      datas.add(row, new ArrayList<T>());
    }
    public void add(T o) {
      datas.get(datas.size() - 1).add(o);
    }
    public void add(int row, T o) {
      datas.get(row).add(o);
    }
    public void add(int row, int col, T o) {
      datas.get(row).add(col, o);
    }
    public void set(int row, int col, T o) {
      datas.get(row).set(col, o);
    }
    public int getRowsNb() {
      return datas.size();
    }
    public int getColsNb(int row) {
      return datas.get(row).size();
    }
  }