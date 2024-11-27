import math
def f(x):
    return math.sin(x)
def d_f(x):
    return math.cos(x)

def newton_rapson(_f,_df,x):
    xc=x
    while(abs(_f(xc))>=0.0001):
        xc=xc-(_f(xc)/_df(xc))
    return xc
#main function
z=newton_rapson(f,d_f,-100000000000)
print(z)