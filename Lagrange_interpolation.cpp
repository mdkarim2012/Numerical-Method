#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter size : ";
    cin >> n;
    
    double x[100], y[100];
    cout << "Enter x value:\n";
    for (int i = 0; i < n; i++) {
        cin >> x[i];

    }
    cout << "Enter Y value:\n";
    for (int i = 0; i < n; i++) {
        cin >> y[i];

    }
    double input;
    cout << "Enter the x value: ";
    cin >> input;

    double result = 0;

    for (int i = 0; i < n; i++) {
        double denom = 1;
        double nom = 1;

        for (int j = 0; j < n; j++) {
            if (i != j) {
                denom *= (x[i] - x[j]);
                nom *= (input - x[j]);
            }
        }
        
        result += (nom / denom) * y[i];
    }

    cout << "Lagranges Interpolated value:" << result << endl;

    return 0;
}
