class Solution {
    public int reverse(int x) {
        String origin_x = String.valueOf(x);
        String reversed_str_x = "";
        for(int i = origin_x.length()-1; i >= 0; i--){
            reversed_str_x += origin_x.charAt(i);
        }
        if(reversed_str_x.contains("-")){
            reversed_str_x = "-" + reversed_str_x.replace("-", "");
        }
        try{
            Long reversed_int_x = Long.parseLong(reversed_str_x);

            if((int)Math.pow(-2,31) < reversed_int_x && reversed_int_x < (int)Math.pow(2,31)-1){
                return Integer.parseInt(reversed_str_x);
            }else{
                return 0;
            }
        }catch(Exception e){
            return 0;
        }
    }
}