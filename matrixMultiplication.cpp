#include <iostream>
using namespace std;

int main()
{
    // Initialize variables and arrays
    int l, m, z, n;
    int matrixA[10][10];
    int matrixB[10][10];
    int matrixC[10][10];

    // Get dimensions of matrices to be multiplied 
    cout << "Enter the dimensions of the first matrix, rows first, then columns: ";
    cin >> l >> m;
    cout << "\nEnter the dimensions of the second matrix, rows first, then columns: ";
    cin >> z >> n;
    
    // Validation of size of matrices for multiplication
    while (m!=z) 
    {
        cout <<"Error. The columns of the first matrix must equal the rows of the second matrix.";
        cout <<"Please re-enter the dimensions of the first matrix, rows first, then columns: ";
        cin >> l >> m;
        cout <<"Please re-enter the dimensions of the first matrix, rows first, then columns: ";
        cin >> z >> n;
    }

    // Obtain data for first matrix 
    cout<<"\nEnter each number in the first matrix, starting with a11, a12, ..., a1n, \n"
          "then a21, a22, ... a2n, etc... :" << endl;
    for (int i = 0; i < l; i++)
        {   for (int j = 0; j < m; j++)
            {   cin >> matrixA[i][j];
            }
        }
    
    // Obtain data for second matrix
    cout<<"Enter each number in the second matrix, starting with b11, b12, ..., b1n, \n"
          "then b21, b22, ... b2n, etc... :" << endl;
    for (int i = 0; i < z; i++)
        {   for (int j = 0; j < n; j++)
            {   cin >> matrixB[i][j];
            }
        }
    
    // Multiply matrices using iteration 
    for (int i = 0; i < l; i++)
        {   for (int j = 0; j < n; j++)
            {   matrixC[i][j]=0;
                for (int k = 0; k < m; k++)
                {
                    matrixC[i][j] = matrixC[i][j]+(matrixA[i][k] * matrixB[k][j]);
                }
            }
         }

    // Display resulting matrix
    cout << "\nThe answer is: " << endl;
    for (int i = 0; i < l; i++)
    {   for (int j = 0; j < n; j++)
        {   cout << matrixC[i][j] << " ";
        }
        cout <<endl;
    }
    return 0;
}
