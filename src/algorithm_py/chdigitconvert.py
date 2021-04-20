#-*- coding: utf8 -*-

ch2digit = {
    u'零': 0,
    u'一': 1,
    u'二': 2,
    u'三': 3,
    u'四': 4,
    u'五': 5,
    u'六': 6,
    u'七': 7,
    u'八': 8,
    u'九': 9,
    u'十': 10,
    u'百': 100,
    u'千': 1000,
    u'万': 10000,
    u'亿': 100000000
}

chnum = {
	u'一', 
	u'二', 
	u'三', 
	u'四', 
	u'五', 
	u'六', 
	u'七', 
	u'八', 
	u'九', 
}

chunit = {
	u'十',
	u'百',
	u'千'
}

class Automation:
    def __init__(self):
	self.cur = 'start'
	self.status = ['num', 'unit', 'wan', 'yi', 'zero']
	self.table = {
	    'start': ['num', 'err', 'err', 'err', 'err'],
	    'num': ['err', 'unit', 'wan', 'yi', 'err'],
	    'unit': ['num', 'err', 'wan', 'yi', 'zero'],
	    'wan': ['num', 'err', 'err', 'yi', 'zero'],
	    'yi': ['num', 'err', 'err', 'yi', 'zero'],
	    'zero': ['num', 'err', 'err', 'err', 'err']
	}
	self.data1 = 0
	self.data2 = 0
	self.data3 = 0
	self.res = 0

    def getcol(self, ch):
	if (ch in chnum):
	    return 0
	if (ch in chunit):
	    return 1
	if ch == u'万':
	    return 2
	if ch == u'亿':
	    return 3
	if ch == u'零':
	    return 4
	return 5

    def go(self, ch):
	col = self.getcol(ch)
	if col == 5:
	    return False
	newstatus = self.table[self.cur][col]
	self.cur = newstatus
	if newstatus == 'err':
	    return False
	if newstatus == 'num':
	    self.data1 += ch2digit[ch]
	    return True
	if newstatus == 'unit':
	    self.data1 *= ch2digit[ch]
	    self.data2 += self.data1
	    self.data1 = 0
	    return True
	if newstatus == 'wan':
	    self.data3 = (self.data1 + self.data2) * ch2digit[ch]
	    self.data1 = 0
	    self.data2 = 0
	    return True
	if newstatus == 'yi':
	    self.res = self.res + self.data1 + self.data2 + self.data3
	    self.res *= ch2digit[ch]
	    self.data1 = 0
	    self.data2 = 0
	    self.data3 = 0
	    return True
	if newstatus == 'zero':
	    return True

def chdigitconvert(str):
    flag = 1
    if (str[0] == u'负'):
	flag = -1
	str = str[1:]
    if (str[0] == u'正'):
	str = str[1:]
    if (str == u'十'):
	return flag * 10
    if (str == u'零'):
	return 0
    automation = Automation()
    for ch in str:
	stat = automation.go(ch)
	if stat == False:
	    return None
    return flag * (automation.data1 + automation.data2 + automation.data3 + automation.res)

print chdigitconvert(u'零')
print chdigitconvert(u'负十')
print chdigitconvert(u'负二亿千')
print chdigitconvert(u'五十万')
print chdigitconvert(u'负二十六亿零三百六十五万亿')
