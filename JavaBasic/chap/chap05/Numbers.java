package chap05;

class Numbers {
    int num[];
    Numbers(int num[]) {   
        this.num = num;
    }
    int getTotal() {   // �հ踦 ���ϴ� �޼ҵ�
        int total = 0;
        for (int cnt = 0; cnt < num.length; cnt++) 
            total += num[cnt];
        return total;
    }
    int getAverage() {   // ����� ���ϴ� �޼ҵ�
        int total;
        total = getTotal(); 
        int average = total / num.length;   
        return average;
    }
}
