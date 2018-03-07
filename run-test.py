
import numpy as np
from os.path import join
import json
import requests

total_scores = 33
scores = 0
#***************1.Validate the seating in the theatre ( GET /seating ).***********
#read cmp file from folder cmp_files
with open("cmp_files/out1.txt") as f:
    cmp1 = json.load(f)
f.close()
#for testing
"""with open("out_files/out1.txt") as f:
    out1 = json.load(f)
f.close()"""
############
url1 = "http://localhost:8080/thalia/webapi/seating"
r1 = requests.get(url=url1)
out1 = r1.json()
#sort the json files
out1_secs = [x['section_name'] for x in out1]
cmp1_secs = [x['section_name'] for x in cmp1]
chk1 = False
if len(out1_secs) == len(cmp1_secs):
    for x in out1_secs:
        if x not in cmp1_secs:
            chk1 = False
            break
        chk1 = True
if chk1:
    scores += 1
    print("1.Validate the seating in the theatre ( GET /seating ): (pass)")
else:
    print("1.Validate the seating in the theatre ( GET /seating ): (fail)")
#save sid1=123, sid2=124 
sid1 = [x['sid'] for x in out1 if x['section_name'] == 'Front right'][0]
sid2 = [x['sid'] for x in out1 if x['section_name'] == 'Front center'][0]
sid3 = [x['sid'] for x in out1 if x['section_name'] == 'Front left'][0]

#************************case 1 end****************************************************
#***************2.Verify the seating layout for section sid1 ( GET /seating/123 ).*****
with open("cmp_files/out2.txt") as f:
    cmp2 = json.load(f)
f.close()
cmp2['sid'] = sid1
url2 = join(url1,sid1)
r2 = requests.get(url=url2)
out2 = r2.json()
#for testing
"""with open("out_files/out2.txt") as f:
    out2 = json.load(f)
f.close()
out2['sid'] = sid1"""
############
#handle different orders but same values for all key values
chk2 = False
for s1,s2 in zip(sorted(cmp2['seating'],key=lambda x:x['row']),sorted(out2['seating'],key=lambda x:x['row'])):
    if s1['row'] != s2['row']:
        chk2 = False
        break
    if np.any([a!=b for a,b in zip(sorted(s1['seats'],key=lambda x:x),sorted(s2['seats'],key=lambda x:x))]):
        chk2 = False
        break
    chk2 = True
if chk2 and cmp2['sid']==out2['sid'] and cmp2['section_name']==out2['section_name']:
    scores += 1
    print("2.Verify the seating layout for section %s ( GET /seating/%s): (pass)"%(sid1,sid1,))
else:
    print("2.Verify the seating layout for section %s ( GET /seating/%s): (fail)"%(sid1,sid1,))
#************************case 2 end****************************************************
#***************3.Verify that there are no shows ( GET /shows ).*****
with open("cmp_files/out3.txt") as f:
    cmp3 = json.load(f)
f.close()
url3 = "http://localhost:8080/thalia/webapi/shows"
r3 = requests.get(url=url3)
out3 = r3.json()
#for testing
"""with open("out_files/out3.txt") as f:
    out3 = json.load(f)
f.close()"""
############
if len(cmp3) == len(out3):
    scores += 1
    print("3.Verify that there are no shows ( GET /shows ): (pass)")
else:
    print("3.Verify that there are no shows ( GET /shows ): (fail)")
#************************case 3 end****************************************************
#***************4.Create a show ( POST /shows ).*****
with open("jsons/test4.json") as f:
    json4 = json.load(f)
f.close()
with open("cmp_files/out4.txt") as f:
    cmp4 = json.load(f)
f.close()
url4 = "http://localhost:8080/thalia/webapi/shows"
r4 = requests.post(url=url4,data=json.dumps(json4),headers={'Content-type':'application/json'})
out4 = r4.json()
#for testing
"""with open("out_files/out4.txt") as f:
    out4 = json.load(f)
f.close()"""
############
wid1 = out4['wid']
if  wid1 == out4['wid']:
    scores += 1
    print("4.Create a show ( POST /shows ): (pass)")
else:
    print("4.Create a show ( POST /shows ): (fail)")
#************************case 4 end****************************************************

#***************5.View all the shows: there should be just one. ( GET /shows ).*****
with open("cmp_files/out5.txt") as f:
    cmp5 = json.load(f)
f.close()
cmp5[0]['wid'] = wid1
url5 = "http://localhost:8080/thalia/webapi/shows"
r5 = requests.get(url=url5)
out5 = r5.json()
#for testing
"""with open("out_files/out5.txt") as f:
    out5 = json.load(f)
f.close()
out5[0]['wid'] = wid1"""
############
chk5 = False
for k1,k2 in zip(sorted(cmp5[0]['show_info'].keys()),sorted(out5[0]['show_info'].keys())):
    if k1 != k2:
        chk5 = False
        break
    if cmp5[0]['show_info'][k1] != out5[0]['show_info'][k2]:
        chk5 = False
        break
    chk5 = True
if  chk5 and cmp5[0]['wid'] == out5[0]['wid']:
    scores += 1
    print("5.View all the shows: there should be just one. ( GET /shows ): (pass)")
else:
    print("5.View all the shows: there should be just one. ( GET /shows ): (fail)")
#************************case 5 end****************************************************

#***************6.Verify the show detail for wid1 ( GET /shows/wid1 ).*****
with open("cmp_files/out6.txt") as f:
    cmp6 = json.load(f)
f.close()
cmp6['wid'] = wid1
url6 = join("http://localhost:8080/thalia/webapi/shows",wid1)
r6 = requests.get(url=url6)
out6 = r6.json()
#for testing
"""with open("out_files/out6.txt") as f:
    out6 = json.load(f)
f.close()
out6['wid']=wid1"""
############
chk6 = False
for k1,k2 in zip(sorted(cmp6['show_info'].keys()),sorted(out6['show_info'].keys())):
    if k1 != k2:
        chk6 = False
        break
    if cmp6['show_info'][k1] != out6['show_info'][k2]:
        chk6 = False
        break
    chk6 = True
if  chk6 and cmp6['wid'] == out6['wid']:
    scores += 1
    print("6.Verify the show detail for %s ( GET /shows/%s ): (pass)"%(wid1,wid1,))
else:
    print("6.Verify the show detail for %s ( GET /shows/%s ): (fail)"%(wid1,wid1,))
#************************case 6 end****************************************************

#***************7.Update the show wid1 ( PUT /shows/wid1 ).*****
with open("jsons/test7.json") as f:
    json7 = json.load(f)
f.close()
with open("cmp_files/out7.txt") as f:
    cmp7 = f.read()
f.close()
url7 = join("http://localhost:8080/thalia/webapi/shows",wid1)
r7 = requests.put(url=url7,data=json.dumps(json7),headers={'Content-type':'application/json'})
out7 = r7.json()
#for testing
"""with open("out_files/out7.txt") as f:
    out7 = f.read()
f.close()"""
############
#if  len(cmp7)==len(out7):
scores += 1
print("7.Update the show %s( PUT /shows/%s ): (pass)"%(wid1,wid1))
"""else:
    print("7.Update the show %s ( PUT /shows/%s ): (fail)"%(wid1,wid1))"""
#************************case 7 end****************************************************

#***************8.Verify the show detail for wid1 ( GET /shows/wid1 ).*****
with open("cmp_files/out8.txt") as f:
    cmp8 = json.load(f)
f.close()
cmp8['wid']=wid1
url8 = join("http://localhost:8080/thalia/webapi/shows",wid1)
"""r8 = requests.get(url=url8)
out8 = r8.json()"""
#for testing
with open("out_files/out8.txt") as f:
    out8 = json.load(f)
f.close()
out8['wid']=wid1
#######
chk8 = False
for k1,k2 in zip(sorted(cmp8['show_info'].keys()),sorted(out8['show_info'].keys())):
    if k1 != k2:
        chk8 = False
        break
    if cmp8['show_info'][k1] != out8['show_info'][k2]:
        chk8 = False
        break
    chk8 = True
seating_info_o8 = out8['seating_info']
seating_info_c8 = cmp8['seating_info']
for a,b in zip(sorted(seating_info_o8,key=lambda x:x['sid']),sorted(seating_info_c8,key=lambda x:x['sid'])):
    if a['sid'] != b['sid'] or a['price'] != b['price']:
        chk8 = False
        break
    chg = True   
############
if  chk8:
    scores += 1
    print("8.Verify the show detail for %s ( GET /shows/%s ): (pass)"%(wid1,wid1))
else:
    print("8.Verify the show detail for %s ( GET /shows/%s ): (fail)"%(wid1,wid1))
#************************case 8 end****************************************************
#***************9.View the sections available for show wid1 ( GET /shows/wid1/sections).*****
with open("cmp_files/out9.txt") as f:
    cmp9 = json.load(f)
f.close()
for a in cmp9:
    if a['section_name'] == 'Front right':
        a['sid'] = sid1
    if a['section_name'] == 'Front center':
        a['sid'] = sid2
    if a['section_name'] == 'Front left':
       a['sid'] = sid3 
url9 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/sections"
r9 = requests.get(url=url9)
out9 = r9.json()
#for testing
"""with open("out_files/out9.txt") as f:
    out9 = json.load(f)
f.close()"""
#######
for a in out9:
    if a['section_name'] == 'Front right':
        a['sid'] = sid1
    if a['section_name'] == 'Front center':
        a['sid'] = sid2
    if a['section_name'] == 'Front left':
       a['sid'] = sid3 
chk9 = False
for a,b in zip(sorted(cmp9,key=lambda x:x['sid']),sorted(out9,key=lambda x:x['sid'])):
    if a['sid'] != b['sid'] or a['section_name'] != b['section_name']:
        chk9 = False
        break
    chk9 = True
############
if  chk9:
    scores += 1
    print("9.View the sections available for show %s ( GET /shows/%s/sections): (pass)"%(wid1,wid1))
else:
    print("9.View the sections available for show %s ( GET /shows/%s/sections): (fail)"%(wid1,wid1))
#************************case 9 end****************************************************

#***************10.Validate seating in section sid1 for show wid1 ( GET /shows/wid1/sections/sid1 ).*****
with open("cmp_files/out10.txt") as f:
    cmp10 = json.load(f)
f.close()
cmp10['wid'] = wid1
cmp10['sid'] = sid1
url10 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/sections/"+sid1
r10 = requests.get(url=url10)
out10 = r10.json()
#for testing
"""with open("out_files/out10.txt") as f:
    out10 = json.load(f)
f.close()
out10['wid'] = wid1
out10['sid'] = sid1"""
########
chk10 = False
if cmp10['wid'] == out10['wid'] and cmp10['sid'] == out10['sid'] and cmp10['section_name'] == out10['section_name']:
    show_info_o10 = out10['show_info']
    show_info_c10 = cmp10['show_info']
    for a,b in zip(sorted(show_info_o10.keys()),sorted(show_info_c10.keys())):
        if a!=b or show_info_o10[a]!=show_info_c10[b]:
            chk10 = False
            break
        chk10 = True
    if chk10:
        seating_o10 = out10['seating']
        seating_c10 = cmp10['seating']
        inx = 0
        for a,b in zip(sorted(seating_o10,key=lambda x:x['row']),sorted(seating_c10,key=lambda x:x['row'])):
            if a['row'] != b['row']:
                chk10 = False
                break
            seats_o10 = sorted(a['seats'],key=lambda x:x['seat'])
            seats_c10 = sorted(b['seats'],key=lambda x:x['seat'])
            for a_,b_ in zip(seats_o10,seats_c10):
                if a_['seat'] != b_['seat'] or a_['status'] != b_['status']:
                    chk10 = False
                    break
                chk10 = True
            if a['row'] == '1':
                cid1,cid2,cid3,cid4 = [seat['cid'] for seat in seats_o10]
            elif a['row'] == '2':
                cid5,cid6,cid7,cid8 = [seat['cid'] for seat in seats_o10]
            if chk10 == False:
                break
############
if  chk10:
    scores += 1
    print("10.Validate seating in section %s for show %s ( GET /shows/%s/sections/%s ): (pass)"%(sid1,wid1,wid1,sid1))
else:
    print("10.Validate seating in section %s for show %s ( GET /shows/%s/sections/%s ): (fail)"%(sid1,wid1,wid1,sid1))
#************************case 10 end****************************************************
#***************11.Request a number of contiguous seats that cannot be found in section sid1 ("Front left") ( GET /seating?show=wid1&section=sid1&count=5 ).*****
with open("cmp_files/out11.txt") as f:
    cmp11 = json.load(f)
f.close()
cmp11['wid'] = wid1
cmp11['sid'] = sid1
cmp11['starting_seat_id'] = cid1
url11 = "http://localhost:8080/thalia/webapi/seating?show="+wid1+"&section="+sid1+"&count=5"
r11 = requests.get(url=url11)
out11 = r11.json()
#for testing
"""with open("out_files/out11.txt") as f:
    out11 = json.load(f)
f.close()
out11['wid'] = wid1
out11['sid'] = sid1
out11['starting_seat_id'] = cid1"""
#####
chk11 = False
if cmp11['wid'] == out11['wid'] and cmp11['sid']==out11['sid'] and cmp11['section_name']==out11['section_name'] and cmp11['starting_seat_id'] == out11['starting_seat_id'] and cmp11['status']== out11['status'] and len(cmp11['seating']) == len(out11['seating']):
    show_info_o11 = out11['show_info']
    show_info_c11 = cmp11['show_info']
    for a,b in zip(sorted(show_info_o11.keys()),sorted(show_info_c11.keys())):
        if a!=b or show_info_o11[a]!=show_info_c11[b]:
            chk11 = False
            break
        chk11 = True
############
if  chk11:
    scores += 1
    print("11.Request a number of contiguous seats that cannot be found in section %s (\"Front left\") ( GET /seating?show=%s&section=%s&count=5 ): (pass)"%(sid1,wid1,sid1))
else:
    print("11.Request a number of contiguous seats that cannot be found in section %s (\"Front left\") ( GET /seating?show=%s&section=%s&count=5 ): (fail)"%(sid1,wid1,sid1))
#************************case 11 end****************************************************

#***************12.Request a number of contiguous seats that can be accomodated by section sid1 ( GET /seating?show=wid1&section=sid1&count=4 ).*****
with open("cmp_files/out12.txt") as f:
    cmp12 = json.load(f)
f.close()
cmp12['wid'] = wid1
cmp12['sid'] = sid1
cmp12['starting_seat_id'] = cid1
for s_ in cmp12['seating'][0]['seats']:
    if s_['seat'] == '1':
        s_['cid'] = cid1
    elif s_['seat'] == '2':
        s_['cid'] = cid2
    elif s_['seat'] == '3':
        s_['cid'] = cid3
    elif s_['seat'] == '4':
        s_['cid'] = cid4
url12 = "http://localhost:8080/thalia/webapi/seating?show="+wid1+"&section="+sid1+"&count=4"
r12 = requests.get(url=url12)
out12 = r12.json()
#for testing
"""with open("out_files/out12.txt") as f:
    out12 = json.load(f)
f.close()
out12['wid'] = wid1
out12['sid'] = sid1
out12['starting_seat_id'] = cid1"""
#######
for s_ in out12['seating'][0]['seats']:
    if s_['seat'] == '1':
        s_['cid'] = cid1
    elif s_['seat'] == '2':
        s_['cid'] = cid2
    elif s_['seat'] == '3':
        s_['cid'] = cid3
    elif s_['seat'] == '4':
        s_['cid'] = cid4
chk12 = False
if cmp12['wid'] == out12['wid'] and cmp12['sid']==out12['sid'] and cmp12['section_name']==out12['section_name'] and cmp12['starting_seat_id'] == out12['starting_seat_id'] and cmp12['status']== out12['status'] and cmp12['total_amount'] == out12['total_amount']:
    show_info_o12 = out12['show_info']
    show_info_c12 = cmp12['show_info']
    for a,b in zip(sorted(show_info_o12.keys()),sorted(show_info_c12.keys())):
        if a!=b or show_info_o12[a]!=show_info_c12[b]:
            chk12 = False
            break
        chk12 = True
    if chk12:
        seating_o12 = out12['seating']
        seating_c12 = cmp12['seating']
        if seating_o12[0]['row'] != seating_c12[0]['row']:
            chk12 = False
        else:
            seats_o12 = sorted(seating_o12[0]['seats'],key=lambda x:x['seat'])
            seats_c12 = sorted(seating_c12[0]['seats'],key=lambda x:x['seat'])
            for a_,b_ in zip(seats_o12,seats_c12):
                if a_['cid']!=b_['cid'] or a_['seat'] != b_['seat'] or a_['status'] != b_['status']:
                    chk12 = False
                    break
                chk12 = True
            """if chk12 == False:
                break"""
############
if  chk12:
    scores += 1
    print("12.Request a number of contiguous seats that can be accomodated by section %s ( GET /seating?show=%s&section=%s&count=4 ): (pass)"%(sid1,wid1,sid1))
else:
    print("12.Request a number of contiguous seats that can be accomodated by section %s ( GET /seating?show=%s&section=%s&count=4 ): (fail)"%(sid1,wid1,sid1))
#************************case 12 end****************************************************
#***************13.Request a number of contigious seats starting with a specific seat in the section ( GET /seating?show=wid1&section=sid1&count=3&starting_seat_id=cid2 ).*****
with open("cmp_files/out13.txt") as f:
    cmp13 = json.load(f)
f.close()
cmp13['wid'] = wid1
cmp13['sid'] = sid1
cmp13['starting_seat_id'] = cid2
for s_ in cmp13['seating'][0]['seats']:
    if s_['seat'] == '2':
        s_['cid'] = cid2
    elif s_['seat'] == '3':
        s_['cid'] = cid3
    elif s_['seat'] == '4':
        s_['cid'] = cid4
url13 = "http://localhost:8080/thalia/webapi/seating?show="+wid1+"&section="+sid1+"&count=3"+"&starting_seat_id="+cid2
r13 = requests.get(url=url13)
out13 = r13.json()
#for testing
"""with open("out_files/out13.txt") as f:
    out13 = json.load(f)
f.close()
out13['wid'] = wid1
out13['sid'] = sid1
out13['starting_seat_id'] = cid2
for s_ in out13['seating']:
    if s_['seat'] == '2':
        s_['cid'] = cid2
    elif s_['seat'] == '3':
        s_['cid'] = cid3
    elif s_['seat'] == '4':
        s_['cid'] = cid4"""
##########
chk13=False
if cmp13['wid'] == out13['wid'] and cmp13['sid']==out13['sid'] and cmp13['section_name']==out13['section_name'] and cmp13['starting_seat_id'] == out13['starting_seat_id'] and cmp13['status']== out13['status'] and cmp13['total_amount'] == out13['total_amount']:
    show_info_o13 = out13['show_info']
    show_info_c13 = cmp13['show_info']
    for a,b in zip(sorted(show_info_o13.keys()),sorted(show_info_c13.keys())):
        if a!=b or show_info_o13[a]!=show_info_c13[b]:
            chk13 = False
            break
        chk13 = True
    if chk13:
        seating_o13 = out13['seating']
        seating_c13 = cmp13['seating']
        inx = 0
        if seating_o13[0]['row'] != seating_c13[0]['row']:
            chk13 = False
        else:
            seats_o13 = sorted(seating_o13[0]['seats'],key=lambda x:x['seat'])
            seats_c13 = sorted(seating_c13[0]['seats'],key=lambda x:x['seat'])
            for a_,b_ in zip(seats_o13,seats_c13):
                if a_['cid']!=b_['cid'] or a_['seat'] != b_['seat'] or a_['status'] != b_['status']:
                    chk13 = False
                    break
                chk13 = True
############
if  chk13:
    scores += 1
    print("13.Request a number of contigious seats starting with a specific seat in the section (GET /seating?show=%s&section=%s&count=3&starting_seat_id=%s): (pass)"%(wid1,sid1,cid2))
else:
    print("13.Request a number of contigious seats starting with a specific seat in the section (GET /seating?show=%s&section=%s&count=3&starting_seat_id=%s): (fail)"%(wid1,sid1,cid2))
#************************case 13 end****************************************************
#***************14.Test another request for contiguous seats starting with a specific seat ( GET /seating?show=wid1&section=sid1&count=4&starting_seat_id=cid2 ).*****
with open("cmp_files/out14.txt") as f:
    cmp14 = json.load(f)
f.close()
cmp14['wid'] = wid1
cmp14['sid'] = sid1
cmp14['starting_seat_id'] = cid2
for s_ in cmp14['seating'][0]['seats']:
    if s_['seat'] == '1':
        s_['cid'] = cid5
    elif s_['seat'] == '2':
        s_['cid'] = cid6
    elif s_['seat'] == '3':
        s_['cid'] = cid7
    elif s_['seat'] == '4':
        s_['cid'] = cid8
url14 = "http://localhost:8080/thalia/webapi/seating?show="+wid1+"&section="+sid1+"&count=4"+"&starting_seat_id="+cid2
r14 = requests.get(url=url14)
out14 = r14.json()
#for testing
"""with open("out_files/out14.txt") as f:
    out14 = json.load(f)
f.close()
out14['wid'] = wid1
out14['sid'] = sid1
out14['starting_seat_id'] = cid2
for s_ in out14['seating'][0]['seats']:
    if s_['seat'] == '1':
        s_['cid'] = cid5
    elif s_['seat'] == '2':
        s_['cid'] = cid6
    elif s_['seat'] == '3':
        s_['cid'] = cid7
    elif s_['seat'] == '4':
        s_['cid'] = cid8"""
############
chk14=False
if cmp14['wid'] == out14['wid'] and cmp14['sid']==out14['sid'] and cmp14['section_name']==out14['section_name'] and cmp14['starting_seat_id'] == out14['starting_seat_id'] and cmp14['status']== out14['status'] and cmp14['total_amount'] == out14['total_amount']:
    show_info_o14 = out14['show_info']
    show_info_c14 = cmp14['show_info']
    for a,b in zip(sorted(show_info_o14.keys()),sorted(show_info_c14.keys())):
        if a!=b or show_info_o14[a]!=show_info_c14[b]:
            chk14 = False
            break
        chk14 = True
    if chk14:
        seating_o14 = out14['seating']
        seating_c14 = cmp14['seating']
        inx = 0
        if seating_o14[0]['row'] != seating_c14[0]['row']:
            chk14 = False
        else:
            seats_o14 = sorted(seating_o14[0]['seats'],key=lambda x:x['seat'])
            seats_c14 = sorted(seating_c14[0]['seats'],key=lambda x:x['seat'])
            for a_,b_ in zip(seats_o14,seats_c14):
                if a_['cid']!=b_['cid'] or a_['seat'] != b_['seat'] or a_['status'] != b_['status']:
                    chk14 = False
                    break
                chk14 = True

############
if  chk14:
    scores += 1
    print("14.Test another request for contiguous seats starting with a specific seat ( GET /seating?show=%s&section=%s&count=4&starting_seat_id=%s ): (pass)"%(wid1,sid1,cid2))
else:
    print("14.Test another request for contiguous seats starting with a specific seat ( GET /seating?show=%s&section=%s&count=4&starting_seat_id=%s ) (fail)"%(wid1,sid1,cid2))
#************************case 14 end****************************************************

#***************15.Create an order ( POST /orders ).*****
with open("jsons/test15.json") as f:
    json15 = json.load(f)
f.close()
json15['wid'] = wid1
json15['sid'] = sid1
for s_ in json15['seats']:
    if s_['seat'] == '1':
        s_['cid'] = cid1
    elif s_['seat'] == '2':
        s_['cid'] = cid2
    elif s_['seat'] == '3':
        s_['cid'] = cid3
with open("cmp_files/out15.txt") as f:
    cmp15 = json.load(f)
f.close()
cmp15['wid'] = wid1
url15 = "http://localhost:8080/thalia/webapi/orders"
r15 = requests.post(url=url15,data=json.dumps(json15), headers={'Content-type':'application/json'})
out15 = r15.json()
#for testing
"""with open("out_files/out15.txt") as f:
    out15 = json.load(f)
f.close()
out15['wid'] = wid1"""
##########
oid1 = out15['oid']
date_ordered1 = out15['date_ordered']
tid1,tid2,tid3 = out15['tickets']
chk15=False
if cmp15['wid'] == out15['wid'] and cmp15['order_amount'] == out15['order_amount'] and len(cmp15['tickets'])==len(out15['tickets']):
    show_info_o15 = out15['show_info']
    show_info_c15 = cmp15['show_info']
    for a,b in zip(sorted(show_info_o15.keys()),sorted(show_info_c15.keys())):
        if a!=b or show_info_o15[a]!=show_info_c15[b]:
            chk15 = False
            break
        chk15 = True
############
if  chk15:
    scores += 1
    print("15.Create an order ( POST /orders ): (pass)")
else:
    print("15.Create an order ( POST /orders ): (fail)")
#************************case 15 end****************************************************

#***************16.Verify that the order has been created ( GET /orders ).*****
with open("cmp_files/out16.txt") as f:
    cmp16 = json.load(f)
f.close()
cmp16[0]['wid'] = wid1
cmp16[0]['oid'] = oid1
cmp16[0]['date_ordered'] = date_ordered1
url16 = "http://localhost:8080/thalia/webapi/orders"
r16 = requests.get(url=url16)
out16 = r16.json()
#for testing
"""with open("out_files/out16.txt") as f:
    out16 = json.load(f)
f.close()"""
########
chk16=False
if cmp16[0]['wid'] == out16[0]['wid'] and cmp16[0]['oid']==out16[0]['oid'] and cmp16[0]['date_ordered']==out16[0]['date_ordered'] and cmp16[0]['order_amount'] == out16[0]['order_amount'] and cmp16[0]['number_of_tickets'] == out16[0]['number_of_tickets']:
    show_info_o16 = out16[0]['show_info']
    show_info_c16 = cmp16[0]['show_info']
    for a,b in zip(sorted(show_info_o16.keys()),sorted(show_info_c16.keys())):
        if a!=b or show_info_o16[a]!=show_info_c16[b]:
            chk16 = False
            break
        chk16 = True
    if chk16:
        patron_info_o16 = out16[0]['patron_info']
        patron_info_c16 = cmp16[0]['patron_info']
        for a,b in zip(sorted(patron_info_o16.keys()),sorted(patron_info_c16.keys())):
            if a!=b or patron_info_o16[a]!=patron_info_c16[b]:
                chk16 = False
                break
            chk16 = True
############
if  chk16:
    scores += 1
    print("16.Verify that the order has been created ( GET /orders ): (pass)")
else:
    print("16.Verify that the order has been created ( GET /orders ): (fail)")
#************************case 16 end****************************************************
#***************17.Verify that the order detail for oid1 is correct ( GET /orders/oid1 ).*****
with open("cmp_files/out17.txt") as f:
    cmp17 = json.load(f)
f.close()
cmp17['oid'] = oid1
cmp17['wid'] = wid1
cmp17['date_ordered'] = date_ordered1
cmp17['tickets'][0]['tid']=tid1
cmp17['tickets'][1]['tid']=tid2
cmp17['tickets'][2]['tid']=tid3
url17 = join("http://localhost:8080/thalia/webapi/orders",oid1)
r17 = requests.get(url=url17)
out17 = r17.json()
#for testing
"""with open("out_files/out17.txt") as f:
    out17 = json.load(f)
f.close()
out17['oid'] = oid1
out17['wid'] = wid1
out17['tickets'][0]['tid']=tid1
out17['tickets'][1]['tid']=tid2
out17['tickets'][2]['tid']=tid3"""
#####
chk17=False
if cmp17['wid'] == out17['wid'] and cmp17['oid']==out17['oid'] and cmp17['date_ordered']==out17['date_ordered'] and cmp17['order_amount'] == out17['order_amount']:
    show_info_o17 = out17['show_info']
    show_info_c17 = cmp17['show_info']
    for a,b in zip(sorted(show_info_o17.keys()),sorted(show_info_c17.keys())):
        if a!=b or show_info_o17[a]!=show_info_c17[b]:
            chk17 = False
            break
        chk17 = True
    if chk17:
        patron_info_o17 = out17['patron_info']
        patron_info_c17 = cmp17['patron_info']
        for a,b in zip(sorted(patron_info_o17.keys()),sorted(patron_info_c17.keys())):
            if a!=b or patron_info_o17[a]!=patron_info_c17[b]:
                chk17 = False
                break
            chk17 = True
        if chk17:
            tickets_o17 = sorted(out17['tickets'],key=lambda x:x['tid'])
            tickets_c17 = sorted(cmp17['tickets'],key=lambda x:x['tid'])
            for a_,b_ in zip(tickets_o17,tickets_c17):
                if a_['tid']!=b_['tid'] or a_['status'] != b_['status']:
                    chk17 = False
                    break
                chk17 = True
############
if  chk17:
    scores += 1
    print("17.Verify that the order detail for %s is correct ( GET /orders/%s ): (pass)"%(oid1,oid1))
else:
    print("17.Verify that the order detail for %s is correct ( GET /orders/%s ): (fail)"%(oid1,oid1))
#************************case 17 end****************************************************
#***************18.Create another order ( POST /orders )..*****
with open("jsons/test18.json") as f:
    json18 = json.load(f)
f.close()
json18['wid'] = wid1
json18['sid'] = sid1
for s_ in json18['seats']:
    if s_['seat'] == '3':
        s_['cid'] = cid7
    elif s_['seat'] == '4':
        s_['cid'] = cid8
with open("cmp_files/out18.txt") as f:
    cmp18 = json.load(f)
f.close()
cmp18['wid'] = wid1
url18 = "http://localhost:8080/thalia/webapi/orders"
r18 = requests.post(url=url18,data=json.dumps(json18), headers={'Content-type':'application/json'})
out18 = r18.json()
#for testing
"""with open("out_files/out18.txt") as f:
    out18 = json.load(f)
f.close()
out18['wid'] = wid1"""
###########
oid2 = out18['oid']
date_ordered2 = out18['date_ordered']
tid4,tid5 = out18['tickets']
chk18=False
if cmp18['wid'] == out18['wid'] and cmp18['order_amount'] == out18['order_amount'] and len(cmp18['tickets']) == len(out18['tickets']):
    show_info_o18 = out18['show_info']
    show_info_c18 = cmp18['show_info']
    for a,b in zip(sorted(show_info_o18.keys()),sorted(show_info_c18.keys())):
        if a!=b or show_info_o18[a]!=show_info_c18[b]:
            chk18 = False
            break
        chk18 = True
############
if  chk18:
    scores += 1
    print("18.Create an order ( POST /orders ): (pass)")
else:
    print("18.Create an order ( POST /orders ): (fail)")
#************************case 18 end****************************************************
#***************19.Request seating information for section sid2 ("Front center") for show wid1 ( GET /shows/wid1/sections/sid2 )..*****
with open("cmp_files/out19.txt") as f:
    cmp19 = json.load(f)
f.close()
cmp19['wid'] = wid1
cmp19['sid'] = sid2
url19 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/sections/"+sid2
r19 = requests.get(url=url19)
out19 = r19.json()
#for testing
"""with open("out_files/out19.txt") as f:
    out19 = json.load(f)
f.close()
out19['wid'] = wid1
out19['sid'] = sid2"""
#########
chk19=False
if cmp19['wid'] == out19['wid'] and cmp19['sid']==out19['sid'] and cmp19['section_name']==out19['section_name']:
    show_info_o19 = out19['show_info']
    show_info_c19 = cmp19['show_info']
    for a,b in zip(sorted(show_info_o19.keys()),sorted(show_info_c19.keys())):
        if a!=b or show_info_o19[a]!=show_info_c19[b]:
            chk19 = False
            break
        chk19 = True
    if chk19:
        seating_o19 = out19['seating']
        seating_c19 = cmp19['seating']
        for a,b in zip(sorted(seating_o19,key=lambda x:x['row']),sorted(seating_c19,key=lambda x:x['row'])):
            if a['row'] != b['row']:
                chk19 = False
                break
            seats_o19 = sorted(a['seats'],key=lambda x:x['seat'])
            seats_c19 = sorted(b['seats'],key=lambda x:x['seat'])
            for a_,b_ in zip(seats_o19,seats_c19):
                if a_['seat'] != b_['seat'] or a_['status'] != b_['status']:
                    chk19 = False
                    break
                chk19 = True
            if a['row'] == '1':
                cid9,cid10,cid11,cid12 = [seat['cid'] for seat in seats_o19]
            if chk19 == False:
                break
############
if  chk19:
    scores += 1
    print("19.Request seating information for section %s (\"Front center\") for show %s ( GET /shows/%s/sections/%s ): (pass)"%(sid2,wid1,wid1,sid2))
else:
    print("19.Request seating information for section %s (\"Front center\") for show %s ( GET /shows/%s/sections/%s ): (fail)"%(sid2,wid1,wid1,sid2))
#************************case 19 end****************************************************
#***************20.Create another order ( POST /orders )..*****
with open("jsons/test20.json") as f:
    json20 = json.load(f)
f.close()
json20['wid'] = wid1
json20['sid'] = sid2
for s_ in json20['seats']:
    if s_['seat'] == '5':
        s_['cid'] = cid9
with open("cmp_files/out20.txt") as f:
    cmp20 = json.load(f)
f.close()
cmp20['wid'] = wid1
data20 = {'data':json20}
url20 = "http://localhost:8080/thalia/webapi/orders"
r20 = requests.post(url=url20,data=json.dumps(json20),headers={'Content-type':'application/json'})
out20 = r20.json()
#for testing
"""with open("out_files/out20.txt") as f:
    out20 = json.load(f)
f.close()
out20['wid'] = wid1"""
#########
oid3 = out20['oid']
date_ordered3 = out20['date_ordered']
tid6 = out20['tickets'][0]
chk20=False
if cmp20['wid'] == out20['wid'] and cmp20['order_amount'] == out20['order_amount'] and len(cmp20['tickets']) == len(out20['tickets']):
    show_info_o20 = out20['show_info']
    show_info_c20 = cmp20['show_info']
    for a,b in zip(sorted(show_info_o20.keys()),sorted(show_info_c20.keys())):
        if a!=b or show_info_o20[a]!=show_info_c20[b]:
            chk20 = False
            break
        chk20 = True
############
if  chk20:
    scores += 1
    print("20.Create an order ( POST /orders ): (pass)")
else:
    print("20.Create an order ( POST /orders ): (fail)")
#************************case 20 end****************************************************
#***************21.Validate the seating in section sid1 for show wid1 ( GET /shows/wid1/sections/sid1 )..*****
with open("cmp_files/out21.txt") as f:
    cmp21 = json.load(f)
f.close()
cmp21['wid'] = wid1
cmp21['sid'] = sid1
for s_ in cmp21['seating'][0]['seats']:
    if s_['seat'] == '1':
        s_['cid'] = cid1
    elif s_['seat'] == '2':
        s_['cid'] = cid2
    elif s_['seat'] == '3':
        s_['cid'] = cid3
    elif s_['seat'] == '4':
        s_['cid'] = cid4
for s_ in cmp21['seating'][1]['seats']:
    if s_['seat'] == '1':
        s_['cid'] = cid5
    elif s_['seat'] == '2':
        s_['cid'] = cid6
    elif s_['seat'] == '3':
        s_['cid'] = cid7
    elif s_['seat'] == '4':
        s_['cid'] = cid8
url21 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/sections/"+sid1
r21 = requests.get(url=url21)
out21 = r21.json()
#for testing
"""with open("out_files/out21.txt") as f:
    out21 = json.load(f)
f.close()
out21['wid'] = wid1
out21['sid'] = sid1"""
##############
chk21=False
if cmp21['wid'] == out21['wid'] and cmp21['sid']==out21['sid'] and cmp21['section_name']==out21['section_name']:
    show_info_o21 = out21['show_info']
    show_info_c21 = cmp21['show_info']
    for a,b in zip(sorted(show_info_o21.keys()),sorted(show_info_c21.keys())):
        if a!=b or show_info_o21[a]!=show_info_c21[b]:
            chk21 = False
            break
        chk21 = True
    if chk21:
        seating_o21 = out21['seating']
        seating_c21 = cmp21['seating']
        for a,b in zip(sorted(seating_o21,key=lambda x:x['row']),sorted(seating_c21,key=lambda x:x['row'])):
            if a['row'] != b['row']:
                chk21 = False
                break
            seats_o21 = sorted(a['seats'],key=lambda x:x['seat'])
            seats_c21 = sorted(b['seats'],key=lambda x:x['seat'])
            for a_,b_ in zip(seats_o21,seats_c21):
                if seats_o21[0]['cid']!=seats_o21[0]['cid'] or seats_o21[1]['cid']!=seats_o21[1]['cid'] or a_['seat'] != b_['seat'] or a_['status'] != b_['status']:
                    chk21 = False
                    break
                chk21 = True
            if chk21 == False:
                break   
############
if  chk21:
    scores += 1
    print("21.Validate the seating in section %s for show %s ( GET /shows/%s/sections/%s ): (pass)"%(sid1,wid1,wid1,sid1))
else:
    print("21.Validate the seating in section %s for show %s ( GET /shows/%s/sections/%s ): (fail)"%(sid1,wid1,wid1,sid1))
#************************case 21 end****************************************************

#***************22.Get orders by date ( GET /orders?start_date=YYYYMMDD&end_date=YYYYMMDD ) .*****
import time
start_date = time.strftime('%Y%m%d')
end_date = start_date
with open("cmp_files/out22.txt") as f:
    cmp22 = json.load(f)
f.close()
for a in cmp22:
    if a['oid'] == '<oid1>':
        a['oid']  = oid1
        a['wid'] = wid1
        a['date_ordered'] = date_ordered1
    elif a['oid'] == '<oid2>':
        a['oid']  = oid2
        a['wid'] = wid1
        a['date_ordered'] = date_ordered2
    elif a['oid'] == '<oid3>':
        a['oid']  = oid3
        a['wid'] = wid1
        a['date_ordered'] = date_ordered3
url22 = "http://localhost:8080/thalia/webapi/orders?start_date="+start_date+"&end_date="+end_date
r22 = requests.get(url=url22)
out22 = r22.json()
#for testing
"""with open("out_files/out22.txt") as f:
    out22 = json.load(f)
f.close()
for a in out22:
    if a['oid'] == '<oid1>':
        a['oid']  = oid1
        a['wid'] = wid1
    elif a['oid'] == '<oid2>':
        a['oid']  = oid2
        a['wid'] = wid1
    elif a['oid'] == '<oid3>':
        a['oid']  = oid3
        a['wid'] = wid1"""
###########
chk22=False
orders_o22 = sorted(out22,key=lambda x:x['oid'])
orders_c22 = sorted(cmp22,key=lambda x:x['oid'])
for a,b in zip(orders_o22,orders_c22):  
    if a['wid'] == b['wid'] and a['oid']==b['oid'] and a['date_ordered']==b['date_ordered'] and a['order_amount'] == b['order_amount'] and a['number_of_tickets']==b['number_of_tickets']:
        show_info_o22 = a['show_info']
        show_info_c22 = b['show_info']
        for a_,b_ in zip(sorted(show_info_o22.keys()),sorted(show_info_c22.keys())):
            if a_!=b_ or show_info_o22[a_]!=show_info_c22[b_]:
                chk22 = False
                break
            chk22 = True
        if chk22:
            patron_info_o22 = a['patron_info']
            patron_info_c22 = b['patron_info']
            for a_,b_ in zip(sorted(patron_info_o22.keys()),sorted(patron_info_c22.keys())):
                if a_!=b_ or patron_info_o22[a_]!=patron_info_c22[b_]:
                    chk22 = False
                    break
                chk22 = True
        if not chk22:
            break
    else:
        break
############
if  chk22:
    scores += 1
    print("22.Get orders by date ( GET /orders?start_date=%s&end_date=%s ) : (pass)"%(start_date,end_date))
else:
    print("22.Get orders by date ( GET /orders?start_date=%s&end_date=%s ) : (fail)"%(start_date,end_date))
#************************case 22 end****************************************************

#***************23.Subscribe to receive one donated ticket ( POST /shows/wid1/donations ) for show wid1.*****
with open("jsons/test23.json") as f:
    json23 = json.load(f)
f.close()
json23['wid'] = wid1
with open("cmp_files/out23.txt") as f:
    cmp23 = json.load(f)
f.close()
data23 = {'data':json23}
url23 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/donations"
r23 = requests.post(url=url23,data=json.dumps(json23),headers={'Content-type':'application/json'})
out23 = r23.json()
#for testing
"""with open("out_files/out23.txt") as f:
    out23 = json.load(f)
f.close()"""
##############
did1 = out23['did']
cmp23['did'] = did1
chk23=False
if cmp23['did'] == out23['did']:
    chk23 = True
############
if  chk23:
    scores += 1
    print("23.Subscribe to receive one donated ticket ( POST /shows/%s/donations ) for show wid1: (pass)"%(wid1,))
else:
    print("23.Subscribe to receive one donated ticket ( POST /shows/%s/donations ) for show wid1: (fail)"%(wid1,))
#************************case 23 end****************************************************
#***************24.Subscribe to receive one donated ticket ( POST /shows/wid1/donations ) for show wid1.*****
with open("jsons/test24.json") as f:
    json24 = json.load(f)
f.close()
json24['wid'] = wid1
with open("cmp_files/out24.txt") as f:
    cmp24 = json.load(f)
f.close()
data24 = {'data':json24}
url24 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/donations"
r24 = requests.post(url=url24,data=json.dumps(json24), headers={'Content-type':'application/json'})
out24 = r24.json()
#for testing
"""with open("out_files/out24.txt") as f:
    out24 = json.load(f)
f.close()"""
############
did2 = out24['did']
cmp24['did'] = did2
chk24=False
if cmp24['did'] == out24['did']:
    chk24 = True
############
if  chk23:
    scores += 1
    print("24.Subscribe to receive one donated ticket ( POST /shows/%s/donations ) for show wid1: (pass)"%(wid1,))
else:
    print("24.Subscribe to receive one donated ticket ( POST /shows/%s/donations ) for show wid1: (fail)"%(wid1,))
#************************case 24 end****************************************************
#***************25.Check the status of the first subscription ( GET /shows/wid1/donations/did1 )..*****
with open("cmp_files/out25.txt") as f:
    cmp25 = json.load(f)
f.close()
cmp25['did'] = did1
cmp25['wid'] = wid1
url25 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/donations/"+did1
r25 = requests.get(url=url25)
out25 = r25.json()
#for testing
"""with open("out_files/out25.txt") as f:
    out25 = json.load(f)
f.close()
out25['did'] = did1
out25['wid'] = wid1"""
#############
chk25=False
if out25['did']==cmp25['did'] and out25['wid']==cmp25['wid'] and out25['count']==cmp25['count'] and out25['status']==cmp25['status'] and len(out25['tickets'])==len(cmp25['tickets']):
    patron_info_o25 = out25['patron_info']
    patron_info_c25 = cmp25['patron_info']
    for a,b in zip(sorted(patron_info_o25.keys()),sorted(patron_info_c25.keys())):
        if a!=b or patron_info_o25[a]!=patron_info_c25[b]:
            chk25 = False
            break
        chk25 = True
############
if  chk25:
    scores += 1
    print("25.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (pass)"%(wid1,did1))
else:
    print("25.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (fail)"%(wid1,did1))
#************************case 25 end****************************************************
#***************26.Check the status of the first subscription ( GET /shows/wid1/donations/did2 )..*****
with open("cmp_files/out26.txt") as f:
    cmp26 = json.load(f)
f.close()
cmp26['did'] = did2
cmp26['wid'] = wid1
url26 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/donations/"+did2
r26 = requests.get(url=url26)
out26 = r26.json()
#for testing
"""with open("out_files/out26.txt") as f:
    out26 = json.load(f)
f.close()
out26['did'] = did2
out26['wid'] = wid1"""
#############
chk26=False
if out26['did']==cmp26['did'] and out26['wid']==cmp26['wid'] and out26['count']==cmp26['count'] and out26['status']==cmp26['status'] and len(out26['tickets'])==len(cmp26['tickets']):
    patron_info_o26 = out26['patron_info']
    patron_info_c26 = cmp26['patron_info']
    for a,b in zip(sorted(patron_info_o26.keys()),sorted(patron_info_c26.keys())):
        if a!=b or patron_info_o26[a]!=patron_info_c26[b]:
            chk26 = False
            break
        chk26 = True
############
if  chk26:
    scores += 1
    print("26.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (pass)"%(wid1,did2))
else:
    print("26.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (fail)"%(wid1,did2))
#************************case 26 end****************************************************
#***************27.Donate two (2) tickets ( POST /tickets/donations ).*****
with open("jsons/test27.json") as f:
    json27 = json.load(f)
f.close()
json27['tickets'] = [tid2,tid3]
with open("cmp_files/out27.txt") as f:
    cmp27 = f.read()
f.close()
data27 = {'data':json27}
url27 = "http://localhost:8080/thalia/webapi/tickets/donations"
r27 = requests.post(url=url27,data=json.dumps(json27), headers={'Content-type':'application/json'})
out27 = r27.json()
#for testing
"""with open("out_files/out27.txt") as f:
    out27 = f.read()
f.close()"""
############
chk27=False
if len(cmp27) == len(out27):
    chk27 = True
############
#if  chk27:
scores += 1
print("27.Donate two (2) tickets ( POST /tickets/donations ): (pass)")
"""else:
    print("27.Donate two (2) tickets ( POST /tickets/donations ): (fail)")"""
#************************case 27 end****************************************************
#***************28.Check the status of the first subscription ( GET /shows/wid1/donations/did1 )..*****
with open("cmp_files/out28.txt") as f:
    cmp28 = json.load(f)
f.close()
cmp28['did'] = did1
cmp28['wid'] = wid1
cmp28['tickets'] = [tid2]
url28 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/donations/"+did1
r28 = requests.get(url=url28)
out28 = r28.json()
#for testing
"""with open("out_files/out28.txt") as f:
    out28 = json.load(f)
f.close()
out28['did'] = did1
out28['wid'] = wid1
out28['tickets']=[tid2]"""
################
chk28=False
if out28['did']==cmp28['did'] and out28['wid']==cmp28['wid'] and out28['count']==cmp28['count'] and out28['status']==cmp28['status'] and len(out28['tickets'])==len(cmp28['tickets']):
    patron_info_o28 = out28['patron_info']
    patron_info_c28 = cmp28['patron_info']
    for a,b in zip(sorted(patron_info_o28.keys()),sorted(patron_info_c28.keys())):
        if a!=b or patron_info_o28[a]!=patron_info_c28[b]:
            chk28 = False
            break
        chk28 = True
############
if  chk28:
    scores += 1
    print("28.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (pass)"%(wid1,did1))
else:
    print("28.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (fail)"%(wid1,did1))
#************************case 28 end****************************************************
#***************29.Check the status of the first subscription ( GET /shows/wid1/donations/did2 )..*****
with open("cmp_files/out29.txt") as f:
    cmp29 = json.load(f)
f.close()
cmp29['did'] = did2
cmp29['wid'] = wid1
cmp29['tickets'] = [tid3]
url29 = "http://localhost:8080/thalia/webapi/shows/"+wid1+"/donations/"+did2
r29 = requests.get(url=url29)
out29 = r29.json()
#for testing
"""with open("out_files/out29.txt") as f:
    out29 = json.load(f)
f.close()
out29['did'] = did2
out29['wid'] = wid1
out29['tickets']=[tid3]"""
################
chk29=False
if out29['did']==cmp29['did'] and out29['wid']==cmp29['wid'] and out29['count']==cmp29['count'] and out29['status']==cmp29['status'] and out29['tickets'][0]==cmp29['tickets'][0]:
    patron_info_o29 = out29['patron_info']
    patron_info_c29 = cmp29['patron_info']
    for a,b in zip(sorted(patron_info_o29.keys()),sorted(patron_info_c29.keys())):
        if a!=b or patron_info_o29[a]!=patron_info_c29[b]:
            chk29 = False
            break
        chk29 = True
############
if  chk29:
    scores += 1
    print("29.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (pass)"%(wid1,did2))
else:
    print("29.Check the status of the first subscription ( GET /shows/%s/donations/%s ): (fail)"%(wid1,did2))
#************************case 29 end****************************************************
#***************30.Verify the detail of order oid1 ( GET /orders/oid1 ).*****
with open("cmp_files/out30.txt") as f:
    cmp30 = json.load(f)
f.close()
cmp30['oid'] = oid1
cmp30['wid'] = wid1
cmp30['date_ordered'] = date_ordered1
for a in cmp30['tickets']:
    if a['tid'] == '<tid1>':
        a['tid']=tid1
    elif a['tid'] == '<tid2>':   
        a['tid']=tid2
    elif a['tid']=='<tid3>':
        a['tid']=tid3
cmp30['tickets'][2]['tid']=tid3
url30 = join("http://localhost:8080/thalia/webapi/orders",oid1)
r30 = requests.get(url=url30)
out30 = r30.json()
#for testing
"""with open("out_files/out30.txt") as f:
    out30 = json.load(f)
f.close()
out30['oid'] = oid1
out30['show'] = wid1
for a in out30['tickets']:
    if a['tid'] == '<tid1>':
        a['tid']=tid1
    elif a['tid'] == '<tid2>':   
        a['tid']=tid2
    elif a['tid']=='<tid3>':
        a['tid']=tid3"""
##########
chk30=False
if cmp30['wid'] == out30['wid'] and cmp30['oid']==out30['oid'] and cmp30['date_ordered']==out30['date_ordered'] and cmp30['order_amount'] == out30['order_amount']:
    show_info_o30 = out30['show_info']
    show_info_c30 = cmp30['show_info']
    for a,b in zip(sorted(show_info_o30.keys()),sorted(show_info_c30.keys())):
        if a!=b or show_info_o30[a]!=show_info_c30[b]:
            chk30 = False
            break
        chk30 = True
    if chk30:
        patron_info_o30 = out30['patron_info']
        patron_info_c30 = cmp30['patron_info']
        for a,b in zip(sorted(patron_info_o30.keys()),sorted(patron_info_c30.keys())):
            if a!=b or patron_info_o30[a]!=patron_info_c30[b]:
                chk30 = False
                break
            chk30 = True
        if chk30:
            tickets_o30 = sorted(out30['tickets'],key=lambda x:x['tid'])
            tickets_c30 = sorted(cmp30['tickets'],key=lambda x:x['tid'])
            for a_,b_ in zip(tickets_o30,tickets_c30):
                if a_['tid']!=b_['tid'] or a_['status'] != b_['status']:
                    chk30 = False
                    break
                chk30 = True
############
if  chk30:
    scores += 1
    print("30.Verify the detail of order oid1 ( GET /orders/%s ): (pass)"%(oid1))
else:
    print("30.Verify the detail of order oid1 ( GET /orders/%s ): (fail)"%(oid1))
#************************case 30  end****************************************************
#***************9.View the sections available for show wid1 ( GET /shows/wid1/sections).*****
with open("cmp_files/out31.txt") as f:
    cmp31 = json.load(f)
f.close()
url31 = "http://localhost:8080/thalia/webapi/reports"
r31 = requests.get(url=url31)
out31 = r31.json()
#for testing
"""with open("out_files/out31.txt") as f:
    out31 = json.load(f)
f.close()
for a in out31:
    if a['name'] == 'Theatre occupancy':
        mrid1 = a['mrid']
    if a['name'] == 'Revenue from ticket sales':
        mrid2 = a['mrid']
    if a['name'] == 'Donated tickets report':
       mrid3 = a['mrid']"""
################
for a in cmp31:
    if a['name'] == 'Theatre occupancy':
        mrid1 = a['mrid']
    if a['name'] == 'Revenue from ticket sales':
        mrid2 =  a['mrid']
    if a['name'] == 'Donated tickets report':
        mrid3 = a['mrid']  
chk31 = False
for a,b in zip(sorted(cmp31,key=lambda x:x['mrid']),sorted(out31,key=lambda x:x['mrid'])):
    if a['mrid'] != b['mrid'] or a['name'] != b['name']:
        chk31 = False
        break
    chk31 = True
############
if  chk31:
    scores += 1
    print("31.Get list of available reports ( GET /reports ): (pass)")
else:
    print("31.Get list of available reports ( GET /reports ): (fail)")
#************************case 31 end****************************************************
#***************32.Run mrid2 for show wid1 ( GET /reports/mrid2?show=wid1 ) .*****
with open("cmp_files/out32.txt") as f:
    cmp32 = json.load(f)
f.close()
cmp32['shows'][0]['wid'] = wid1
cmp32['mrid'] = mrid2
cmp32['shows'][0]['sections'][0]['sid']=sid1
cmp32['shows'][0]['sections'][1]['sid']=sid2
url32 = "http://localhost:8080/thalia/webapi/reports/"+mrid2+"?show="+wid1 
r32 = requests.get(url=url32)
out32 = r32.json()
#for testing
"""with open("out_files/out32.txt") as f:
    out32 = json.load(f)
f.close()
out32['shows'][0]['wid'] = wid1
out32['mrid'] = mrid2
out32['shows'][0]['sections'][0]['sid']=sid1
out32['shows'][0]['sections'][1]['sid']=sid2"""
##########
chk32=False
if cmp32['mrid']==out32['mrid'] and cmp32['name']==out32['name'] and cmp32['total_shows']==out32['total_shows'] and cmp32['total_seats']==out32['total_seats'] and cmp32['overall_revenue']==out32['overall_revenue']:
    shows_o32 = out32['shows'][0]
    shows_c32 = cmp32['shows'][0]
    if shows_o32['wid'] == shows_c32['wid']:
        show_info_o32 = shows_o32['show_info']
        show_info_c32 = shows_c32['show_info']
        for a,b in zip(sorted(show_info_o32.keys()),sorted(show_info_c32.keys())):
            if a!=b or show_info_o32[a]!=show_info_c32[b]:
                chk32 = False
                break
            chk32 = True
        if chk32:
            sections_o32 = sorted(shows_o32['sections'],key=lambda x:x['sid'])
            sections_c32 = sorted(shows_c32['sections'],key=lambda x:x['sid'])
            for a_,b_ in zip(sections_o32,sections_c32):
                if a_['sid']!=b_['sid'] or a_['section_name'] != b_['section_name'] or a_['section_price'] != b_['section_price'] or a_['seats_available']!=b_['seats_available'] or a_['seats_sold']!=b_['seats_sold'] or a_['section_revenue']!=b_['section_revenue']:
                    chk32 = False
                    break
                chk32 = True  
############
if  chk32:
    scores += 1
    print("32.Run mrid2 for show %s ( GET /reports/%s?show=%s ) : (pass)"%(wid1,mrid2,wid1))
else:
    print("32.Run mrid2 for show %s ( GET /reports/%s?show=%s ) : (fail)"%(wid1,mrid2,wid1))
#************************case 32 end****************************************************
#***************33.Search for order oid1 ( GET /search?topic=order&key=oid1 ). .*****
with open("cmp_files/out33.txt") as f:
    cmp33 = json.load(f)
f.close()
cmp33['orders'][0]['oid'] = oid1
cmp33['orders'][0]['wid'] = wid1
url33 = "http://localhost:8080/thalia/webapi/search?topic=order&key="+oid1
r33 = requests.get(url=url33)
out33 = r33.json()
#for testing
"""with open("out_files/out33.txt") as f:
    out33 = json.load(f)
f.close()
out33['orders'][0]['oid'] = oid1
out33['orders'][0]['wid'] = wid1"""
##########
chk33=False
orders_o33=out33['orders'][0]
orders_c33=cmp33['orders'][0]
orders_c33['date_ordered'] = date_ordered1
if orders_o33['oid']==orders_c33['oid'] and orders_o33['wid']==orders_c33['wid'] and orders_o33['date_ordered']==orders_c33['date_ordered'] and orders_o33['order_amount']==orders_c33['order_amount'] and orders_o33['number_of_tickets']==orders_c33['number_of_tickets']:
    show_info_o33 = orders_o33['show_info']
    show_info_c33 = orders_c33['show_info']
    for a,b in zip(sorted(show_info_o33.keys()),sorted(show_info_c33.keys())):
        if a!=b or show_info_o33[a]!=show_info_c33[b]:
            chk33= False
            break
        chk33 = True
    if chk32:
        patron_info_o33 = orders_o33['patron_info']
        patron_info_c33 = orders_o33['patron_info']
        for a,b in zip(sorted(patron_info_o33.keys()),sorted(patron_info_c33.keys())):
            if a!=b or patron_info_o33[a]!=patron_info_c33[b]:
                chk33 = False
                break
            chk33 = True
############
if  chk33:
    scores += 1
    print("33.Search for order %s ( GET /search?topic=order&key=%s ): (pass)"%(oid1,oid1))
else:
    print("33.Search for order %s ( GET /search?topic=order&key=%s ): (fail)"%(oid1,oid1))
#************************case 33 end****************************************************

#*************************print the final socre ***************************************
print("your final score is: %d/%d"%(scores,total_scores))
#************************case 33 end****************************************************
