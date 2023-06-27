from bs4 import BeautifulSoup as bs
from collections import defaultdict as dd
import requests
import json
import sys
url = sys.argv[1]
html = requests.get(url).text.split('class="references"')[0]
soup = bs(html, 'html.parser')
result = soup.find_all('a')
wordMap = dd(int)
for a in result:
    words = str(a)
    if not '<a href="/wiki/' in words: continue
    word = words.split('" ')[0].split("wiki/")[1]
    wordMap[word] += 1
print(json.dumps(wordMap))
