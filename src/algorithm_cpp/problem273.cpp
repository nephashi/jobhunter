class Solution {
public:
    string one(int num) {
	switch(num) {
	    case 0:
		return "";
		break;
	    case 1:
	        return "One";
		break;
	    case 2:
	        return "Two";
		break;
	    case 3:
	        return "Three";
		break;
	    case 4:
	        return "Four";
		break;
	    case 5:
	        return "Five";
		break;
	    case 6:
	        return "Six";
		break;
	    case 7:
	        return "Seven";
		break;
	    case 8:
	        return "Eight";
		break;
	    case 9:
	        return "Nine";
		break;
	}
	return "";
    }

    string two(int num) {
	if (num < 10) return one(num);
	if (num < 20) return two_less_than_twenty(num);
	int rest = num % 10;
	if (rest == 0) return two_ten(num);
	else return two_ten(num) + " " + one(num % 10);
    }

    string two_ten(int num) {
	switch(num / 10) {
	    case 0:
		return "";
	    case 1:
		return "";
	    case 2:
		return "Twenty";
	    case 3:
		return "Thirty";
	    case 4:
		return "Forty";
	    case 5:
		return "Fifty";
	    case 6:
		return "Sixty";
	    case 7:
		return "Seventy";
	    case 8:
		return "Eighty";
	    case 9:
		return "Ninety";
	}
	return "";
    }

    string two_less_than_twenty(int num) {
	switch(num) {
	    case 10:
		return "Ten";
	    case 11:
		return "Eleven";
	    case 12:
		return "Twelve";
	    case 13:
		return "Thirteen";
	    case 14:
		return "Fourteen";
	    case 15:
		return "Fifteen";
	    case 16:
		return "Sixteen";
	    case 17:
		return "Seventeen";
	    case 18:
		return "Eighteen";
	    case 19:
		return "Nineteen";
    }
    return "";
    }

    string three(int num) {
	int h = num / 100;
	int rest = num % 100;
	string rt = "";
	if (h * rest != 0) {
	    rt = one(h) + " Hundred " + two(rest);
	}
	else if (h != 0 && rest == 0) {
	    rt = one(h) + " Hundred";
	} else if (h == 0 && rest != 0) {
	    rt += two(rest);
	}
	return rt;
    }


    string numberToWords(int num) {
        if (num == 0) return "Zero";
	int d = num / 1e9;
	num = num - (d * 1e9);
	int c = num / 1e6;
	num = num - (c * 1e6);
	int b = num / 1e3;
	num = num - (b * 1e3);
	int a = num;
	string rt;
	if (d != 0)  {
	    rt += three(d) + " Billion";
	}
	if (c != 0) {
	    if (rt.size() > 0) rt += " ";
	    rt += three(c) + " Million";
	}
	if (b != 0) {
	    if (rt.size() > 0) rt += " ";
	    rt += three(b) + " Thousand";
	}
	if (a != 0) {
	    if (rt.size() > 0) rt += " ";
	    rt += three(a);
	}
	return rt;
    }
};

