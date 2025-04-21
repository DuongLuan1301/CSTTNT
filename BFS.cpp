#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector <int> adj[8];
bool visited[8] = {false};
int count1 = 1, count2 = 1;

void BFS(int s) {
    queue <int> q;
    q.push(s);
    visited[s] = true;

    while(!q.empty()) {
        int v = q.front();
        q.pop();
        cout << v << " ";
        for(auto x : adj[v]) {
            if(!visited[x]) {
                q.push(x);
                visited[x] = true;
                count1++;
            }
        }
    }
    cout << endl;
}

int main() {
    adj[0].push_back(1);
    adj[1].push_back(0);
    adj[1].push_back(2);
    adj[1].push_back(3);
    adj[2].push_back(1);
    adj[2].push_back(3);
    adj[3].push_back(1);
    adj[3].push_back(2);
    // adj[3].push_back(4);
    // adj[4].push_back(3);
    adj[4].push_back(5);
    adj[4].push_back(6);
    adj[5].push_back(4);
    adj[5].push_back(7);
    adj[6].push_back(4);
    adj[6].push_back(7);
    adj[7].push_back(5);
    adj[7].push_back(6);

    //call BFS function
    BFS(3);
    if(count1 == 8) {
        cout << "Do thi lien thong";
    }
    else {
        cout << "Do thi khong lien thong\n";
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                BFS(i);
                count2++;
            }
        }
        cout << "Do thi co " << count2 << " thanh phan lien thong";
    }

    return 0;
}