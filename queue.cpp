//1.     Enter some integers, and press “enter” after each one.

//2.     Entering the integer 0 will end the process of entering the integers

//3.     The program will then print out the first remaining member of the queue one at a time.

//4.     It will then print the number of integers remaining it the queue

//5.     The 0 will not be printed, nor counted as one of the remaining integers.

#include <iostream> // library for manipulating output
#include <queue>

using namespace std;

int main()
{
    queue <int> q;

    cout << "Please enter some integers (enter 0 to end):\n";

    //reading integers
    while (true) 
	{
        int Number_Entry;
        cin >> Number_Entry;

        //if user decided to stop entering data
        if (Number_Entry == 0)
		{
            break;
        }

        q.push(Number_Entry);
    }

    while (q.empty() == false)
	{
        cout << "This was the front of the queue:\n " << q.front() << "\n";
        q.pop();

        cout << "The queue now has this many integers:\n " << q.size() << "\n\n";
    }
	system("pause");
    return 0;
}
