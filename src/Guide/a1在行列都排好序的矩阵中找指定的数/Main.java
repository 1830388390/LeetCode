package Guide.a1在行列都排好序的矩阵中找指定的数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int wide = sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[height][wide];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int y = height - 1;
        int x = 0;
        boolean flag = false;
        while (y >= 0 && x < wide && y < height) {
            int tmp = matrix[y][x];
            if (tmp == k) {
                flag = true;
                break;
            } else if (tmp > k) {
                y--;
            } else {
                x++;
            }
        }
        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

