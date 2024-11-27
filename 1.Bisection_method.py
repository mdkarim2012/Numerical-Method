def f(x):
    return x**3-x**2+x+7
def Bisection_method(f,a,b,tol):
    if f(a) * f(b)>=0:
        print("The bisection method failed.")
        return None
    c=a
    while abs(0-f(c))>tol:
        c=(a+b)/2

        if f(c)==0:
            break
        if f(c)*f(a)<0:
            b=c
        else:
            a=c

    return c

z=Bisection_method(f,1,2,1e-6)
print("Ans = "+str(z))