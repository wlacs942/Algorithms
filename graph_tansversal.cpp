
/*
	Wesley Shaw
	Program demo
	flight distance calculator using DFS transversal of a graph.  
	The main purpose of the program is to demonstrates the application of graphs, and the way to manipulate data with them. 

	-My program  starts with a console prompt to log their choice of departure and arrival cities from a static list of 4 cities.

	-The program then saves their choice and saves that data into variables

	-The program then calculates the fastest route from departure city to arrival city. This is done by graph data structure.

	-The graph used is weighted meaning the lines between vertices(cities) have varying distances. The distances cannot be                   
 		changed, they are hardcoded and included in a header file

	- not all  flights are direct, meaning to get to point B you'll need a layover at C where perhaps C and D share a direct flight.  
  	 	this is done by looking at corresponding edges and if they match (0,1) and (1,0) 1 and 0 have direct flight
  
	-the graph once created is searched to find the shortest path between arrival city and departure city

	-this is done using DFS algorithm that back tracks through the edges between vertices to find the optimal path

	-the output consists of a prompt that informs the user if the flight is a direct flight or indirect, 
  		and the total miles the flight is between arrival and departure city.
*/
#include<iostream>
#include<list>
#include<iostream>
#include<string>
using namespace std;

string str;
string arrivalCityStr;
bool directFlightBool = true;//flight is a direct flight if true
int location;//location of arrival flight 
string num;
// Graph class represents a directed graph using adjacency list representation
class Graph
{
	int V;    // No. of vertices, how many verticies
	
	
	list<int> *adj;    // Pointer to an array containing adjacency lists
	void DFSUtil(int v, bool visited[]);  // A function used by DFS
	
public:
	
	void directFlight(int departure, int arrival);
	void stringStuff(string str, int arrivalCity);
	Graph(int V);   // Constructor
	void addEdge(int v, int w);   // function to add an edge to graph
	void DFS(int v);    // DFS traversal of the vertices reachable from v
};

Graph::Graph(int V)
{
	this->V = V;
	adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
	adj[v].push_back(w); // Add w to v’s list.
}

void Graph::DFSUtil(int v, bool visited[])
{
	
				  // Mark the current node as visited and print it
	visited[v] = true;
	
	str += to_string(v);
	
	

	// Recur for all the vertices adjacent to this vertex
	list<int>::iterator i;
	for (i = adj[v].begin(); i != adj[v].end(); ++i)
		if (!visited[*i]) {
			
			DFSUtil(*i, visited);
		}
	
}

void Graph::stringStuff(string str,int arrivalCity) {
	
	if(!directFlightBool) { //if indirect flight
		arrivalCityStr = to_string(arrivalCity);
		location = str.find(arrivalCityStr);
		cout << "Indirect Connection between ";
		for (int i = 0; i < location; i++) {
			num = str.at(i);
			if (num == "0") {

			}
		}

	}

}

void Graph::directFlight(int departure, int arrival) {
	if ((departure == 0 && arrival == 1) || (departure == 1 && arrival == 0)) {
		directFlightBool = true;
	}
	else if ((departure == 0 && arrival == 2) || (departure == 2 && arrival == 0)) {
		directFlightBool = true;
	}
	else if((departure == 2 && arrival == 1) || (departure == 1 && arrival == 2)) {
		directFlightBool = true;
	}
	else if((departure == 2 && arrival == 3) || (departure == 3 && arrival == 2)) {
		directFlightBool = true;
	}
	else if((departure == 3 && arrival == 4) || (departure == 4 && arrival == 3)) {
		directFlightBool = true;
	}
	else {
		directFlightBool = false;
	}
	

}

// DFS traversal of the vertices reachable from v. It uses recursive DFSUtil()
void Graph::DFS(int v)
{
	// Mark all the vertices as not visited
	bool *visited = new bool[V];
	for (int i = 0; i < V; i++)
		visited[i] = false;

	// Call the recursive helper function to print DFS traversal
	DFSUtil(v, visited);
}
////copy array

int main()
{
	bool programRunning = true; //while Exit isnt chosen by user
	int userInput;
	int departureCity;
	int arrivalCity;
	
	while (programRunning) {
		cout << "\n1.Choose departure city\n";
		cout << "2.Exit\n";
		cin >> userInput;
		if (userInput == 1) {
			// Create a graph given in the above diagram
			Graph g(5); /// v num ber of verticies
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 0);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 1);
			g.addEdge(2, 3);
			g.addEdge(3, 2);
			g.addEdge(3, 4);
			g.addEdge(4, 3);
			cout << "Departure Cities\n";
			cout << "0.Los Angeles\n";
			cout << "1.Tokyo\n";
			cout << "2.New York\n";
			cout << "3.London\n";
			cout << "4.Berlin\n";
			cin >> departureCity;///user input departure city
			cout << "Choose Arrival City:\n";
			cout << "0.Los Angeles\n";
			cout << "1.Tokyo\n";
			cout << "2.New York\n";
			cout << "3.London\n";
			cout << "4.Berlin\n";
			cin >> arrivalCity; ///user input arrival city
			g.directFlight(departureCity, arrivalCity); 
			g.DFS(departureCity); ///// accept user input as start vertex
			g.stringStuff(str, arrivalCity);
			str = ""; //clear str
			
		}
		else {
			programRunning = false;
		}
	}
	return 0;
}
