spaces=input('enter spaces: ').split(' ')
spaces=[int(i) for i in spaces]

inserts=input('enter inserts: ').split(' ')
inserts=[int(i) for i in inserts]
j=0
k=0
inserted=[int(0) for i in inserts]
for i in range(len(inserts)):
    while j in range(len(spaces)):
        if inserts[i]<=spaces[j]:
            print('inserted ',inserts[i],' at space ',spaces[j])
            spaces[j]-=inserts[i]
            inserted[i]=1
            j+=1
            break
        j+=1
    if j>=len(spaces)-1 and inserted[i]==0:
        j=0
        while j in range(len(spaces)):
            if inserts[i]<=spaces[j]:
                print('inserted ',inserts[i],' at space ',spaces[j])
                spaces[j]-=inserts[i]
                j+=1
                break
            j+=1
        if j>=len(spaces)-1 and inserted[i]==0:
            print('canot insert ',inserted[i])
    elif j>=len(spaces)-1 and inserted[i]==1:
        j=0
            