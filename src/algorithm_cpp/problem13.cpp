class Solution {
public:
    int romanToInt(string s) {
        int rt = 0, prev = getValue(s[0]), cur = 0;
        for (int i = 1; i < s.size(); i++) {
            cur = getValue(s[i]);
            if (prev < cur) {
                rt -= prev;
            } else {
                rt += prev;
            }
            prev = cur;
        } 
        rt += prev;
        
        return rt;
    }

    int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
};
