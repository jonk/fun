from httplib import HTTPConnection

while True:
    conn = HTTPConnection("http://dtbs.herokuapp.com", 80, timeout=0)
    conn.connect()

    conn.request("GET", "http://dtbs.herokuapp.com/#/")
    resp = conn.getresponse()

    data = resp.read()
    print(data)