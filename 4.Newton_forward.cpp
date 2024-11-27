#include <iostream>
using namespace std;
int main()
{
    int n;
    cout << "Enter Size : ";
    cin >> n;

    double x[100], y[100];

    cout << "Enter value of Xn : ";
    for (int i = 0; i < n; ++i)
    {
        cin >> x[i];
    }

    cout << "Enter value of Yn : ";
    for (int i = 0; i < n; ++i)
    {
        cin >> y[i];
    }

    double h = x[1] - x[0];

    double tarX;
    cout << "Point x : ";
    cin >> tarX;

    double m[100][100] = {0};
    for (int i = 0; i < n; ++i)
    {
        m[i][0] = y[i];
    }

    double u = 0;
    double result = 0;
    for (int i = 0; i < n; ++i)
    {
        if (tarX < x[i])
        {
            break;
        }
        u = (tarX - x[i]) / h;
        result = y[i];
    }
    for (int i = 1; i < n; ++i)
    {
        for (int j = 0; j < n - i; ++j)
        {
            m[j][i] = m[j + 1][i - 1] - m[j][i - 1];
        }
    }
    
    double factor = 1;
    double tarU = 1;
    for (int i = 1; i < n; ++i)
    {
        factor = factor * i;
        double t = u * tarU / factor * m[0][i];
        result += t;
        tarU = tarU * (u - i);
    }
    cout << "Interpolation value : " << result << endl;
    return 0;
}
