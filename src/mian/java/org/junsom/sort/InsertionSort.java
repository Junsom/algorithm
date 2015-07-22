package org.junsom.sort;

import java.util.Random;

import org.junsom.enums.SortOrder;

/**
 * 插入排序
 * <ul>
 *  <li>升序插入排序</li>
 *  <li>降序插入排序</li>
 * </ul>
 * 
 * @Version: 1.0
 * @Author: hejunsong 何俊松
 * @Email: hjsactivity@gmail.com
 * @Date: 2015年7月9日
 */
public class InsertionSort {
  
  /** 待排序数据数组 */
  protected int[] datas;
  
  /** 随机最大值（不包括） */
  protected int maxNumber = 1000;
  
  /**
   * 初始化数据
   * 
   * @param size 数据大小 即数组长度
   * @return 
   */
  public void initData(int size) {
    Random r = new Random();
    datas = new int[size];
    for(int i = 0; i < size; i++) {
      datas[i] = r.nextInt(maxNumber);
    }
  }
  
  /**
   * 插入排序
   * 
   * @param order 
   *          排序方向
   * @param size
   *          初始化数据大小
   * @return
   */
  public int[] insertionSort(SortOrder order, int size) {
    initData(size);
    if (order == null) {
      order = SortOrder.ASC;
    }
    if(size < 2) {
      return datas;
    }
    if(order == SortOrder.DESC) {
      return insertionSortDesc();
    }
    return insertionSortAsc();
  }
  
  /**
   * 插入排序升序
   * 
   * @return
   */
  protected int[] insertionSortAsc() {
    int cuurSort;
    int j;
    for(int i = 1; i < datas.length; i++) {
      cuurSort = datas[i];
      j = i-1;
      while(j >= 0 && cuurSort < datas[j]) {
        // 当需要排序的值小于已排序好的datas[j]值，将数据往后移动1位
        datas[j+1] = datas[j];
        j--;
      }
      datas[j+1] = cuurSort;
    }
    return datas;
  }
  
  /**
   * 插入排序降序
   * 
   * @return
   */
  protected int[] insertionSortDesc() {
    int cuurSort;
    int j;
    for(int i = 1; i < datas.length; i++) {
      cuurSort = datas[i];
      j = i-1;
      while(j >= 0 && cuurSort > datas[j]) {
        // 当需要排序的值大于已排序好的datas[j]值，将数据往后移动1位
        datas[j+1] = datas[j];
        j--;
      }
      datas[j+1] = cuurSort;
    }
    return datas;
  }
  
  /**
   * main test
   * 
   * @param args
   */
  public static void main(String[] args) {
    InsertionSort s = new InsertionSort();
    s.insertionSort(SortOrder.ASC, 10);
    String str = "";
    for(int i=0; i < s.datas.length; i++) {
      if(i == 0) {
        str += "[";
      }
      str += s.datas[i];
      if(i != s.datas.length-1) {
        str += ", ";
      }else {
        str += "]";
      }
    }
    System.out.println(str);
    s.insertionSort(SortOrder.DESC, 10);
    str = "";
    for(int i=0; i < s.datas.length; i++) {
      if(i == 0) {
        str += "[";
      }
      str += s.datas[i];
      if(i != s.datas.length-1) {
        str += ", ";
      }else {
        str += "]";
      }
    }
    System.out.println(str);
  }
}
