
def sumLenWords(words):
    return sum([len(word) for word in words])

tens = sumLenWords(['twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'])
ones = sumLenWords(['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'])
weirds = sumLenWords(['eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen' 'eighteen' 'nineteen'])
hundred = len('hundred')
aand = len('and')
thousand = len('thousand')
one = len('one')
ten = len('ten')

print ((ones * 9 + weirds + (tens * 10) + ten) * 10) + (aand * (99 * 9)) + (ones  * 100) + (hundred * 900) + one + thousand