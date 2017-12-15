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
