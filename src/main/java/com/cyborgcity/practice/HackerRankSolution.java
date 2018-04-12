package com.cyborgcity.practice;

import java.util.*;

/**
 * Created by Ravi on 17-04-2017.
 */
public class HackerRankSolution {
    static class Entity {
        private int res;
        private String line;
        private String[] exp;
        public Entity(int res, String line){
            this.res = res;
            this.line = line;
            this.exp = line.split(",");
        }

        public int getRes() {
            return res;
        }

        public void setRes(int res) {
            this.res = res;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public String[] getExp() {
            return exp;
        }
    }

    static List<Entity> resultList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int expr_size = 0;
        expr_size = Integer.parseInt(in.nextLine().trim());
        String[] expr = new String[expr_size];
        String expr_item;
        for (int i =0 ; i< expr_size ; i++){
            try{
                expr_item = in.nextLine();
            }catch (Exception e){
                expr_item = null;
            }
            expr[i] = expr_item;
        }
        fancySort(expr);
        Collections.sort(resultList, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                if(o1.getRes() - o2.getRes() == 0){
                    return o1.getExp()[0].compareTo(o2.getExp()[0]);
                }
                return o1.getRes() - o2.getRes();
            }
        });
        for (Entity s : resultList){
            System.out.println(s.getLine());
        }
    }

    static void fancySort(String[] expr){
        for (String exp : expr) {
            String[] tokens = exp.split(",");
            if (tokens.length < 2)
                continue;
            int result = 0;
            try{
                switch (tokens[0]) {
                    case "ADD":
                        for (int i = 1; i < tokens.length; i++) {
                            result += Integer.parseInt(tokens[i]);
                        }
                        resultList.add(new Entity(result, exp));
                        break;
                    case "MULTIPLY":
                        result = 1;
                        for (int i = 1; i < tokens.length ; i++) {
                            result *= Integer.parseInt(tokens[i]);
                        }
                        resultList.add(new Entity(result, exp));
                        break;
                    case "SUBTRACT":
                        for (int i = 1; i < tokens.length; i++) {
                            result -= Integer.parseInt(tokens[i]);
                        }
                        resultList.add(new Entity(result, exp));
                        break;
                    case "DIVIDE":
                        result = Integer.parseInt(tokens[1]) / Integer.parseInt(tokens[2]);
                        for (int i = 3; i < tokens.length; i++) {
                            result /= Integer.parseInt(tokens[i]);
                        }
                        resultList.add(new Entity(result, exp));
                        break;
                    case "MIN":
                        result = Integer.parseInt(tokens[1]);
                        for (int i = 2; i < tokens.length; i++) {
                            result = Math.min(result, Integer.parseInt(tokens[i]));
                        }
                        resultList.add(new Entity(result, exp));
                        break;
                    case "MAX":
                        result = Integer.parseInt(tokens[1]);
                        for (int i = 2; i < tokens.length; i++) {
                            result = Math.max(result, Integer.parseInt(tokens[i]));
                        }
                        resultList.add(new Entity(result, exp));
                        break;
                }
            }catch (Exception e){
//                e.printStackTrace();
                continue;
            }
        }
    }
}
