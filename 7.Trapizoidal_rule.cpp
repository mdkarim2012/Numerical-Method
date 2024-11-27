#include <iostream>
using namespace std;
int main()
{
    int n;
    cout<<"Enter Value n = ";
    cin>>n;
    double x[n],y[n];
    int i_idx=1, e_idx = 5;
    
    cout<<"Enter Value x = ";
    for (int i = 0; i < n; i++)
    {
        cin>>x[i];
    }

    cout<<"Enter Value y = ";
    for (int i = 0; i < n; i++)
    {
        cin>>y[i];
    }
    double h = (x[e_idx]-x[i_idx])/(e_idx - i_idx);
    double m = y[i_idx]+y[e_idx];
    int k=0;
    for (int i = i_idx+1; i < e_idx; i++)
    {
        k=k+y[i];
    }
    double result = h/2 * (m + 2*k);
    cout<<"Result = "<<result<<endl;
    return 0;
}