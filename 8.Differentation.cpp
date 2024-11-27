#include <iostream>
using namespace std;
int main()
{
    int n;
    cout<<"Enter Value n = ";
    cin>>n;
    double x[n],y[n];
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

    int i_dx;
    cout<<"Enter i_dx value : ";
    cin>>i_dx;

    int diff = (y[i_dx+1]-y[i_dx])/(x[i_dx+1]-x[i_dx]);
    cout<<"diff = "<<diff<<endl;
    return 0;
}