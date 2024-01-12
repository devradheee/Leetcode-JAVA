class Solution {

    public int addDigits(int num) {
        int res = calc(num);
        while (res > 9)
            res = calc(res);

        return res;
    }

    int calc(int num) {
        if (num == 0)
            return 0;
        return num % 10 + calc(num / 10);
    }
}