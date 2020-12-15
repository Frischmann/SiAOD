#include <iostream>
#include <limits.h>
using namespace std;

void printParenthesis(int i, int j, int n, int *bracket, char &name)
{
    if (i == j)
    {
        cout << name++;
        return;
    }

    cout << "(";

    printParenthesis(i, *((bracket + j * n) + i), n, bracket, name);

    printParenthesis(*((bracket + j * n) + i) + 1, j, n, bracket, name);
    cout << ")";
}

void matrixChainOrder(int p[], int n)
{
    int min[n][n];
    int max[n][n];

    for (int i = 1; i < n; i++)
    {
        min[i][i] = 0;
        max[i][i] = 0;
    }

    for (int L = 2; L < n; L++)
    {
        for (int i = 1; i < n - L + 1; i++)
        {
            int j = i + L - 1;
            min[i][j] = INT_MAX;
            max[i][j] = INT_MIN;
            for (int k = i; k <= j - 1; k++)
            {
                int q = min[i][k] + min[k + 1][j] + p[i - 1] * p[k] * p[j];
                if (q < min[i][j])
                {
                    min[i][j] = q;
                    min[j][i] = k;
                }

                if (q >= max[i][j])
                {
                    max[i][j] = q;
                    max[j][i] = k;
                }
            }
        }
    }

    char matrixName = 'A';
    cout << "Оптимальная расстановка скобок: ";
    printParenthesis(1, n - 1, n, (int *) min, matrixName);
    cout << "\nМинимальное количество скалярных операций : " << min[1][n - 1] << endl;

    matrixName = 'A';
    cout << "\nНеоптимальная расстановка скобок: ";
    printParenthesis(1, n - 1, n, (int *) max, matrixName);
    cout << "\nМаксимальное количество скалярных операций : " << max[1][n - 1];
}


int main()
{
    setlocale(LC_ALL, "Russian");

    int arr[] = {5, 10, 3, 12, 5, 50, 6};

    int n = sizeof(arr) / sizeof(arr[0]);
    matrixChainOrder(arr, n);

    return 0;
}