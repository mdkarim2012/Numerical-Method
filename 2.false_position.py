def f(x):
    return (x*x*x-x-2)
def false_position(a,b,f):
    if f(a) * f(b) > 0:
        print ("Select another value")
        return
    c=a
    while abs(f(c)-0)>0.001:
        c=a-f(a)*((a-b)/(f(a-f(b))))
        if f(c)==0:
            return c
        elif f(a) * f(c)>0:
            a=c
        else:
            b=c
    return c
#main function
z=false_position(2,-6,f)
print(z)
