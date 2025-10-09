#include<bits/stdc++.h>
using namespace std;

void pairDemo(){
    // single pair
    cout<<"This is the pair function: "<<"\n";
    pair<int,int> p1 = {1, 3};
    cout<<p1.first<<" "<<p1.second<<endl;

    // nesting of pairs
    pair<int,pair<int,int>> p2 = {1, {3, 4}};
    cout<<p2.first<<" "<<p2.second.first<<" "<<p2.second.second<<endl;

    // array of pairs
    pair<int,int> arr[] = {{1,2},{3,4},{5,6}};
    cout<<arr[1].second<<endl;
}

void vectorDemo(){
    // vecctor declaration
    cout<<"This is the vector function: \n";
    vector<int> v1;
    v1.push_back(1);
    v1.emplace_back(2); // faster version of push back
    v1.push_back(3);
    v1.push_back(4);
    v1.push_back(5);

    // pair of vectors
    vector<pair<int,int>> v2;
    v2.push_back({1,2});
    v2.emplace_back(3,4);

    // declaring vectors with capacity
    vector<int> v3(5,100); // {100, 100, 100, 100, 100} vector of size 5 with all the elements as 100
    vector<int> v4(5); // vector of size 5 (filled with garbage value)
    vector<int> v5(5, 20); // {20, 20, 20, 20, 20}
    
    vector<int> v6(v5); // copy the contents of v5 into v6
    // u can increase the size of the vector evn though u have declared the size in the beginning

    // accessing elements of a vector
    // 1st way: normal how we access the elements of the array
    cout<<v1[0]<<" "<<v1.at(0)<<endl;

    // vector begin n end
    vector<int>::iterator it = v1.begin(); // v.begin() - points to the memory, *(v.begin()) => points to the memory address
    it++;
    cout<<*(it)<<" ";
    cout<<*(it+2)<<"\n";
    
    vector<int>::iterator it2 = v1.end(); // points to the 'n'th value -> which is index out of bounds

    // printing the elements of the vector
    for(vector<int>::iterator itt = v1.begin(); itt!=v1.end(); itt++){
        cout<<*(itt)<<" ";
    }
    cout<<"\n";

    for(auto i1 = v1.begin(); i1 != v1.end(); i1++){
        cout<<*(i1)<<" ";
    }
    cout<<"\n";

    for(auto i2 : v1){
        cout<<i2<<" ";
    }
    cout<<"\n";

    // delete functions
    v1.erase(v1.begin()+1); // erase the element at 1th index
    v1.erase(v1.begin()+2, v1.begin()+4); // erase the element from 2th index to 4th index-1
    // [start,end) => [ => start included, ) => end not included

    // insert functions
    vector<int> v7(2,100); // {100, 100}
    v7.insert(v7.begin(),300); // {300, 100, 100}
    v7.insert(v7.begin()+1, 2, 10); // {300, 10, 10, 100, 100} => begin from 1st index, for upto 2 positions insert the number 10

    vector<int> copy(2,50); // {50, 50}
    v7.insert(v7.begin(), copy.begin(), copy.end()); // {50, 50, 300, 10, 10, 100, 100}

    cout<<v7.size()<<"\n";

    v7.pop_back(); // {50, 50,300, 10, 10, 100} => remove elements from the end

    v1.swap(v7);
    // v1: {10,20}
    // v7: {30,40}
    // swap => v1: {30,40}
    // swap => v2 : {10, 20}

    v7.clear(); // erases the entire vector

    cout<<v2.empty()<<endl;
}

void listDemo(){
    list<int> l;
    l.push_back(2);
    l.emplace_back(4);
    l.push_front(5);
    l.emplace_front(9);

    cout<<"List function\n";
    for(auto i : l){
        cout<<i<<" ";
    }
    cout<<"\n";
    // rest of the functions are same as vectors
    // begin, end, rbegin, rend, clear, insert, size, swap
}

void dequeDemo(){
    deque<int> dq;
    dq.push_back(2);
    dq.emplace_back(2);
    dq.push_front(4);
    dq.emplace_front(3);

    cout<<"Deque Function\n";
    for(auto i : dq){
        cout<<i<<" ";
    }
    cout<<"\n";
    // rest of the functions like begin, end, rbegin, rend, clear, insert, size, swap
}

void stackDemo(){
    stack<int> st;
    st.push(1);
    st.push(7);
    st.push(4);
    st.emplace(5);

    cout<<"Stack functions: \n";
    cout<<st.top()<<endl;
    st.pop();

    cout<<st.top()<<endl;
    cout<<st.size()<<endl;
    cout<<st.empty()<<endl;

    stack<int> st1, st2;
    st1.swap(st2);
}

void queueDemo(){
    queue<int> q;
    q.push(1);
    q.push(2);
    q.emplace(4);
    // {1,2,4} => {1,2,9}
    q.back() += 5; // 4+5=9

    cout<<"Queue Demo: \n";
    cout<<q.back()<<endl;

    cout<<q.front()<<endl;
    q.pop(); // {2,9}

    cout<<q.front()<<endl; // 2
}

void priorityQueueDemo(){
    // max heap
    priority_queue<int> pq;
    pq.push(5);
    pq.push(2);
    pq.push(8);
    pq.push(10);
    // {10,8,5,2}
    cout<<"Max-heap: \n";
    cout<<pq.top();
    
    pq.pop();
    
    cout<<pq.top()<<endl;

    cout<<"Min Heap: \n";
    priority_queue<int, vector<int>, greater<int>> pq1;
    pq1.push(5);
    pq1.push(2);
    pq1.push(10);
    pq1.push(8);
    // {2,5,8,10}
    cout<<pq1.top()<<endl;
}

void setDemo(){
    // set properties: stores unique elements and in sorted order
    set<int> st;
    st.insert(1); // {1}
    st.emplace(2); // {1,2}
    st.insert(2); // {1, 2}
    st.insert(4); // {1,2,4}
    st.insert(3); // {1,2,3,4}

    // begin, end, rbegin, rend, size, empty, swap are all same as above
    cout<<"Set Demo: \n";
    auto it1 = st.find(3); // start st.begin()
    auto it2 = st.find(6); // end st.end()
    
    st.erase(5);

    int cnt = st.count(1); // 1: for present, 0: for absent
    auto it3 = st.find(3);
    st.erase(it3);
    
    // remove elements in this range
    auto it4 = st.find(2);
    auto it5 = st.find(4);

    auto it7 = st.lower_bound(2);
    auto it8 = st.upper_bound(4);
}

int main(){
    pairDemo();
    vectorDemo();
    listDemo();
    dequeDemo();
    stackDemo();
    queueDemo();
    priorityQueueDemo();
    setDemo();


    return 0;
}
// cpp stl is divided into 4 parts
// 1. algorithms
// 2. containers
// 3. functions
// 4. iterators
