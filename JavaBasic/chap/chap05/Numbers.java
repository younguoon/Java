package chap05;

class Numbers {
    int num[];
    Numbers(int num[]) {   
        this.num = num;
    }
    int getTotal() {   // 합계를 구하는 메소드
        int total = 0;
        for (int cnt = 0; cnt < num.length; cnt++) 
            total += num[cnt];
        return total;
    }
    int getAverage() {   // 평균을 구하는 메소드
        int total;
        total = getTotal(); 
        int average = total / num.length;   
        return average;
    }
}
