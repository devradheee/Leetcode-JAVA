class Solution {
    public String intToRoman(int number) {
       int num[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    String sym[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    int i=12;
    String s="";
    while(number>0){
        if(number-num[i]>=0){
            s+=sym[i];
            number-=num[i];
        }else{
            i--;
        }
    }
        // while(number>0)
    // {
    //   int div = number/num[i];
    //   number = number%num[i];
    //   while(div>0)
    //   {
    //     s+=sym[i];
    //     div--;
    //   }
    //   i--;
    // }
    return s;  
    }
}